package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqModifyMbtiCategoryDto {
    private int mbtiCategoryId;
    private String mbtiCategoryName;
    private String mbtiCategoryTitle;
    private String mbtiCategoryDescription;

    // 이미지 파일을 받는 곳 (신규 업로드, 삭제)
    private List<MultipartFile> insertImgs;
    private String deleteImgPath;
    private String prevImgPath;
}
