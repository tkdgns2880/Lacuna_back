package LacunaMatata.Lacuna.dto.response.admin.usermanage;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespUserDetailDto {
    private int userId;
    private String username;
    private String roleName;
    private String email;
    private String name;
    private String inactiveFlag;
}
