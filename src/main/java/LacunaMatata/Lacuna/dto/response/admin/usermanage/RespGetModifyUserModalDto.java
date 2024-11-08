package LacunaMatata.Lacuna.dto.response.admin.usermanage;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespGetModifyUserModalDto {
    private int userId;
    private int roleId;
    private String roleName;
    private String inactive;
    private String username;
    private String email;
    private String name;
    private List<RespUserRoleFilterDto> userRoleList;
}
