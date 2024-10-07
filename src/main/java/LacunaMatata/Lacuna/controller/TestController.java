package LacunaMatata.Lacuna.controller;

import LacunaMatata.Lacuna.dto.request.ReqTestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************************************
 * version: 1.0.0                   *
 * author: 권오광                    *
 * description: TestController      *
 * createDate: 2024-10-07           *
 * updateDate: 2024-10-07           *
 ***********************************/
@Slf4j
@Api(tags = {"Controller 이름"})
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "Test API")
    @GetMapping("/test")
    public ResponseEntity<?> access(ReqTestDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(null);
    }
}