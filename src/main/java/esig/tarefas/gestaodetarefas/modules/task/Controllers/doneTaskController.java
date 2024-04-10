package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.task.useCases.DoneTaskUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class doneTaskController {

    @Autowired
    private DoneTaskUseCase doneTaskUseCase;

    @PatchMapping("/done/{taskId}")
    public ResponseEntity<Object> create(
            @Valid @PathVariable UUID taskId) {

        try {
            this.doneTaskUseCase.execute(taskId);
            return ResponseEntity.ok().build();

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}