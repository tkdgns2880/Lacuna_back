package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.dto.response.admin.settinginfo.RespSettingInfoDto;
import LacunaMatata.Lacuna.service.user.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Api(tags = "CommonController")
public class CommonController {

    @Autowired
    private CommonService commonService;

    // 사용자 페이지에 Setting 정보 불러오기
    @GetMapping("/setting/info")
    @ApiOperation(value = "getSettingInfoApi")
    public ResponseEntity<?> getSettingInfo() {
        List<RespSettingInfoDto> settingInfo = commonService.getSettingInfo();
        return ResponseEntity.ok().body(settingInfo);
    }


    @GetMapping("/index")
    @ApiOperation(value = "getCountIndexApi")
    public ResponseEntity<?> getCountIndex() {
        commonService.getCountIntroPage();
        return ResponseEntity.ok().body(true);
    }
}
