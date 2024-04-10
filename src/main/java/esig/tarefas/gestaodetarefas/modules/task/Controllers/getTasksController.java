package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.task.useCases.GetTasksUseCase;

@RestController
@RequestMapping("/task")
public class getTasksController {

    @Autowired
    private GetTasksUseCase getTasksUseCase;

    @GetMapping("/get-tasks")
    public ResponseEntity<Object> create(TaskEntity taskEntity) {
        var result = this.getTasksUseCase.execute();
        return ResponseEntity.ok().body(result);

    }
}