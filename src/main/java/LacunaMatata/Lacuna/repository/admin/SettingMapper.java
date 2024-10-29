package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.entity.Setting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SettingMapper {

    // 1. 세팅(이용약관, 관리자 전화번호, 이용약관 등) 정보 불러오기_2024.10.29
    List<Setting> getSettingInfoList();
    // 2. 세팅 정보 수정_2024.10.29
    int modifySettingInfo(String value, int settingId);
}
