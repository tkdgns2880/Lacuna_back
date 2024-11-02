package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.Consulting.ReqRegistUpperConsultingCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.mbti.ReqModifyUpperConsulingCategoryDto;
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
    public ResponseEntity<?> getUpperConsultingListApi() {
        consultingManageService.getUpperConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 출력(필터)
    @GetMapping("/upper/filter")
    public ResponseEntity<?> getUpperConsultingListFilter() {
        consultingManageService.getUpperConsultingFilter();
    return ResponseEntity.ok().body(null); }

    // 컨설팅 상위 분류 항목 등록
    @PostMapping("/upper/regist")
    public ResponseEntity<?> registUpperConsulting(@RequestBody ReqRegistUpperConsultingCategoryDto dto) {
        consultingManageService.registUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 출력
    @GetMapping("/upper/{upperId}")
    public ResponseEntity<?> getUpperConsulting(@PathVariable int upperId) {
        consultingManageService.getUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 수정
    @PutMapping("/upper/modify/{upperId}")
    public ResponseEntity<?> modifyUpperConsulting(@RequestBody ReqModifyUpperConsulingCategoryDto dto) {
        consultingManageService.modifyUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 삭제
    @DeleteMapping("/upper/delete/{upperId}")
    public ResponseEntity<?> deleteUpperConsulting(@PathVariable int upperId) {
        consultingManageService.deleteUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 복수개 삭제
    @DeleteMapping("/upper/delete")
    public ResponseEntity<?> deleteUpperConsultingList() {
        consultingManageService.deleteUpperConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 목록 출력
    @GetMapping("/lower/list")
    public ResponseEntity<?> getLowerConsultingListApi() {
        consultingManageService.getLowerConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 출력 (필터)
    @GetMapping("/lower/list/filter/{upperId}")
    public ResponseEntity<?> getLowerConsultingListFilter(@PathVariable int upperId) {
        consultingManageService.getLowerConsultingFilter();
        return ResponseEntity.ok().body(null); }

    // 컨설팅 하위 분류 항목 등록
    @PostMapping("/lower/regist")
    public ResponseEntity<?> registLowerConsulting() {
        consultingManageService.registLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 출력
    @GetMapping("/lower/{upperId}")
    public ResponseEntity<?> getLowerConsulting(@PathVariable int upperId) {
        consultingManageService.getLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 수정
    @PutMapping("/lower/modify/{upperId}")
    public ResponseEntity<?> modifyLowerConsulting() {
        consultingManageService.modifyLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 삭제
    @DeleteMapping("/lower/delete/{upperId}")
    public ResponseEntity<?> deleteLowerConsulting(@PathVariable int upperId) {
        consultingManageService.deleteLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 복수개 삭제
    @DeleteMapping("/lower/delete")
    public ResponseEntity<?> deleteLowerConsultingList() {
        consultingManageService.deleteLowerConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 목록 출력
    @GetMapping("/servey/list")
    public ResponseEntity<?> getServeyConsultingListApi() {
        consultingManageService.getServeyList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 선택지 타입 항목 출력
    @GetMapping("/servey/option/filter/{consultingId}")
    public ResponseEntity<?> getServeyConsultingOptionFilter(@PathVariable int consultingId) {
        consultingManageService.getServeyOption();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 등록
    @PostMapping("servey/regist")
    public ResponseEntity<?> registServeyConsulting() {
        consultingManageService.registServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 출력
    @GetMapping("/servey/{consultingId}")
    public ResponseEntity<?> getServeyConsulting(@PathVariable int consultingId) {
        consultingManageService.getServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 수정
    @PutMapping("/servey/modify")
    public ResponseEntity<?> modifyServeyConsulting() {
        consultingManageService.modifyServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 삭제
    @DeleteMapping("/servey/delete/{consultingId}")
    public ResponseEntity<?> deleteServeyConsulting(@PathVariable int consultingId) {
        consultingManageService.deleteServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 복수개 삭제
    @DeleteMapping("/servey/delete")
    public ResponseEntity<?> deleteServeyConsultingList() {
        consultingManageService.deleteServeyList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 목록 출력
    @GetMapping("/servey/result/list")
    public ResponseEntity<?> getResultConsultingListApi() {
        consultingManageService.getResultList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 등록
    @PostMapping("/servey/result/regist")
    public ResponseEntity<?> registResultConsulting() {
        consultingManageService.registResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 출력
    @GetMapping("/servey/result/{resultId}")
    public ResponseEntity<?> getResultConsulting(@PathVariable int resultId) {
        consultingManageService.getResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 수정
    @PutMapping("/servey/result/modify/{resultId}")
    public ResponseEntity<?> modifyResultConsulting( ) {
        consultingManageService.modifyResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 삭제
    @DeleteMapping("/servey/result/delete/{resultId}")
    public ResponseEntity<?> deleteResultConsulting(@PathVariable int resultId) {
        consultingManageService.deleteResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 복수개 삭제
    @DeleteMapping("/servey/result/delete")
    public ResponseEntity<?> deleteResultConsultingList() {
        consultingManageService.deleteResultList();
        return ResponseEntity.ok().body(null);
    }
}
