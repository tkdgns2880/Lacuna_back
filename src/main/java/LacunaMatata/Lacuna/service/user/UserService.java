package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileDto;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public RespMyProfileDto getMyProfile() {
        PrincipalUser principalUser
                = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();

        User user = userMapper.findUserByUserId(userId);
        RespMyProfileDto respMyProfileDto = RespMyProfileDto.builder()
                .name(user.getName())
                .phoneNumber(user.getUserOptionalInfo().getPhoneNumber())
                .email(user.getEmail())
                .profileImg(user.getUserOptionalInfo().getProfileImg())
                .build();
        return respMyProfileDto;
    }
}
