package LacunaMatata.Lacuna.dto.request.admin.usermanage;

import lombok.Data;

@Data
public class ReqGetUserListDto {
    private int filter; // roleId 들어옴
    private int option;
    private String searchValue;
    private int page;
    private int limit;
}
