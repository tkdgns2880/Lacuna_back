package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.dto.response.user.mbti.RespMbtiSurveyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MbtiMapper {
    List<RespMbtiSurveyDto> getMbtiSurvey();
}
