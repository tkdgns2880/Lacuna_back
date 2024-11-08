package LacunaMatata.Lacuna.dto.response.user.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespMyProfileHeaderDto {
    private String roleName;
    private String profileImg;
}
