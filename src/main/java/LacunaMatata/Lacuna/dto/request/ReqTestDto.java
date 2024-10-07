package LacunaMatata.Lacuna.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqTestDto {
    @ApiModelProperty(value = "테스트 데이터", example = "1234", required = true)
    private String testDate;
}

