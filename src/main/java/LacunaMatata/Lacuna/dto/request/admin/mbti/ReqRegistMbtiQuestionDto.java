package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqRegistMbtiQuestionDto {
    private String mbtiCategoryName;
    private String mbtiCode;
    private String mbtiTitle;
    private List<String> optionName;
    private List<Integer> optionScore;

    private List<MultipartFile> insertImgs;
}
