package LacunaMatata.Lacuna.dto.request.admin.mbti;

import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqRegistMbtiResultDto {
    private String mbtiResultTitle;
    private String mbtiResultCategoryName;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private int mbtiResultStatus;

    // MBTI 결과 이미지 파일을 받는 곳
    private MultipartFile insertImg; // 대표 이미지
    private List<MultipartFile> insertImgs; // 퀼 이미지
}
