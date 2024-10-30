package LacunaMatata.Lacuna.dto.response.admin.usermanage;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCountAndUserListDto {
    private int totalCount;
    private List<RespGetUserListDto> userList;
}
