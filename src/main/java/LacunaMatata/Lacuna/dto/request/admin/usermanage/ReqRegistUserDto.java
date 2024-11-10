package LacunaMatata.Lacuna.dto.request.admin.usermanage;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ReqRegistUserDto {
    private int roleId;
    private String username;
    private String password;
    private String passwordCheck;
    private String email;
    private String name;
    private Date birthDate;
    private int gender;
    private String phoneNumber;
    private String profileImg;
}
