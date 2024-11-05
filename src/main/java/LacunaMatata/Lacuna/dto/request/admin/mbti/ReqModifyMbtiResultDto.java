package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.util.List;
import java.util.Map;

@Data
public class ReqModifyMbtiResultDto {
    private int mbtiResultId;
    private String mbtiResultTitle;
    private String mbtiResultCategoryName;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private int mbtiResultStatus;

    // MBTI 신규 이미지 등록 dto
    private Multipart insertImg;
    private List<MultipartFile> insertImgs;
    private List<Map<String, Object>> DeleteMbtiResultImgs;
}
