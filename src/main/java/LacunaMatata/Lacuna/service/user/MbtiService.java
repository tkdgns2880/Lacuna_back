package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.request.user.mbti.ReqMbtiAnswerDto;
import LacunaMatata.Lacuna.dto.request.user.mbti.ReqMbtiQuestionDto;
import LacunaMatata.Lacuna.dto.request.user.mbti.ReqMbtiSurveyDto;
import LacunaMatata.Lacuna.dto.response.user.mbti.*;
import LacunaMatata.Lacuna.entity.mbti.MbtiResponse;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.entity.mbti.MbtiSkinConcern;
import LacunaMatata.Lacuna.repository.user.MbtiMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MbtiService {

    @Autowired
    private MbtiMapper mbtiMapper;

    @Autowired
    private StatisticService statisticService;

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
    public int submitMbti(ReqMbtiAnswerDto dto, HttpServletRequest request) {
        PrincipalUser principalUser =
                (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        int gender = dto.getGender();
        Date birthDate = dto.getBirthDate();
        List<Integer> mbtiSkinConcernIdList = dto.getMbtiSkinConcernIdList();

        int mbtiResultId = caculateMbtiResult(dto);

        List<MbtiResponse> mbtiResponseList = new ArrayList<>();

        if(principalUser == null) {
            HttpSession session = request.getSession();
            String sessionId = session.getId();

            for(ReqMbtiSurveyDto surveyDto : dto.getMbtiResult()) {
                int mbtiCategoryId = surveyDto.getMbtiCategoryId();

                for(ReqMbtiQuestionDto questionDto : surveyDto.getMbti()) {
                    MbtiResponse mbtiResponse = MbtiResponse.builder()
                            .sessionId(sessionId)
                            .gender(gender)
                            .birth(birthDate)
                            .skinProblemOne(mbtiSkinConcernIdList.get(0))
                            .skinProblemTwo(mbtiSkinConcernIdList.get(1))
                            .responseMbtiCategoryId(mbtiCategoryId)
                            .responseMbtiId(questionDto.getMbtiId())
                            .mbtiOptionId(questionDto.getOption())
                            .mbtiResultId(mbtiResultId)
                            .build();
                    mbtiResponseList.add(mbtiResponse);
                }
            }

            mbtiMapper.saveNonUserMbtiSurvey(mbtiResponseList);
            return mbtiResultId;
        }

        for(ReqMbtiSurveyDto surveyDto : dto.getMbtiResult()) {
            int mbtiCategoryId = surveyDto.getMbtiCategoryId();

            for(ReqMbtiQuestionDto questionDto : surveyDto.getMbti()) {
                MbtiResponse mbtiResponse = MbtiResponse.builder()
                        .mbtiResponseUserId(principalUser.getId())
                        .gender(gender)
                        .birth(birthDate)
                        .skinProblemOne(mbtiSkinConcernIdList.get(0))
                        .skinProblemTwo(mbtiSkinConcernIdList.get(1))
                        .responseMbtiCategoryId(mbtiCategoryId)
                        .responseMbtiId(questionDto.getMbtiId())
                        .mbtiOptionId(questionDto.getOption())
                        .mbtiResultId(mbtiResultId)
                        .build();
                mbtiResponseList.add(mbtiResponse);
            }
        }

        mbtiMapper.saveUserMbtiSurvey(mbtiResponseList);

        statisticService.plusServiceCount("mbti"); // 이용통계 이용건수 증가

        // 등록 후 결과값 반환
        return mbtiResultId;
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

    private int caculateMbtiResult(ReqMbtiAnswerDto dto) {
        List<ReqMbtiSurveyDto> mbtiResult = dto.getMbtiResult();
        List<RespMbtiCategoryIdDto> mbtiOptionScoreList = mbtiMapper.getMbtiOptionScore(mbtiResult);

        List<String> mbtiResultType = new ArrayList<>();
        for(RespMbtiCategoryIdDto mbtiCategory : mbtiOptionScoreList) {

            int mbtiCategoryId = mbtiCategory.getMbtiCategoryId();
            int totalScore = 0;
            switch (mbtiCategoryId) {
                case 1:
                    for(RespMbtiOptionIdDto mbtiOption : mbtiCategory.getMbti()) {
                        int optionScore = mbtiOption.getOptionScore();
                        totalScore += optionScore;
                    }
                    if(totalScore > 0) {
                        mbtiResultType.add("A");
                    } else {
                        mbtiResultType.add("B");
                    }
                    break;
                case 2:
                    for(RespMbtiOptionIdDto mbtiOption : mbtiCategory.getMbti()) {
                        int optionScore = mbtiOption.getOptionScore();
                        totalScore += optionScore;
                    }
                    if(totalScore > 0) {
                        mbtiResultType.add("C");
                    } else {
                        mbtiResultType.add("D");
                    }
                    break;
                case 3:
                    for(RespMbtiOptionIdDto mbtiOption : mbtiCategory.getMbti()) {
                        int optionScore = mbtiOption.getOptionScore();
                        totalScore += optionScore;
                    }
                    if(totalScore > 0) {
                        mbtiResultType.add("E");
                    } else {
                        mbtiResultType.add("F");
                    }
                    break;
                case 4:
                    for(RespMbtiOptionIdDto mbtiOption : mbtiCategory.getMbti()) {
                        int optionScore = mbtiOption.getOptionScore();
                        totalScore += optionScore;
                    }
                    if(totalScore > 0) {
                        mbtiResultType.add("G");
                    } else {
                        mbtiResultType.add("H");
                    }
                    break;
                default:
                    break;
            }
        }
        String mbtiResultName = "";
        for(int i = 0; i < mbtiResultType.size(); i++) {
            String resultType = mbtiResultType.get(i);
            mbtiResultName.concat(resultType);
        }
        int mbtiResultId = mbtiMapper.getMbtiResultId(mbtiResultName);

        return mbtiResultId;
    }
}
