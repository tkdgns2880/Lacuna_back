package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.mbti.ReqModifyMbtiCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.mbti.ReqModifyMbtiResultDto;
import LacunaMatata.Lacuna.entity.mbti.MbtiCategory;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MbtiManageMapper {
    List<MbtiCategory> getMbtiCategoryList();
    int registerMbtiCategory(MbtiCategory mbtiCategory);
    MbtiCategory findByCategoryId(int categoryId);
    int modifyMbtiCategory(ReqModifyMbtiCategoryDto dto); // MBTI 카테고리 수정
    int deleteMbtiCategory(int categoryId); // MBTI 카테고리 삭제

    int deleteMbtiQuestion(int mbtiId); // MBTI 설문 항목 삭제

    int registerMbtiResult(MbtiResult mbtiResult); // MBTI 결과 항목 등록
    int modifyMbtiResult(ReqModifyMbtiResultDto dto); // MBTI 결과항목 수정
    int deleteMbtiResult(int resultId);
}
