package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

import java.util.List;

@Data
public class ReqDeleteMbtiResultListDto {
    private List<Integer> mbtiResultIdList;
}
