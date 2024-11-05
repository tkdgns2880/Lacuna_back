package LacunaMatata.Lacuna.controller.user;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mbti/survey")
@Api(tags = {"MbtiController"})
public class MbtiController {

    @GetMapping("")
    ResponseEntity<?> getMbtiSurvey() {
        return ResponseEntity.ok().body(true);
    }
}
