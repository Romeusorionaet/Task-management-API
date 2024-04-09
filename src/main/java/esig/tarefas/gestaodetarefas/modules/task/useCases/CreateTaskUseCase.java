package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.exceptions.InvalidDateException;
import esig.tarefas.gestaodetarefas.modules.entity.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;

@Service
public class CreateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity execute(TaskEntity taskEntity) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime futureDate = currentDate.plus(1, ChronoUnit.DAYS);

        var deadline = taskEntity.getDeadline();

        if (deadline != null && !deadline.isAfter(futureDate)) {
            throw new InvalidDateException();
        }

        return this.taskRepository.save(taskEntity);
    }
}
