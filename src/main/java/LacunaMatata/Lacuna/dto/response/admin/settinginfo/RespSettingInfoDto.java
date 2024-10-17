package LacunaMatata.Lacuna.dto.response.admin.settinginfo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespSettingInfoDto {
    private String dataType;
    private String value;
}
