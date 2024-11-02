package LacunaMatata.Lacuna.controller.admin;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/service/statistics")
@Api(tags = {"statisticsController"})
public class StatisticsController {

    @PostMapping("/service/statistic")
    public ResponseEntity<?> registCounting() {return ResponseEntity.ok().body(null);
    }
}
