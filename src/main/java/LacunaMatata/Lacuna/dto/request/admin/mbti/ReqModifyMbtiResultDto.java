package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Data
public class ReqModifyMbtiResultDto {
    private int mbtiResultId;
    private String mbtiResultTitle;
    private String mbtiResultCategoryName;
    private String mbtiResultSummary;
    private String mbtiResultContent;

    // MBTI 신규 이미지 등록 dto
    // 이미지 파일을 받는 곳 (신규 업로드, 삭제)
    private List<MultipartFile> insertImgs;
    private String deleteImgPath;
    private String prevImgPath;
}
