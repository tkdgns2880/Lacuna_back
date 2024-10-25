package LacunaMatata.Lacuna.entity.habitTracker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeeklyContents {
    private int weeklyContentsId;
    private int weeklyContentsHabitTrackerId; // habitTrackerId
    private int weeklyOrder; // 주별 순번
    private String title; // 주차 할 일 제목
    private int weeklyContentsRegisterId; //userId 등록자
}
