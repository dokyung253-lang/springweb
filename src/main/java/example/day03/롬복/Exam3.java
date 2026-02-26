package example.day03.롬복;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Exam3 {
    public static void main(String[] args) {
        /*
         롬복 lombok :
        */
        StudentDto studentDto1 = new StudentDto();
        StudentDto studentDto2 = new StudentDto( 1, "유재석" );
        studentDto2.getSname();
        studentDto2.setSname("강호동");
        studentDto2.toString();

        // * 생성자는 매개변수의 순서대로 인자값 전달해야 한다. 유연성 떨어진다.
        // StudentDto studentDto3 = new StudentDto( "유재석" , 1 ); // 매개변수의 순서 바뀌므로(x)
        // [해결책] 빌더패턴; 객체 만드는 패턴 : 유연성 제공
        // 클래스명.builder().멤버변수명(값).멤버변수명(값).build();
        StudentDto studentDto4 = StudentDto.builder()
                .sno(1).sname("유재석").build();
         StudentDto studentDto5 = StudentDto.builder()
                 .sname("유재석").sno(2).build();
         StudentDto studentDto6 = StudentDto.builder()
                 .sname("유재석").build();
    } // main end
} // class end

@NoArgsConstructor // 컴파일(코드 번역될 때) 기본생성자 코드 자동 생성 // 빈생성자 제공
@AllArgsConstructor // 컴파일(코드 번역될 때) 전체매개변수생성자 코드 자동생성
@Data // @getter + @setter + @ToString + @RequiredArgsConstructor // 여러개 집합
@Builder // 빌더패턴 사용 // 생성자 직접 사용 안하고 메소드 이용하여 유연하게 사용
// @Getter // getter 메소드 제공
// @Setter // Setter 메소드 제공
// @ToString // ToString 메소드 제공
// @RequiredArgsConstructor // final 매개변수 생성자 자동 생성

class StudentDto{
    // 1. private 멤버변수
    private int sno;
    private String sname;
    // 2. 빈 생성자, 풀 생성자

    // getter/setter, toString
}
