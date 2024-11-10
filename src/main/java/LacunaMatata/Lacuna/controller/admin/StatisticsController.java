package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetUseCountDto;
import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqMbtiStatisticDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespTotalAndUseCountDto;
import LacunaMatata.Lacuna.service.admin.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/statistics")
@Api(tags = {"statisticsController"})
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @ApiOperation(value = "getUseCountingApi")
    @GetMapping("/service/statistic")
    public ResponseEntity<?> getUseCounting(ReqGetUseCountDto dto) {
        RespTotalAndUseCountDto useCount = statisticsService.getUseCount(dto);
        return ResponseEntity.ok().body(useCount);
    }

    @ApiOperation(value = "mbtiStatisticApi")
    @GetMapping("/mbti")
    public ResponseEntity<?> mbtiStatistic(ReqMbtiStatisticDto dto) {
        return ResponseEntity.ok().body(statisticsService.respAllCountDto(dto));
    }


}
