package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.service.user.MbtiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mbti/survey")
@Api(tags = {"MbtiController"})
public class MbtiController {

    @Autowired
    private MbtiService mbtiService;

    // mbti 설문지 출력
    @GetMapping("/question")
    @ApiOperation(value = "getMbtiSurveyApi")
    public ResponseEntity<?> getMbtiSurvey() {
        return ResponseEntity.ok().body(mbtiService.getmbtiSurvey());
    }

    // mbti 설문 답안 등록
    @GetMapping("/submit")
    @ApiOperation(value = "submitMbtiApi")
    public ResponseEntity<?> submitMbti() {
        return ResponseEntity.ok().body(true);
    }

    // mbti 설문 결과 출력
    @GetMapping("/result")
    @ApiOperation(value = "getMbtiResultApi")
    public ResponseEntity<?> getMbtiResult() {
        return ResponseEntity.ok().body(true);
    }
}
