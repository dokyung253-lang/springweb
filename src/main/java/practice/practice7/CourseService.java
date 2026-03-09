package practice.practice7;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.practice7.course.CourseDto;
import practice.practice7.course.CourseEntity;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public boolean saveCourse(){
        CourseEntity courseEntity = new CourseEntity();
        CourseEntity saved = courseRepository.save(CourseDto.toEntity());
        if (saved.getCourseId() >= 1) return true;
        return false;
    }
}
