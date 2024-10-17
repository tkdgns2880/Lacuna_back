package LacunaMatata.Lacuna.dto.request.admin.manageuser;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReqRegisterUserDto {
    private int roleId;
    private int inactiveFlag;
    private String username;
    private String email;
    private String name;
    private String password;
    private LocalDateTime birthDate;
    private int gender;
    private String phoneNumber;
}
