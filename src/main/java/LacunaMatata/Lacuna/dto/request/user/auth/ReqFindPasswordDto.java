package LacunaMatata.Lacuna.dto.request.user.auth;

import lombok.Data;

@Data
public class ReqFindPasswordDto {
    private String toEmail;
    private String username;
}
