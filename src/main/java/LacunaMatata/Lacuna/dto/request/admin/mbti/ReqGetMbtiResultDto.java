package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqGetMbtiResultDto {
    private String search;
    private int page;
    private int limit;
}