package practice.srpractice1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.srpractice1.BaseTime;
import practice.srpractice1.dto.TaskDto;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "task")
public class TaskEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String requester;
    private String status;

    public TaskDto toDto(){
        return TaskDto.builder()
                .id(id) .title(title) .content(content) .requester(requester) .status(status)
                .build();
    }



}
