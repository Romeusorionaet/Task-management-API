package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.exceptions.TaskNotFoundException;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;

@Service
public class RemoveTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(UUID taskId) {
        this.taskRepository.findById(taskId).ifPresentOrElse(
                (task) -> {
                    this.taskRepository.deleteById(taskId);
                },
                () -> {
                    throw new TaskNotFoundException();
                });
    }
}
