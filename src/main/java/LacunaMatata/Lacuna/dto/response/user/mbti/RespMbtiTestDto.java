package LacunaMatata.Lacuna.dto.response.user.mbti;

import LacunaMatata.Lacuna.entity.mbti.MbtiSkinConcern;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespMbtiTestDto {
    private List<RespMbtiSurveyDto> mbtiSurvey;
    private List<MbtiSkinConcern> mbtiSkinConcern;
}
