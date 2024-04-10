package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;

@Service
public class GetTasksUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> execute() {
        var tasks = this.taskRepository.findAll();

        return tasks;
    }
}
