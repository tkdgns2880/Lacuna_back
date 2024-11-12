package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetUseCountDto;
import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetStatisticCountsDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespTotalAndUseCountDto;
import LacunaMatata.Lacuna.service.admin.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/statistics")
@Api(tags = {"관리자 - 통계 관리 컨트롤러"})
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    // 관리자 첫 페이지 랜더링 시 초기 데이터 값
//    @GetMapping("/init/statistic")
//    @ApiOperation(value = "getInitStatisticApi")
//    public ResponseEntity<?> getInitStatistic() {
//        return ResponseEntity.ok().body(statisticsService.getInitData());
//    }

    // 관리자 대시보드 이용통계 날짜 필터
    @ApiOperation(value = "대시보드 - 서비스 이용자 수 통계 출력")
    @GetMapping("/service")
    public ResponseEntity<?> getUseCounting(ReqGetUseCountDto dto) {
        RespTotalAndUseCountDto useCount = statisticsService.getUseCount(dto);
        return ResponseEntity.ok().body(useCount);
    }

    // 관리자 mbti 통계 날짜 필터
    @ApiOperation(value = "대시보드 - mbti 응답 상세 분석 출력")
    @GetMapping("/mbti")
    public ResponseEntity<?> getMbtiStatisticCount(ReqGetStatisticCountsDto dto) {
        return ResponseEntity.ok().body(statisticsService.getMbtiStatisticCounts(dto));
    }

}
