package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqRegistMbtiCategoryDto {
    private String mbtiCategoryName;
    private String mbtiCategoryTitle;
    private String mbtiCategoryDescription;

    private List<MultipartFile> insertImgs;
}
