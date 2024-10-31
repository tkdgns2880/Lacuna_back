package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.service.admin.ConsultingManageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************************************************
 * version: 1.0.4                               *
 * author: 정령우                                *
 * description: AdminMbtiController() - 세팅     *
 * createDate: 2024-10-30                       *
 * updateDate: 2024-10-30                       *
 ************************************************/

@RestController
@RequestMapping("/api/v1/admin/consulting")
@Api(tags = {"consultingManageController"})
public class ConsultingManageController {

    @Autowired
    private ConsultingManageService consultingManageService;

    // 컨설팅 상위 분류 목록 출력
    @GetMapping("/upper/list")
    ResponseEntity<?> getUpperConsultingListApi() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 출력(필터)
    @GetMapping("/upper/filter")
    ResponseEntity<?> getUpperConsultingListFilter() {return ResponseEntity.ok().body(null); }

    // 컨설팅 상위 분류 항목 등록
    @PostMapping("/upper/regist")
    ResponseEntity<?> registUpperConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 출력
    @GetMapping("/upper/{upperId}")
    ResponseEntity<?> getUpperConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 수정
    @PutMapping("/upper/modify/{upperId}")
    ResponseEntity<?> modifyUpperConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 삭제
    @DeleteMapping("/upper/delete/{upperId}")
    ResponseEntity<?> deleteUpperConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 복수개 삭제
    @DeleteMapping("/upper/delete")
    ResponseEntity<?> deleteUpperConsultingList() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 목록 출력
    @GetMapping("/lower/list")
    ResponseEntity<?> getLowerConsultingListApi() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 출력 (필터)
    @GetMapping("/lower/list/filter/{upperId}")
    ResponseEntity<?> getLowerConsultingListFilter() {return ResponseEntity.ok().body(null); }

    // 컨설팅 하위 분류 항목 등록
    @PostMapping("/lower/regist")
    ResponseEntity<?> registLowerConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 출력
    @GetMapping("/lower/{upperId}")
    ResponseEntity<?> getLowerConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 수정
    @PutMapping("/lower/modify/{upperId}")
    ResponseEntity<?> modifyLowerConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 삭제
    @DeleteMapping("/lower/delete/{upperId}")
    ResponseEntity<?> deleteLowerConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 복수개 삭제
    @DeleteMapping("/lower/delete")
    ResponseEntity<?> deleteLowerConsultingList() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 목록 출력
    @GetMapping("/servey/list")
    ResponseEntity<?> getServeyConsultingListApi() {
        return ResponseEntity.ok().body(null);
    }


    // 컨설팅 설문지 항목 등록
    @PostMapping("servey/regist")
    ResponseEntity<?> registServeyConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 출력
    @GetMapping("/servey/{consultingId}")
    ResponseEntity<?> getServeyConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 수정
    @PutMapping("/servey/modify")
    ResponseEntity<?> modifyServeyConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 삭제
    @DeleteMapping("/servey/delete/{consultingId}")
    ResponseEntity<?> deleteServeyConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 복수개 삭제
    @DeleteMapping("/servey/delete")
    ResponseEntity<?> deleteServeyConsultingList() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 목록 출력
    @GetMapping("/servey/result/list")
    ResponseEntity<?> getResultConsultingListApi() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 등록
    @PostMapping("/servey/result/regist")
    ResponseEntity<?> registResultConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 출력
    @GetMapping("/servey/result/{resultId}")
    ResponseEntity<?> getResultConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 수정
    @PutMapping("/servey/result/modify/{resultId}")
    ResponseEntity<?> modifyResultConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 삭제
    @DeleteMapping("/servey/result/delete/{resultId}")
    ResponseEntity<?> deleteResultConsulting() {
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 복수개 삭제
    @DeleteMapping("/servey/result/delete")
    ResponseEntity<?> deleteResultConsultingList() {
        return ResponseEntity.ok().body(null);
    }
}
