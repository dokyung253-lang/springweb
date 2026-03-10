package practice.practice7;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.course.CourseEntity;
import practice.practice7.course.CourseRepository;
import practice.practice7.student.StudentEntity;
import practice.practice7.student.StudentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EnrollService {
    @Autowired private EnrollRepository enrollRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;

    // 1. 과정등록
    public boolean add1(Map<String, Object> map) {
        // 1) map/dto -> entity 변환한다.
        CourseEntity saveEntity = new CourseEntity();
        saveEntity.setCname(String.valueOf(map.get("cname")));
        // 2) 변환된 entity 저장한다.
        CourseEntity saved = courseRepository.save(saveEntity);
        // 3) 반환된 pk 확인한다.
        if (saved.getCid() >= 1) {return true;
        } else { return false; }
    }

    // 2. 학생등록
    public boolean add2(Map<String, Object> map) {
        StudentEntity saveEntity = new StudentEntity();
        saveEntity.setSname(String.valueOf(map.get("sname")));
        StudentEntity saved = studentRepository.save(saveEntity);
        if (saved.getSid() >= 1) {return true;}
        else {return false;}
    }

    // 3. 수강신청 등록
    public boolean add3( Map<String, Object> map) {
        // 1) 수강신청 엔티티 생성
        EnrollEntity saveEntity = new EnrollEntity();
        saveEntity.setStatus(String.valueOf(map.get("status")));
        // ************* FK에 해당하는 엔티티 대입***************
        int cid = Integer.parseInt(String.valueOf(map.get("cid"))); // [1] fk 확인한다. dto/map 등등
        Optional<CourseEntity> optionalCourse = courseRepository.findById(cid); // [2] fk에 해당하는 엔티티 찾는다.
        if (optionalCourse.isPresent()) { // [3] 만약에 해당 엔티티가 존재하면
            CourseEntity courseEntity = optionalCourse.get(); // [4] 엔티티 꺼내기
            saveEntity.setCourseEntity(courseEntity);// [5] fk 엔티티 단방향에 저장한다.
        } else {return false; }
        // ************* FK에 해당하는 엔티티 대입***************
        int sid = Integer.parseInt(String.valueOf(map.get("sid"))); // 학생번호(sid) 확인
        Optional<StudentEntity> optionalStudent = studentRepository.findById(sid); // 학생번호에 해당하는 엔티티 1개 조회
        if (optionalStudent.isPresent()) { // 조회한 결과가 존재하면
            StudentEntity studentEntity = optionalStudent.get(); // 학생엔티티 꺼내기
            saveEntity.setStudentEntity(studentEntity);// 학생엔티티를 수강신청엔티티에 대입
        } else { return false; }
        // 2) 수강신청 엔티티 저장
        EnrollEntity saved = enrollRepository.save(saveEntity);
            // 3)
        if( saved.getEid() >= 1){return true;}
        else{ return false;}
    }

    // 4. 개별 수강정보 조회
    public Map<String, Object> get(int eid){
        Optional<EnrollEntity> optionalEnroll = enrollRepository.findById(eid); // 1. eid에 해당하는 엔티티 찾기
        if(optionalEnroll.isPresent()){ // 2. 만약에 존재하면
        EnrollEntity enrollEntity = optionalEnroll.get();  // 3. 엔티티 꺼내기
        // 4. 엔티티 -> dto/map 변환
            Map<String, Object> map = new HashMap<>();
            map.put("eid", enrollEntity.getEid());
            map.put("status", enrollEntity.getStatus());
            map.put("createDate", enrollEntity.getCreatedDate());
            map.put("updateDate", enrollEntity.getUpdateDate());
            map.put("cname", enrollEntity.getCourseEntity().getCname()); // FK 엔티티 내 특정 필드만
            map.put("sname", enrollEntity.getStudentEntity().getSname()); // FK 엔티티 내 특정 필드만
            return map;
        }
        return null;
    }
}
