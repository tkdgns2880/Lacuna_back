package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.mbti.ReqModifyMbtiCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.mbti.ReqModifyMbtiResultDto;
import LacunaMatata.Lacuna.entity.mbti.Mbti;
import LacunaMatata.Lacuna.entity.mbti.MbtiCategory;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MbtiManageMapper {
    /** MBTI 분류 관련 Mapper */
    // 1. MBTI 분류 목록 조회_2024.10.27
    List<MbtiCategory> getMbtiCategoryList(Map<String, Object> params);
    // 2. MBTI 분류 등록_2024.10.27
    int registerMbtiCategory(MbtiCategory mbtiCategory);
    // 3. MBTI 분류 모달창 조회_2024.10.27
    MbtiCategory findMbtiCategoryByCategoryId(int categoryId);
    // 4. MBTI 분류 모달창 수정_2024.10.27
    int modifyMbtiCategory(ReqModifyMbtiCategoryDto dto);
    // 5. MBTI 분류 단일 삭제_2024.10.27
    int deleteMbtiCategory(int categoryId);
    // 6. MBTI 분류 복수 삭제_2024.10.27
    int deleteMbtiCategoryList(List<Integer> mbtiCategoryIdList);

    /** MBTI 설문 관련 Mapper */
    // 1. MBTI 살문 목록 출력_2024.10.27
    List<Mbti> getMbtiQuestionList(Map<String, Object> params);

    int registerMbtiResult(MbtiResult mbtiResult); // MBTI 결과 항목 등록
    int modifyMbtiResult(ReqModifyMbtiResultDto dto); // MBTI 결과항목 수정
    int deleteMbtiResult(int resultId);
}
