package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.task.useCases.CreateTaskUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class createTaskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody TaskEntity taskEntity) {
        try {
            this.createTaskUseCase.execute(taskEntity);
            return ResponseEntity.ok().build();

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}