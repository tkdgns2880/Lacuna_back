package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.mbti.*;
import LacunaMatata.Lacuna.dto.response.admin.mbti.RespMbtiCategoryDto;
import LacunaMatata.Lacuna.service.admin.MbtiManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminMbtiController() - 세팅     *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@RequestMapping("/auth/admin/mbti")
public class MbtiManageController {

    @Autowired
    private MbtiManageService mbtiManageService;

    // MBTI 분류 카테고리 리스트 출력
    @GetMapping("/servey/category")
    public ResponseEntity<?> getMbtiCategoryList() {
        List<RespMbtiCategoryDto> mbtiCategoryList = mbtiManageService.getMbtiCategoryList();
        System.out.println(mbtiCategoryList);
        return ResponseEntity.ok().body(mbtiCategoryList);
    }

    // MBTI 분류 카테고리 등록
    @PostMapping("/servey/category/register")
    public ResponseEntity<?> registerMbtiCategory(@RequestBody ReqRegisterMbtiCategoryDto dto) {
        mbtiManageService.registerMbtiCategory(dto);
        return ResponseEntity.ok().body(null);
    }

    // MBTI 분류 카테고리 수정
    @PutMapping("/servey/category/modify")
    public ResponseEntity<?> modifyMbtiCategory(@RequestBody ReqModifyMbtiCategoryDto dto) {
        mbtiManageService.modifyMbtiCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 분류 카테고리 삭제
    @DeleteMapping("/servey/category/delete/{categoryId}")
    public ResponseEntity<?> deleteMbtiCategory(@PathVariable int categoryId) {
        mbtiManageService.deleteMbtiCategory(categoryId);
        return ResponseEntity.ok().body(null);
    }

    // MBTI 분류 카테고리 복수개 삭제
    @DeleteMapping("/servey/category/delete")
    public ResponseEntity<?> deleteMbtiCategoryList() {
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 항목 리스트 출력
    @GetMapping("/question")
    public ResponseEntity<?> getMbtiQuestionList() {
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 항목 등록
    @PostMapping("/question/register")
    public ResponseEntity<?> registerMbtiQuestion(@RequestBody ReqRegisterMbtiQuestionDto dto) {
//        mbtiManageService.registerMbtiQuestion();
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 항목 수정
    @PutMapping("/question/modify")
    public ResponseEntity<?> modifyMbtiQuestion(@RequestBody ReqModifyMbtiQuestionDto dto) {
//        mbtiManageService.modifyMbtiQuestion();
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 항목 삭제
    @DeleteMapping("/question/delete/{mbtiId}")
    public ResponseEntity<?> deleteMbtiQuestion(@PathVariable int mbtiId) {
        mbtiManageService.deleteMbtiQuestion(mbtiId);
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 항목 복수개 삭제
    @DeleteMapping("/question/delete")
    public ResponseEntity<?> deleteMbtiQuestionList() {
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 결과 리스트 출력
    @GetMapping("/result/list")
    public ResponseEntity<?> getMbtiResultList() {
        return ResponseEntity.ok().body(null);
    }

    // MBTI 설문 결과 등록
    @PostMapping("/result/register")
    public ResponseEntity<?> registerMbtiResult(@RequestBody ReqRegisterMbtiResultDto dto) {
        mbtiManageService.registerMbtiResult(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 수정
    @PutMapping("/result/modify/{resultId}")
    public ResponseEntity<?> modifyMbtiResult(@RequestBody ReqModifyMbtiResultDto dto) {
        mbtiManageService.modifyMbtiResult(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 삭제
    @DeleteMapping("/result/delete/{resultId}")
    public ResponseEntity<?> deleteMbtiResult(@PathVariable int resultId) {
        mbtiManageService.deleteMbtiResult(resultId);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 복수개 삭제
    @DeleteMapping("/result/delete")
    public ResponseEntity<?> deleteMbtiResultList() {
        return ResponseEntity.ok().body(null);
    }
}
