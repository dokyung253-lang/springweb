package example.의존성;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Exam2 { }
// ==== 방법 1 : 다른 클래스의 메소드를 호출하는 방법 1 ===== 직접객체관리 직접 객체 호출
class TaskDao1{ void method1(){} }
class TaskController1{
    void method(){
        TaskDao1 taskDao1 = new TaskDao1(); //  객체 생성
        taskDao1.method1(); // 해당 객체 내 메소드 호출
    }
}

// ==== 방법 2 : 다른 클래스의 메소드를 호출하는 방법 2 ===== static(정적 메소드)은 객체없이
class TaskDao2{ static void method1(){} }
class TaskController2{
    void method2(){
        TaskDao2.method1(); //static 메소드는 객체없이 클래스명.메소드명
    }
}

// ==== 방법 3 : 다른 클래스의 메소드를 호출하는 방법 3 ===== 싱글톤이 메소드 호출하는 방법
class TaskDao3{
    private TaskDao3(){}
    private static TaskDao3 instance = new TaskDao3();
    public static TaskDao3 getInstance(){return instance;}
    void method1(){}
    }
class TaskController3{
    void method(){
        TaskDao3.getInstance().method1();
    }

    // ==== 방법 4 : 다른 클래스의 메소드를 호출하는 방법 4 =====
    @Component // 라벨/스티커, 스프링 컨테이너 빈 등록
    class TaskDao4{ void method1(){} }
    class TaskController4{
        // DI 방법 1 : 해당하는 변수에 스프링 빈에 등록된 객체를 주입한다.
        // @Autowired TaskDao4 taskDao4;
        // DI 방법 2 *권장*
        private final TaskDao4 taskDao4; // final은 수정불가능한 키워드, 초기화 필수
        @Autowired
                public TaskController4( TaskDao4 taskDao4 ){
            this.taskDao4 = taskDao4;
        }

        void method(){
            taskDao4.method1();
        }
    }
}


/*
    IOC : Injection of Controller 제어의 역전 ; 개발자가 직접 해야하는 "객체 제어권"을 "스프링"에게 위임
        1. 정의 : 객체의 생성과 관리의 *제어권*을 개발자가 아닌 스프링에게 위임한다.
        2. 스프링에서 스프링 *컨테이너* 담당한다.
        3. 목적 : 개발자에게 편의성, 규칙성(협업간의 객체 충돌)
        4. 주요 어노테이션
            @Component      : 스프링 컨테이너에 클래스(Bean 빈)의 정보를 등록한다.
            Spring MVC 내장  : @Controller, @RestController, @Service, @Repository, @Comfiguration 등등
            * 즉] MVC 패턴은 IOC 기반이면서 필수이다.
            * Bean : 빈 객체 , Component : 재사용 가능한 모듈 , Module : 최소한의 기능단위
            * 스프링 Spring : 대규모 마이크로서비스(조각단위 서비스 다량 모음; 대기업) 대상
    DI : Dependency injection 의존성 주입 ; 위임한 객체 제어권에서 "객체 불러오기" *DI는 IOC를 표현하는 기술 중 하나
        1. 정의 : 객체를 직접 생성하지 않고 외부(스프링 컨테이너)로 부터 객체 주입받도록 하는 방법
        2. 목적 : 객체들간의 결합도(관계)를 낮추고 유지보수성 향상
        3. 주요 어노테이션
        @Auto
 */
