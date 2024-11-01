package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqModifyUpperConsulingCategoryDto {
    private int consultingUpperCategoryId;
    private String consultingUpperCategoryName;
    private String consultingUpperCategoryDescription;
    private String consultingUpperCategoryImg;
}
