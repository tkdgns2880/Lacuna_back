package LacunaMatata.Lacuna.dto.request.user.user;

import lombok.Data;

@Data
public class ReqGetMyOrderInfoDto {
    private String startDate;
    private String endDate;
    private String searchValue;
}
