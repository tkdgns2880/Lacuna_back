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
public class HabitTracker {
    private int habitTrackerId;
    private int habitTrackerMemberUserId; //consultinfMemberId
    private LocalDateTime startDate;
    private String finalFeedback;
    private int finalFeedbackStatus; // 1-false, 2-true
    private int habitTrackerRegisterId; // userId 등록자
    private int status; // 저장상태 1- 임시저장, 2-최종저장
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
