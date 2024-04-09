package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.entity.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.task.useCases.CreateTaskUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class taskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody TaskEntity taskEntity) {
        try {
            var result = this.createTaskUseCase.execute(taskEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}