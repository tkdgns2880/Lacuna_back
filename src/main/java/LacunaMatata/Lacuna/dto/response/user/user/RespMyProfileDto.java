package LacunaMatata.Lacuna.dto.response.user.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespMyProfileDto {
    private String name;
    private String phoneNumber;
    private String email;
    private String profileImg;
    private int marketingReceiveAgreement;
    private String kakaoAddress;
}
