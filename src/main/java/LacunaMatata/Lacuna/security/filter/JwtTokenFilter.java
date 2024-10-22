package LacunaMatata.Lacuna.security.filter;


import LacunaMatata.Lacuna.entity.user.InactiveAccount;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.security.jwt.JwtProvider;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

/************************************
 * version: 1.0.2                   *
 * author: 손경태                    *
 * description: JwtTokenFilter      *
 * createDate: 2024-10-10           *
 * updateDate: 2024-10-10           *
 ***********************************/
@Component
public class JwtTokenFilter extends GenericFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String bearerAccessToken = httpServletRequest.getHeader("Authorization");

        if(bearerAccessToken == null || bearerAccessToken.isBlank()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String accessToken = jwtProvider.removeBearer(bearerAccessToken);

        Boolean isActiveUser = true;

        try {
            Claims claims = jwtProvider.getClaim(accessToken);
            int userId = ((Integer) claims.get("userId")).intValue();
            User user = userMapper.findUserByUserId(userId);
            if(user == null) {
                throw new JwtException("해당 id의 사용자를 찾지 못했습니다");
            }

            // 아이디와 비밀번호가 일치했을 때 해당 계정이 휴면 상태인지 확인하기 위해 휴면 정보 불러오기
            InactiveAccount inactiveAccount = userMapper.findInactiveAccountByUserId(user.getUserId());

            PrincipalUser principalUser = user.toPrincipal(inactiveAccount.getLastActiveDate());

            // 휴면만료 검사 결과가 false(휴면 계정 상태)이면 휴면 계정 여부(flag 값)을 2로 수정후 다음 필터에서 오류 발생하게끔
            if(principalUser.isAccountNonExpired() == false) {
                userMapper.changeInactiveFlagDisable(userId);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch(JwtException e) {
            e.printStackTrace();
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}