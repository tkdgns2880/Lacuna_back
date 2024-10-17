package LacunaMatata.Lacuna.dto.request.admin.manageuser;

import lombok.Data;

@Data
public class ReqModifyUserDto {
    private int inactiveFlag;
    private int roleId;
}
