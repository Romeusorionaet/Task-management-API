package esig.tarefas.gestaodetarefas.modules.task.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esig.tarefas.gestaodetarefas.modules.entities.StatusTask;
import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.repository.TaskRepository;
import esig.tarefas.gestaodetarefas.utils.TaskSpecifications;
import org.springframework.data.jpa.domain.Specification;

@Service
public class SearchTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> execute(
            String titleOrDescription,
            Integer priority,
            String responsibleUser,
            StatusTask status) {

        Specification<TaskEntity> spec = TaskSpecifications.withFilters(titleOrDescription, priority, responsibleUser,
                status);
        return taskRepository.findAll(spec);
    }
}
