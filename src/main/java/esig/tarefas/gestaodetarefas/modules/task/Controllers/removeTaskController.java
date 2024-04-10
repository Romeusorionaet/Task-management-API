package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.task.useCases.RemoveTaskUseCase;

@RestController
@RequestMapping("/task")
public class removeTaskController {

    @Autowired
    private RemoveTaskUseCase removeTaskUseCase;

    @DeleteMapping("/remove/{taskId}")
    public ResponseEntity<Object> create(@PathVariable UUID taskId) {
        try {
            this.removeTaskUseCase.execute(taskId);

            return ResponseEntity.ok().build();

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}