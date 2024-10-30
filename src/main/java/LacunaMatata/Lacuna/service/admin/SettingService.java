package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.settinginfo.ReqModifySettingInfoDto;
import LacunaMatata.Lacuna.dto.response.admin.settinginfo.RespSettingInfoDto;
import LacunaMatata.Lacuna.entity.Setting;
import LacunaMatata.Lacuna.repository.admin.SettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    // 설정(약관 email, phone, sns 주소 등) 정보 출력
    public List<RespSettingInfoDto> getSettingInfo() {
        List<Setting> settings = settingMapper.getSettingInfoList();
        List<RespSettingInfoDto> respSettingInfo = new ArrayList<RespSettingInfoDto>();
        for(Setting setting : settings) {
            RespSettingInfoDto respSettingInfoDto = RespSettingInfoDto.builder()
                    .settingId(setting.getSettingId())
                    .dataType(setting.getDataType())
                    .value(setting.getValue())
                    .build();
            respSettingInfo.add(respSettingInfoDto);
        }
        return respSettingInfo;
    }

    // 설정(약관 email, phone, sns 주소 등) 정보 수정
    public void modifySettingInfo(ReqModifySettingInfoDto dto) {
        int modifySettingId = dto.getSettingId();
        String modifySettingValue = dto.getValue();
        settingMapper.modifySettingInfo(modifySettingValue, modifySettingId);
    }
}