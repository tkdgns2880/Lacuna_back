package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.mbti.ReqRegisterMbtiCategoryDto;
import LacunaMatata.Lacuna.dto.response.admin.mbti.RespMbtiCategoryDto;
import LacunaMatata.Lacuna.entity.mbti.MbtiCategory;
import LacunaMatata.Lacuna.repository.admin.MbtiManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MbtiManageService {

    @Autowired
    private MbtiManageMapper mbtiManageMapper;

    // mbti 분류 카테고리 리스트 출력
    public List<RespMbtiCategoryDto> getMbtiCategoryList() {
        List<MbtiCategory> mbtiCategoryList = mbtiManageMapper.getMbtiCategoryList();
        List<RespMbtiCategoryDto> respMbtiCategoryDtoList = new ArrayList<>();
        for(MbtiCategory mbtiCategory : mbtiCategoryList){
            RespMbtiCategoryDto respMbtiCategoryDto = RespMbtiCategoryDto.builder()
                    .mbtiCategoryId(mbtiCategory.getMbtiCategoryId())
                    .mbtiCategoryName(mbtiCategory.getMbtiCategoryName())
                    .name(mbtiCategory.getUser().getName())
                    .createdDate(mbtiCategory.getCreateDate())
                    .build();
            respMbtiCategoryDtoList.add(respMbtiCategoryDto);
        }

        return respMbtiCategoryDtoList;
    }

    // mbti 분류 카테고리 등록
    public void registerMbtiCategory(ReqRegisterMbtiCategoryDto dto) {
//        PrincipalUser principalUser = (PrincipalUser)
//                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        int userId = principalUser.getId();

        MbtiCategory mbtiCategory = MbtiCategory.builder()
//                .mbtiCategoryRegisterId(userId)
                .mbtiCategoryRegisterId(16)
                .mbtiCategoryName(dto.getMbtiCategoryName())
                .mbtiCategoryTitle(dto.getMbtiCategoryTitle())
                .mbtiCategoryDescription(dto.getMbtiCategoryDescription())
                .mbtiCategoryImg(dto.getMbtiCategoryImg())
                .build();
        mbtiManageMapper.registerMbtiCategory(mbtiCategory);
    }

    // mbti 분류 카테고리 수정
    public void modifyMbtiCategory() {

    }

    // mbti 분류 카테고리 삭제
    public void deleteMbtiCategory() {

    }

    // mbti 분류 카테고리 복수개 삭제
    public void deleteMbtiCategoryList() {

    }

    // mbti 설문지 리스트 출력
    public List<Object> getMbtiQuestionList() {
        return null;
    }

    // mbti 설문지 항목 등록
    public void registerMbtiQuestion() {

    }

    // mbti 설문지 항목 수정
    public void modifyMbtiQuestion() {

    }

    // mbti 설문지 항목 삭제
    public void deleteMbtiQuestion() {

    }

    // mbti 설문지 항목 복수개 삭제
    public void deleteMbtiQuestionList() {

    }

    // mbti 설문 결과 리스트 출력
    public List<Object> getMbtiResultList() {
        return null;
    }

    // mbti 설문 결과 항목 등록
    public void registerMbtiResult() {

    }

    // mbti 설문 결과 항목 수정
    public void modifyMbtiResult() {

    }

    // mbti 설문 결과 항목 삭제
    public void deleteMbtiResult() {

    }

    // mbti 설문 결과 복수개 삭제
    public void deleteMbtiResultList() {

    }
}
