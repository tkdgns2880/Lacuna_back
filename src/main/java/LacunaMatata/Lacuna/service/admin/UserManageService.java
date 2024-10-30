package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqGetUserListDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespCountAndUserListDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespGetUserListDto;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.repository.admin.UserManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserManageService {

    @Autowired
    private UserManageMapper userManageMapper;

    // 사용자 정보 리스트 출력
    public RespCountAndUserListDto getUserInfoList(ReqGetUserListDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "filter", dto.getFilter(),
                "option", dto.getOption(),
                "searchValue", dto.getSearchValue(),
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        List<User> userList = userManageMapper.getUserList(params);
        List<RespGetUserListDto> respGetUserListDtos = new ArrayList<>();

        for(User user : userList) {
            Map<Integer, String> roleMap = user.getUserRoleMets().stream()
                    .collect(Collectors.toMap(
                    rolemet -> rolemet.getUserRole().getRoleId(), rolemet -> rolemet.getUserRole().getRoleName()
            ));

            Integer maxRoleId = roleMap.keySet().stream().max(Integer::compare).orElse(1);
            String roleName = (maxRoleId != null) ? roleMap.get(maxRoleId) : null;

            RespGetUserListDto respGetUserListDto = RespGetUserListDto.builder()
                    .userId(user.getUserId())
                    .roleName(roleName)
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .name(user.getName())
                    .gender(user.getUserOptionalInfo().getGender())
                    .birthDate(user.getUserOptionalInfo().getBirthDate())
                    .createdDate(user.getCreateDate())
                    .loginTime(user.getLoginHistory().getLoginTime())
                    .loginIp(user.getLoginHistory().getLoginIp())
                    .email(user.getEmail())
                    .inactive(user.getInactive())
                    .build();
            respGetUserListDtos.add(respGetUserListDto);
        }
        RespCountAndUserListDto respCountAndUserListDto = RespCountAndUserListDto.builder()
                .totalCount(respGetUserListDtos.size())
                .userList(respGetUserListDtos)
                .build();

        return respCountAndUserListDto;
    }

    // 사용자 등록
    public void registerUser() {

    }

    // 사용자 수정
    public void modifyUser() {

    }

    // 사용자 삭제
    public void deleteUser() {

    }

    // 사용자 복수개 삭제
    public void deleteUserList() {

    }
}
