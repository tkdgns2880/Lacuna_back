package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqRegistMbtiQuestionDto {
    private int mbtiCategoryId;
    private String mbtiCode;
    private String mbtiTitle;
    private List<ReqRegistOptionDto> options;

    private List<MultipartFile> insertImgs;
}
