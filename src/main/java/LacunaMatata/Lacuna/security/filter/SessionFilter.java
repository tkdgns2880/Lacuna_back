package LacunaMatata.Lacuna.security.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 세션 객체는 HttpServletRequest에 있음
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        // 세션 얻어오기
        // true - 세션이 없으면 새로 생성함, false -> 기존의 세션이 없으면 null 반환
        HttpSession session = httpRequest.getSession(false);

        if(session != null) {
            // 세션 만료시간 설정 - 초 단위
            session.setMaxInactiveInterval(30 * 60);

            // 마지막 접근 시간과 세션 만료 시간
            long lastAccessTime = session.getLastAccessedTime();
            long maxInactiveInterval = session.getMaxInactiveInterval();

            // 현재 시간
            long now = System.currentTimeMillis();

            if(now - lastAccessTime > maxInactiveInterval * 1000L) {
                session.invalidate();
                return;
            }
        }

        // 세션이 유효하거나 없는경우(새로운 세션이 필요한 경우) 계속 진행
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
