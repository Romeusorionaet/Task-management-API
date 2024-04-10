package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.task.useCases.UpdateTaskUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class updateTaskController {

    @Autowired
    private UpdateTaskUseCase updateTaskUseCase;

    @PutMapping("/update")
    public ResponseEntity<Object> create(
            @Valid @RequestBody TaskEntity taskEntity) {

        try {
            this.updateTaskUseCase.execute(taskEntity);
            return ResponseEntity.ok().build();

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}