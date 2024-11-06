package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.request.user.mbti.ReqMbtiAnswerDto;
import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiSurveyDto;
import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiSurveyResultDto;
import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiTestDto;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.entity.mbti.MbtiSkinConcern;
import LacunaMatata.Lacuna.repository.user.MbtiMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MbtiService {

    @Autowired
    private MbtiMapper mbtiMapper;

    // mbti 설문지 출력
    public RespMbtiTestDto getmbtiSurvey() {
        List<RespMbtiSurveyDto> mbtiCategoryList = mbtiMapper.getMbtiSurvey();
        List<MbtiSkinConcern> mbtiSkinConcernList = mbtiMapper.getMbtiSkinConcernList();
        RespMbtiTestDto mbtiTest = RespMbtiTestDto.builder()
                .mbtiSurvey(mbtiCategoryList)
                .mbtiSkinConcern(mbtiSkinConcernList)
                .build();
        return mbtiTest;
    }

    // mbti 설문 답안 등록
    public void submitMbti(ReqMbtiAnswerDto dto) {
        PrincipalUser principalUser =
                (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();

        // 어떻게 받을지는 좀 고민해봐야할듯
        if(principalUser == null) {
            mbtiMapper.saveNonUserMbtiSurvey();
            return;
        }
        mbtiMapper.saveUserMbtiSurvey();

        // 등록 후 결과값 반환
    }

    // mbti 설문 결과 출력
    public RespMbtiSurveyResultDto getMbtiResult(int mbtiResultId) {
        MbtiResult mbtiSurveyResult = mbtiMapper.getMbtiSurveyResult(mbtiResultId);
        RespMbtiSurveyResultDto mbtiResult = RespMbtiSurveyResultDto.builder()
                .mbtiResultId(mbtiSurveyResult.getMbtiResultId())
                .mbtiResultCategoryName(mbtiSurveyResult.getMbtiResultCategoryName())
                .mbtiResultTitle(mbtiSurveyResult.getMbtiResultTitle())
                .mbtiResultSummary(mbtiSurveyResult.getMbtiResultSummary())
                .mbtiResultContent(mbtiSurveyResult.getMbtiResultContent())
                .mbtiResultImg(mbtiSurveyResult.getMbtiResultImg())
                .build();
        return mbtiResult;
    }
}
