package practice.practice6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MovieDto {
    private Integer movieId;
    private String title;
    private String director;
    private String releasedate;
    private Integer rating;
    // baseTime
    private String createDate;
    private String updateDate;
    // Dto -> Entity 변환
    public
}

