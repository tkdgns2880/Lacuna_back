package LacunaMatata.Lacuna.dto.response.user.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespSigninDto {
    private String loginIp;
    private Data loginTime;
}
