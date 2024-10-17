package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqRegisterMbtiCategoryDto {
    private String mbtiCategoryName;
    private String mbtiCategoryDescription;
    private String mbtiCategoryImg;
}
