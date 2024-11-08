package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.dto.request.user.mbti.ReqMbtiAnswerDto;
import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiSurveyResultDto;
import LacunaMatata.Lacuna.service.user.MbtiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/mbti/survey")
@Api(tags = {"MbtiController"})
public class MbtiController {

    @Autowired
    private MbtiService mbtiService;

    // mbti 설문지 기본 정보(피부고민 리스트) 출력
    @GetMapping("/question/skinproblem")
    @ApiOperation(value = "getMbtiSkinProblemApi")
    public ResponseEntity<?> getMbtiSkinProblem() {
        return ResponseEntity.ok().body(mbtiService.getMbtiSkinProblemList());
    }

    // mbti 설문지 출력
    @GetMapping("/question")
    @ApiOperation(value = "getMbtiSurveyApi")
    public ResponseEntity<?> getMbtiSurvey() {
        return ResponseEntity.ok().body(mbtiService.getmbtiSurvey());
    }

    // mbti 설문 답안 등록
    @PostMapping("/submit")
    @ApiOperation(value = "submitMbtiApi")
    public ResponseEntity<?> submitMbti(@RequestBody ReqMbtiAnswerDto dto, HttpServletRequest request) {
        mbtiService.submitMbti(dto, request);
        return ResponseEntity.ok().body(true);
    }

    // mbti 설문 결과 출력
    @GetMapping("/result/{resultId}")
    @ApiOperation(value = "getMbtiResultApi")
    public ResponseEntity<?> getMbtiResult(@PathVariable int resultId) {
        RespMbtiSurveyResultDto mbtiResult = mbtiService.getMbtiResult(resultId);
        return ResponseEntity.ok().body(mbtiResult);
    }
}
