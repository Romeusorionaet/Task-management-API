package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.exceptions.TaskNotFoundException;
import esig.tarefas.gestaodetarefas.modules.entities.StatusTask;
import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;

@Service
public class DoneTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(UUID taskId) {
        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);

        var statusTaskSaved = taskEntity.getStatus();
        var statusProgress = StatusTask.PROGRESS;

        if (statusTaskSaved == statusProgress) {
            taskEntity.setStatus(StatusTask.DONE);
            taskRepository.save(taskEntity);
        }
    }
}
