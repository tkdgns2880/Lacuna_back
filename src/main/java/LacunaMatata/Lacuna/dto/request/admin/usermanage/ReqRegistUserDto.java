package LacunaMatata.Lacuna.dto.request.admin.usermanage;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ReqRegistUserDto {
    private int roleId;
    private String username;
    private String email;
    private String name;
    private String password;
    private String checkPassword;
    private Date birthDate;
    private int gender;
    private String phoneNumber;
}
