package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.exceptions.TaskNotFoundException;
import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;

@Service
public class FetchTaskDetailsUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public Optional<TaskEntity> execute(UUID taskId) {
        var taskEntity = this.taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException());

        return Optional.of(taskEntity);
    }
}
