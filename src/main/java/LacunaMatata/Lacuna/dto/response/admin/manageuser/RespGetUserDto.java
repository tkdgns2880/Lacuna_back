package LacunaMatata.Lacuna.dto.response.admin.manageuser;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespGetUserDto {
    private int userId;
    private String roleName;
    private String username;
    private String password;
    private String name;
    private int gender;
    private LocalDateTime birthDate;
    private LocalDateTime createdDate;
    private LocalDateTime loginTime;
    private String loginIp;
    private String email;
}
