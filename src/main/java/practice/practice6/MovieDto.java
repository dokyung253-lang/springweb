package practice.practice6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
[조건 3] DTO 설계 : 영화 정보를 전송하기 위한 DTO 클래스를 생성한다.
    - DTO는 View와 Controller 간 데이터 전달용 객체이다.
    - 필드는 Entity와 동일하게 구성하되, 아래 메서드를 포함할 것.
    - public MovieEntity toEntity() : DTO → Entity 변환
*/
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
    public MovieEntity toEntity(){
        // 빌더패턴이란? new생성자가 아닌 함수메서드로 객체 생성
        return MovieEntity.builder()
                .movieId( movieId )     .title( title )
                .director(director)     .releasedate(releasedate)
                .rating(rating)
                .build();
    }
}

