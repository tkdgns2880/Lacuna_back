package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.mbti.*;
import LacunaMatata.Lacuna.dto.response.admin.mbti.*;
import LacunaMatata.Lacuna.service.admin.MbtiManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminMbtiController() - 세팅     *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-27                       *
 ************************************************/
@RestController
@RequestMapping("/api/v1/admin/mbti")
@Api(tags = {"mbtiManageController"})
@Slf4j
public class MbtiManageController {

    @Autowired
    private MbtiManageService mbtiManageService;

    // MBTI 분류 카테고리 리스트 출력
    @ApiOperation(value = "getMbtiCategoryListApi")
    @GetMapping("/servey/category/list")
    public ResponseEntity<?> getMbtiCategoryList(ReqGetMbtiGategoryListDto dto) {
        RespCountAndMbtiCategoryDto respCountAndMbtiCategoryDto = mbtiManageService.getMbtiCategoryList(dto);
        return ResponseEntity.ok().body(respCountAndMbtiCategoryDto);
    }

    // MBTI 분류 카테고리 등록
    @ApiOperation(value = "registMbtiCategoryApi")
    @PostMapping("/servey/category/regist")
    public ResponseEntity<?> registMbtiCategory(@RequestBody ReqRegistMbtiCategoryDto dto) {
        mbtiManageService.registMbtiCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    //MBTI 분류 카테고리 모달 조회
    @ApiOperation(value = "getMbtiCategoryApi")
    @GetMapping("/servey/category/{categoryId}")
    public ResponseEntity<?> getMbtiCategory(@PathVariable int categoryId) {
        RespMbtiCategoryDto mbtiCategory = mbtiManageService.getMbtiCategory(categoryId);
        return ResponseEntity.ok().body(mbtiCategory);
    }

    //MBTI 분류 카테고리 출력(필터용)
    @GetMapping("/servey/category/filter")
    public ResponseEntity<?> getMbtiCategoryListFilter() {
        List<RespMbtiCategoryFilterDto> mbtiCategoryList = mbtiManageService.getMbtiCategoryFilterDto();
        return ResponseEntity.ok().body(mbtiCategoryList);
    }

    // MBTI 분류 카테고리 모달 수정
    @ApiOperation(value = "modifyMbtiCategoryApi")
    @PutMapping("/servey/category/modify/{mbtiCategoryId}")
    public ResponseEntity<?> modifyMbtiCategory(@RequestBody ReqModifyMbtiCategoryDto dto, @PathVariable int mbtiCategoryId) {
        mbtiManageService.modifyMbtiCategory(dto, mbtiCategoryId);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 분류 카테고리 삭제
    @ApiOperation(value = "deleteMbtiCategoryApi")
    @DeleteMapping("/servey/category/delete/{categoryId}")
    public ResponseEntity<?> deleteMbtiCategory(@PathVariable int categoryId) {
        mbtiManageService.deleteMbtiCategory(categoryId);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 분류 카테고리 복수개 삭제
    @ApiOperation(value = "deleteMbtiCategoryListApi")
    @DeleteMapping("/servey/category/delete")
    public ResponseEntity<?> deleteMbtiCategoryList(@RequestBody ReqDeleteMbtiCategoryListDto dto) {
        mbtiManageService.deleteMbtiCategoryList(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 항목 리스트 출력
    @ApiOperation(value = "getMbtiQuestionListApi")
    @GetMapping("/question")
    public ResponseEntity<?> getMbtiQuestionList(ReqGetMbtiQuestionListDto dto) {
        RespCountAndMbtiQuestionDto respCountAndMbtiQuestionDto = mbtiManageService.getMbtiQuestionList(dto);
        return ResponseEntity.ok().body(respCountAndMbtiQuestionDto);
    }

    // MBTI 설문 항목 등록
    @ApiOperation(value = "registMbtiQuestionApi")
    @PostMapping("/question/regist")
    public ResponseEntity<?> registMbtiQuestion(@RequestBody ReqRegistMbtiQuestionDto dto) {
        mbtiManageService.registMbtiQuestion(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 항목 모달 출력
    @ApiOperation(value = "getMbtiQuestionApi")
    @GetMapping("/question/{mbtiId}")
    public ResponseEntity<?> getMbtiQuestion(@PathVariable int mbtiId) {
        RespMbtiQuestionDto mbtiQuestion = mbtiManageService.getMbtiQuestion(mbtiId);
        return ResponseEntity.ok().body(mbtiQuestion);
    }

    // MBTI 설문 항목 모달 수정
    @ApiOperation(value = "modifyMbtiQuestionApi")
    @PutMapping("/question/modify/{mbtiId}")
    public ResponseEntity<?> modifyMbtiQuestion(@RequestBody ReqModifyMbtiQuestionDto dto, @PathVariable int mbtiId) {
        mbtiManageService.modifyMbtiQuestion(dto, mbtiId);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 항목 삭제
    @ApiOperation(value = "deleteMbtiQuestionApi")
    @DeleteMapping("/question/delete/{mbtiId}")
    public ResponseEntity<?> deleteMbtiQuestion(@PathVariable int mbtiId) {
        mbtiManageService.deleteMbtiQuestion(mbtiId);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 항목 복수개 삭제
    @ApiOperation(value = "deleteMbtiQuestionListApi")
    @DeleteMapping("/question/delete")
    public ResponseEntity<?> deleteMbtiQuestionList(@RequestBody ReqDeleteMbtiQuestionDto dto) {
        mbtiManageService.deleteMbtiQuestionList(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 리스트 출력
    @ApiOperation(value = "getMbtiResultListApi")
    @GetMapping("/result/list")
    public ResponseEntity<?> getMbtiResultList(ReqGetMbtiResultDto dto) {
        RespCountAndMbtiResultDto respCountAndMbtiResultDto = mbtiManageService.getMbtiResultList(dto);
        return ResponseEntity.ok().body(respCountAndMbtiResultDto);
    }

    // MBTI 설문 결과 등록
    @ApiOperation(value = "registMbtiResultApi")
    @PostMapping("/result/regist")
    public ResponseEntity<?> registMbtiResult(@ModelAttribute ReqRegistMbtiResultDto dto) {
        mbtiManageService.registMbtiResult(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 항목 모달 출력
    @ApiOperation(value = "getMbtiResultApi")
    @GetMapping("/result/{resultId}")
    public ResponseEntity<?> getMbtiResult(@PathVariable int resultId) {
        RespGetMbtiResultDto mbtiResultDto = mbtiManageService.getMbtiResultDto(resultId);
        return ResponseEntity.ok().body(mbtiResultDto);
    }

    // MBTI 설문 결과 항목 모달 수정
    @ApiOperation(value = "modifyMbtiResultApi")
    @PutMapping("/result/modify/{resultId}")
    public ResponseEntity<?> modifyMbtiResult(@ModelAttribute ReqModifyMbtiResultDto dto, @PathVariable int resultId) {
        mbtiManageService.modifyMbtiResult(dto);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 삭제
    @ApiOperation(value = "deleteMbtiResultApi")
    @DeleteMapping("/result/delete/{resultId}")
    public ResponseEntity<?> deleteMbtiResult(@PathVariable int resultId) {
        mbtiManageService.deleteMbtiResult(resultId);
        return ResponseEntity.ok().body(true);
    }

    // MBTI 설문 결과 복수개 삭제
    @ApiOperation(value = "deleteMbtiResultListApi")
    @DeleteMapping("/result/delete")
    public ResponseEntity<?> deleteMbtiResultList(@RequestBody ReqDeleteMbtiResultListDto dto) {
        mbtiManageService.deleteMbtiResultList(dto);
        return ResponseEntity.ok().body(true);
    }
}
