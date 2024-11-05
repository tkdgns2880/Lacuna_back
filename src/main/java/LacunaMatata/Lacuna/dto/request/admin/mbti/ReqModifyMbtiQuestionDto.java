package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqModifyMbtiQuestionDto {
    private int mbtiId;
    private int mbtiCategoryId;
    private String mbtiCode;
    private String mbtiTitle;
    private List<String> optionName;
    private List<Integer> optionScore;
    private List<Integer> deleteOptionIdList;

    // 이미지 파일을 받는 곳 (신규 업로드, 삭제)
    private List<MultipartFile> insertImgs;
    private String deleteImgPath;
    private String prevImgPath;
}
