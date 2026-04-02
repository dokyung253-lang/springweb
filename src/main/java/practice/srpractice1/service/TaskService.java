package practice.srpractice1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import practice.srpractice1.Entity.TaskEntity;
import practice.srpractice1.dto.TaskDto;
import practice.srpractice1.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    public final TaskRepository taskRepository;

    // 1. 등록
    public TaskDto taskPost(TaskDto taskDto) {
        return taskRepository.save(taskDto.toEntity()).toDto();
    }

    // 2. 전체조회
    public List<TaskDto> taskList() {
        return taskRepository.findAll()
                .stream()
                .map(TaskEntity::toDto)
                .collect(Collectors.toList());
    }

    // 3. 상세조회
    public TaskDto taskDetailList(Integer id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        return taskEntity.toDto();
    }

    // 4. 수정
    @Transactional
    public TaskDto updateTask(Integer id, TaskDto request) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        taskEntity.setTitle(request.getTitle());
        taskEntity.setContent(request.getContent());
        taskEntity.setStatus(request.getStatus());
        return taskEntity.toDto();
    }

    // 5. 삭제
    public boolean deleteTask(Integer id) {
        boolean exist = taskRepository.existsById(id);
        if (exist) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
