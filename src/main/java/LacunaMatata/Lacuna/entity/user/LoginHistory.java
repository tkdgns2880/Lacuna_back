package LacunaMatata.Lacuna.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginHistory {
    private int loginHistoryId;
    private int loginUserId;
    private LocalDateTime loginTime;
    private String loginIp;
}
