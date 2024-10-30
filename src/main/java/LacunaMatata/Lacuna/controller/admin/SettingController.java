package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.settinginfo.ReqModifySettingInfoDto;
import LacunaMatata.Lacuna.dto.response.admin.settinginfo.RespSettingInfoDto;
import LacunaMatata.Lacuna.service.admin.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: SettingController()-세팅         *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@RequestMapping("/api/v1/admin/settings")
public class SettingController {

    @Autowired
    private SettingService settingService;

    // 설정(약관 email, phone, sns 주소 등) 정보 불러오기
    @GetMapping("/")
    ResponseEntity<?> getSettingList() {
        List<RespSettingInfoDto> settingInfo = settingService.getSettingInfo();
        return ResponseEntity.ok().body(settingInfo);
    }

    // 설정(약관 email, phone, sns 주소 등) 항목 수정
    @PutMapping("/modify/{settingId}")
    ResponseEntity<?> modifySetting(@RequestBody ReqModifySettingInfoDto dto, @PathVariable int settingId) {
        System.out.println("요청 데이터: "+dto);
        settingService.modifySettingInfo(dto);
        return ResponseEntity.ok().body(true);
    }
}
