package LacunaMatata.Lacuna.entity.consulting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultingUpperCategory {
    private int consultingUpperCategoryId;
    private String consultingUpperCategoryName;
    private String consultingUpperCategoryDescription;
    private String consultingUpperCategoryImg;
    private int consultingUpperCategoryRegisterId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
