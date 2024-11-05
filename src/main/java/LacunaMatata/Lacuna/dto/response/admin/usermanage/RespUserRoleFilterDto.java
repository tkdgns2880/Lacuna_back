package LacunaMatata.Lacuna.dto.response.admin.usermanage;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespUserRoleFilterDto {
    private int roleId;
    private String roleName;
}
