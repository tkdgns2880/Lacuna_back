package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.mbti.*;
import LacunaMatata.Lacuna.dto.response.admin.mbti.*;
import LacunaMatata.Lacuna.entity.mbti.Mbti;
import LacunaMatata.Lacuna.entity.mbti.MbtiCategory;
import LacunaMatata.Lacuna.entity.mbti.MbtiOption;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.repository.admin.MbtiManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MbtiManageService {

    @Autowired
    private MbtiManageMapper mbtiManageMapper;

    // mbti 분류 카테고리 리스트 출력
    public List<RespMbtiCategoryListDto> getMbtiCategoryList(ReqGetMbtiGategoryListDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );

        List<MbtiCategory> mbtiCategoryList = mbtiManageMapper.getMbtiCategoryList(params);
        List<RespMbtiCategoryListDto> respMbtiCategoryListDtoList = new ArrayList<RespMbtiCategoryListDto>();
        for(MbtiCategory mbtiCategory : mbtiCategoryList){
            RespMbtiCategoryListDto respMbtiCategoryListDto = RespMbtiCategoryListDto.builder()
                    .mbtiCategoryId(mbtiCategory.getMbtiCategoryId())
                    .mbtiCategoryName(mbtiCategory.getMbtiCategoryName())
                    .name(mbtiCategory.getUser().getName())
                    .createdDate(mbtiCategory.getCreateDate())
                    .build();
            respMbtiCategoryListDtoList.add(respMbtiCategoryListDto);
        }

        return respMbtiCategoryListDtoList;
    }

    // mbti 분류 카테고리 등록
    public void registMbtiCategory(ReqRegistMbtiCategoryDto dto) {
        PrincipalUser principalUser = (PrincipalUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();

        MbtiCategory mbtiCategory = MbtiCategory.builder()
                .mbtiCategoryRegisterId(userId)
                .mbtiCategoryName(dto.getMbtiCategoryName())
                .mbtiCategoryTitle(dto.getMbtiCategoryTitle())
                .mbtiCategoryDescription(dto.getMbtiCategoryDescription())
                .mbtiCategoryImg(dto.getMbtiCategoryImg())
                .build();
        mbtiManageMapper.saveMbtiCategory(mbtiCategory);
    }

    // mbti 분류 카테고리 모달 출력
    public RespMbtiCategoryDto getMbtiCategory(int categoryId) {
        MbtiCategory mbtiCategory = mbtiManageMapper.findMbtiCategoryByCategoryId(categoryId);
        RespMbtiCategoryDto respMbtiCategory = RespMbtiCategoryDto.builder()
                .mbtiCategoryId(mbtiCategory.getMbtiCategoryId())
                .mbtiCategoryName(mbtiCategory.getMbtiCategoryName())
                .mbtiCategoryTitle(mbtiCategory.getMbtiCategoryTitle())
                .mbtiCategoryDescription(mbtiCategory.getMbtiCategoryDescription())
                .mbtiCategoryImg(mbtiCategory.getMbtiCategoryImg())
                .build();
        return respMbtiCategory;
    }

    // mbti 분류 카테고리 모달 수정
    public void modifyMbtiCategory(ReqModifyMbtiCategoryDto dto, int mbtiCategoryId) {
        PrincipalUser principalUser = (PrincipalUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        Map<String, Object> params = Map.of(
                "registerId", registerId,
                "mbtiCategoryId", dto.getMbtiCategoryId()
        );
        mbtiManageMapper.modifyMbtiCategory(dto, params);
    }

    // mbti 분류 카테고리 삭제
    public void deleteMbtiCategory(int categoryId) {
        mbtiManageMapper.deleteMbtiCategory(categoryId);
    }

    // mbti 분류 카테고리 복수개 삭제
    public void deleteMbtiCategoryList(ReqDeleteMbtiCategoryListDto dto) {
        List<Integer> mbtiCategoryIdList = dto.getMbtiCategoryIdList();
        mbtiManageMapper.deleteMbtiCategoryList(mbtiCategoryIdList);
    }

    // mbti 설문지 리스트 출력
    public List<RespMbtiQuestionListDto> getMbtiQuestionList(ReqGetMbtiQuestionListDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "filter", dto.getFilter(),
                "option", dto.getOption(),
                "searchValue", dto.getSearchValue(),
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        List<Mbti> mbtiQuestionList = mbtiManageMapper.getMbtiQuestionList(params);
        List<RespMbtiQuestionListDto> respMbtiQuestionList = new ArrayList<RespMbtiQuestionListDto>();
        for(Mbti mbti : mbtiQuestionList) {
            RespMbtiQuestionListDto respMbtiQuestionListDto = RespMbtiQuestionListDto.builder()
                    .mbtiId(mbti.getMbtiId())
                    .mbtiCategoryName(mbti.getMbtiCategory().getMbtiCategoryName())
                    .mbtiTitle(mbti.getMbtiTitle())
                    .name(mbti.getUser().getName())
                    .createdDate(mbti.getCreateDate())
                    .build();
            respMbtiQuestionList.add(respMbtiQuestionListDto);
        }
        return respMbtiQuestionList;
    }

    // mbti 설문지 항목 등록
    public void registMbtiQuestion(ReqRegistMbtiQuestionDto dto) {
        PrincipalUser principalUser = (PrincipalUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        MbtiCategory mbtiCategory = mbtiManageMapper.findMbtiCategoryByCategoryName(dto.getMbtiCategoryName());

        Mbti mbti = Mbti.builder()
                .mbtiCode(dto.getMbtiCode())
                .mbtiCategoryId(mbtiCategory.getMbtiCategoryId())
                .mbtiRegisterId(registerId)
                .mbtiTitle(dto.getMbtiTitle())
                .mbtiImg(dto.getMbtiImg())
                .build();
        List<String> optionNames = dto.getOptionName();
        List<Integer> optionScores = dto.getOptionScore();

        int mbtiId = mbtiManageMapper.saveMbti(mbti);
        for(int i = 0; i < dto.getOptionName().size(); i++) {
            MbtiOption mbtiOption = MbtiOption.builder()
                    .mbtiId(mbtiId)
                    .optionName(optionNames.get(i))
                    .optionScore(optionScores.get(i))
                    .build();
            mbtiManageMapper.saveMbtiOption(mbtiOption);
        }
    }

    // mbti 설문지 항목 모달 출력
    public RespMbtiQuestionDto getMbtiQuestion(int mbtiId) {
        Mbti mbtiQuestion = mbtiManageMapper.getMbtiQuestion(mbtiId);
        RespMbtiQuestionDto respMbtiQuestionDto = RespMbtiQuestionDto.builder()
                .mbtiId(mbtiQuestion.getMbtiId())
                .mbtiCategoryName(mbtiQuestion.getMbtiCategory().getMbtiCategoryName())
                .mbtiTitle(mbtiQuestion.getMbtiTitle())
                .name(mbtiQuestion.getUser().getName())
                .createdDate(mbtiQuestion.getCreateDate())
                .build();
        return respMbtiQuestionDto;
    }

    // mbti 설문지 항목 모달 수정
    public void modifyMbtiQuestion(ReqModifyMbtiQuestionDto dto, int mbtiId) {
        PrincipalUser principalUser = (PrincipalUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        Map<String, Object> params = Map.of(
            "registerId", registerId,
            "mbtiId", dto.getMbtiId()
        );

        List<String> optionNameList = dto.getOptionName();
        List<Integer> optionScoreList = dto.getOptionScore();
        List<Integer> deleteOptionIdList = dto.getDeleteOptionIdList();

        mbtiManageMapper.modifyMbtiQuestion(dto, params);
        mbtiManageMapper.deleteMbtiQuestionOptionList(deleteOptionIdList);
        for(int i = 0; i < optionNameList.size(); i++) {
            MbtiOption mbtiOption = MbtiOption.builder()
                    .optionName(optionNameList.get(i))
                    .optionScore(optionScoreList.get(i))
                    .build();
            mbtiManageMapper.saveMbtiOption(mbtiOption);
        }
    }

    // mbti 설문지 항목 삭제
    public void deleteMbtiQuestion(int mbtiId) {
        mbtiManageMapper.deleteMbtiQuestion(mbtiId);
    }

    // mbti 설문지 항목 복수개 삭제
    public void deleteMbtiQuestionList(ReqDeleteMbtiQuestionDto dto) {
        List<Integer> mbtiIdList = dto.getMbtiIdList();
        mbtiManageMapper.deleteMbtiQuestionList(mbtiIdList);
    }

    // mbti 설문 결과 리스트 출력
    public List<RespGetMbtiResultListDto> getMbtiResultList(ReqGetMbtiResultDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "searchValue", dto.getSearchValue(),
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        List<MbtiResult> mbtiResultList = mbtiManageMapper.getMbtiResultList(params);
        List<RespGetMbtiResultListDto> respGetMbtiResultListDtoList = new ArrayList<RespGetMbtiResultListDto>();
        for(MbtiResult mbtiResult : mbtiResultList) {
            RespGetMbtiResultListDto respGetMbtiResultListDto = RespGetMbtiResultListDto.builder()
                    .mbtiResultId(mbtiResult.getMbtiResultId())
                    .mbtiResultCategoryName(mbtiResult.getMbtiResultCategoryName())
                    .mbtiResultTitle(mbtiResult.getMbtiResultTitle())
                    .mbtiResultStatus(mbtiResult.getMbtiResultStatus())
                    .name(mbtiResult.getUser().getName())
                    .createdDate(mbtiResult.getCreateDate())
                    .build();
            respGetMbtiResultListDtoList.add(respGetMbtiResultListDto);
        }
        return respGetMbtiResultListDtoList;
    }

    // mbti 설문 결과 항목 등록
    public void registMbtiResult(ReqRegistMbtiResultDto dto) {
        PrincipalUser principalUser = (PrincipalUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();

        MbtiResult mbtiResult = MbtiResult.builder()
                .mbtiResultRegisterId(registerId)
                .mbtiResultTitle(dto.getMbtiResultTitle())
                .mbtiResultCategoryName(dto.getMbtiResultCategoryName())
                .mbtiResultImg(dto.getMbtiResultImg())
                .mbtiResultSummary(dto.getMbtiResultSummary())
                .mbtiResultContent(dto.getMbtiResultContent())
                .mbtiResultStatus(dto.getMbtiResultStatus())
                .build();
        mbtiManageMapper.saveMbtiResult(mbtiResult);
    }

    // mbti 살문 결과 항목 모달 출력
    public RespGetMbtiResultDto getMbtiResultDto(int resultId) {
        MbtiResult mbtiResult = mbtiManageMapper.getMbtiResult(resultId);
        RespGetMbtiResultDto respGetMbtiResultDto = RespGetMbtiResultDto.builder()
                .mbtiResultId(mbtiResult.getMbtiResultId())
                .mbtiResultTitle(mbtiResult.getMbtiResultTitle())
                .mbtiResultCategoryName(mbtiResult.getMbtiResultCategoryName())
                .mbtiResultImg(mbtiResult.getMbtiResultImg())
                .mbtiResultSummary(mbtiResult.getMbtiResultSummary())
                .mbtiResultContent(mbtiResult.getMbtiResultContent())
                .build();
        return respGetMbtiResultDto;
    }

    // mbti 설문 결과 항목 모달 수정
    public void modifyMbtiResult(ReqModifyMbtiResultDto dto, int resultId) {
        PrincipalUser principalUser = (PrincipalUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();

        Map<String, Object> params = Map.of(
            "registerId", registerId,
            "resultId", resultId
        );

        mbtiManageMapper.modifyMbtiResult(dto, params);
    }

    // mbti 설문 결과 항목 삭제
    public void deleteMbtiResult(int resultId) {
        mbtiManageMapper.deleteMbtiResult(resultId);
    }

    // mbti 설문 결과 복수개 삭제
    public void deleteMbtiResultList(ReqDeleteMbtiResultListDto dto) {
        List<Integer> mbtiResultIdList = dto.getMbtiResultIdList();
        mbtiManageMapper.deleteMbtiResultList(mbtiResultIdList);
    }
}
