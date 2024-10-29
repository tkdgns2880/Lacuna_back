package LacunaMatata.Lacuna.entity.habitTracker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HabitTrackerWeeklyTodo {
    private int weeklyTodoId;
    private int weeklyTodoContentsId; // weeklyContentsId
    private int dailyOrder; // 일별순번
    private String dailyTodo;
    private int status; // 진행상태 1 - false, 2 - true
    private LocalDateTime updateDate;
}
