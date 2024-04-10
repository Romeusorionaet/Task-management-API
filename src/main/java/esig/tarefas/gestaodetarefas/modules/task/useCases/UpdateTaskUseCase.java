package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.exceptions.InvalidDateException;
import esig.tarefas.gestaodetarefas.exceptions.TaskNotFoundException;
import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;

@Service
public class UpdateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(TaskEntity taskEntity) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime futureDate = currentDate.plus(1, ChronoUnit.DAYS);

        var deadline = taskEntity.getDeadline();

        if (deadline != null && !deadline.isAfter(futureDate)) {
            throw new InvalidDateException();
        }

        this.taskRepository.findById(taskEntity.getId())
                .orElseThrow(() -> new TaskNotFoundException());

        TaskEntity task = new TaskEntity();
        task.setId(taskEntity.getId());
        task.setTitle(taskEntity.getTitle());
        task.setDescription(taskEntity.getDescription());
        task.setDeadline(taskEntity.getDeadline());
        task.setResponsibleUser(taskEntity.getResponsibleUser());
        task.setPriority(taskEntity.getPriority());
        task.setCreatedAt(taskEntity.getCreatedAt());

        this.taskRepository.save(task);
    }
}
