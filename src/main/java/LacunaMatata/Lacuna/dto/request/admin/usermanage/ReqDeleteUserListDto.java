package LacunaMatata.Lacuna.dto.request.admin.usermanage;

import lombok.Data;

import java.util.List;

@Data
public class ReqDeleteUserListDto {
    private List<Integer> userIdList;
}
