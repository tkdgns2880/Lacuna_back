package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiSurveyDto;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.entity.mbti.MbtiSkinConcern;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MbtiMapper {
    /** 사용자 mbti 설문 관련 Mapper */
    // 1-1. mbti 설문지 항목 가져오기_2024.11.05
    List<RespMbtiSurveyDto> getMbtiSurvey();
    // 1-2. mbti 피부고민 정보 리스트 가져오기
    List<MbtiSkinConcern> getMbtiSkinConcernList();
    // 2-1. mbti 설문 답안 저장하기 - 회원
    int saveUserMbtiSurvey();
    // 2-2. mbti 설문 답안 저장하기 - 비회원
    int saveNonUserMbtiSurvey();
    // 3. mbti 설문에 대한 결과 항목 출력하기
    MbtiResult getMbtiSurveyResult(int mbtiResultId);
}
