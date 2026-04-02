package practice.srpractice1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.srpractice1.Entity.TaskEntity;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class TaskDto {
    private Integer id;
    private String title;
    private String content;
    private String requester;
    private String status;
    private String createDate;
    private String updateDate;

    public TaskEntity toEntity(){
        return TaskEntity.builder()
                .id(id) .title(title) .content(content) .requester(requester) .status(status)
                .build();
    }
}

