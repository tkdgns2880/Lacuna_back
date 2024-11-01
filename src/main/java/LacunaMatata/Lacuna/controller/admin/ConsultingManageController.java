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
    ResponseEntity<?> getUpperConsultingListApi() {
        consultingManageService.getUpperConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 출력(필터)
    @GetMapping("/upper/filter")
    ResponseEntity<?> getUpperConsultingListFilter() {
        consultingManageService.getUpperConsultingFilter();
    return ResponseEntity.ok().body(null); }

    // 컨설팅 상위 분류 항목 등록
    @PostMapping("/upper/regist")
    ResponseEntity<?> registUpperConsulting(@RequestBody ReqRegistUpperConsultingCategoryDto dto) {
        consultingManageService.registUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 출력
    @GetMapping("/upper/{upperId}")
    ResponseEntity<?> getUpperConsulting(@PathVariable int upperId) {
        consultingManageService.getUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 수정
    @PutMapping("/upper/modify/{upperId}")
    ResponseEntity<?> modifyUpperConsulting(@RequestBody ReqModifyUpperConsulingCategoryDto dto) {
        consultingManageService.modifyUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 삭제
    @DeleteMapping("/upper/delete/{upperId}")
    ResponseEntity<?> deleteUpperConsulting(@PathVariable int upperId) {
        consultingManageService.deleteUpperConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 상위 분류 항목 복수개 삭제
    @DeleteMapping("/upper/delete")
    ResponseEntity<?> deleteUpperConsultingList() {
        consultingManageService.deleteUpperConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 목록 출력
    @GetMapping("/lower/list")
    ResponseEntity<?> getLowerConsultingListApi() {
        consultingManageService.getLowerConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 출력 (필터)
    @GetMapping("/lower/list/filter/{upperId}")
    ResponseEntity<?> getLowerConsultingListFilter(@PathVariable int upperId) {
        consultingManageService.getLowerConsultingFilter();
        return ResponseEntity.ok().body(null); }

    // 컨설팅 하위 분류 항목 등록
    @PostMapping("/lower/regist")
    ResponseEntity<?> registLowerConsulting() {
        consultingManageService.registLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 출력
    @GetMapping("/lower/{upperId}")
    ResponseEntity<?> getLowerConsulting(@PathVariable int upperId) {
        consultingManageService.getLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 수정
    @PutMapping("/lower/modify/{upperId}")
    ResponseEntity<?> modifyLowerConsulting() {
        consultingManageService.modifyLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 삭제
    @DeleteMapping("/lower/delete/{upperId}")
    ResponseEntity<?> deleteLowerConsulting(@PathVariable int upperId) {
        consultingManageService.deleteLowerConsulting();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 하위 분류 항목 복수개 삭제
    @DeleteMapping("/lower/delete")
    ResponseEntity<?> deleteLowerConsultingList() {
        consultingManageService.deleteLowerConsultingList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 목록 출력
    @GetMapping("/servey/list")
    ResponseEntity<?> getServeyConsultingListApi() {
        consultingManageService.getServeyList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 선택지 타입 항목 출력
    @GetMapping("/servey/option/filter/{consultingId}")
    ResponseEntity<?> getServeyConsultingOptionFilter(@PathVariable int consultingId) {
        consultingManageService.getServeyOption();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 등록
    @PostMapping("servey/regist")
    ResponseEntity<?> registServeyConsulting() {
        consultingManageService.registServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 출력
    @GetMapping("/servey/{consultingId}")
    ResponseEntity<?> getServeyConsulting(@PathVariable int consultingId) {
        consultingManageService.getServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 수정
    @PutMapping("/servey/modify")
    ResponseEntity<?> modifyServeyConsulting() {
        consultingManageService.modifyServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 삭제
    @DeleteMapping("/servey/delete/{consultingId}")
    ResponseEntity<?> deleteServeyConsulting(@PathVariable int consultingId) {
        consultingManageService.deleteServey();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 설문지 항목 복수개 삭제
    @DeleteMapping("/servey/delete")
    ResponseEntity<?> deleteServeyConsultingList() {
        consultingManageService.deleteServeyList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 목록 출력
    @GetMapping("/servey/result/list")
    ResponseEntity<?> getResultConsultingListApi() {
        consultingManageService.getResultList();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 등록
    @PostMapping("/servey/result/regist")
    ResponseEntity<?> registResultConsulting() {
        consultingManageService.registResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 출력
    @GetMapping("/servey/result/{resultId}")
    ResponseEntity<?> getResultConsulting(@PathVariable int resultId) {
        consultingManageService.getResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 수정
    @PutMapping("/servey/result/modify/{resultId}")
    ResponseEntity<?> modifyResultConsulting( ) {
        consultingManageService.modifyResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 삭제
    @DeleteMapping("/servey/result/delete/{resultId}")
    ResponseEntity<?> deleteResultConsulting(@PathVariable int resultId) {
        consultingManageService.deleteResult();
        return ResponseEntity.ok().body(null);
    }

    // 컨설팅 결과지 항목 복수개 삭제
    @DeleteMapping("/servey/result/delete")
    ResponseEntity<?> deleteResultConsultingList() {
        consultingManageService.deleteResultList();
        return ResponseEntity.ok().body(null);
    }
}
