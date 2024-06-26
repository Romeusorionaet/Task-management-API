package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.task.useCases.RemoveTaskUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/task")
public class removeTaskController {

    @Autowired
    private RemoveTaskUseCase removeTaskUseCase;

    @DeleteMapping("/remove/{taskId}")
    @Tag(name = "Tarefa", description = "Infomações da tarefa")
    @Operation(summary = "Remover tarefa", description = "Essa função é responsável por remover uma tarefa")
    public ResponseEntity<Object> remove(@PathVariable UUID taskId) {
        try {
            this.removeTaskUseCase.execute(taskId);

            return ResponseEntity.ok().build();

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}