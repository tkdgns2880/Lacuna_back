package LacunaMatata.Lacuna.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOptionalInfo {
    private int userOptionId;
    private int userId;
    private Date birthDate;
    private int gender;
    private String phoneNumber;
    private String address;
    private String profileImg;
    private int marketingOptIn;
    private int thirdPartyInfoSharingConsent;
}
