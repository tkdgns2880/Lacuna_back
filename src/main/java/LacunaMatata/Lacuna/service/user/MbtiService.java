package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiSurveyDto;
import LacunaMatata.Lacuna.repository.user.MbtiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MbtiService {

    @Autowired
    private MbtiMapper mbtiMapper;

    // mbti 설문지 출력
    public List<RespMbtiSurveyDto> getmbtiSurvey() {
        List<RespMbtiSurveyDto> mbtiCategoryList = mbtiMapper.getMbtiSurvey();
        return mbtiCategoryList;
    }

    // mbti 설문 답안 등록
    public void submitMbti() {

    }

    // mbti 설문 결과 출력
    public void getMbtiResult() {

    }
}
