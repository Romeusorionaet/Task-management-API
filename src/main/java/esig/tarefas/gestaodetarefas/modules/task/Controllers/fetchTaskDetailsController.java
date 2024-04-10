package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.task.useCases.FetchTaskDetailsUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class fetchTaskDetailsController {

    @Autowired
    private FetchTaskDetailsUseCase fetchTaskDetailsUseCase;

    @GetMapping("/details/{taskId}")
    public ResponseEntity<Object> create(
            @Valid @PathVariable UUID taskId) {

        try {
            var result = this.fetchTaskDetailsUseCase.execute(taskId);
            return ResponseEntity.ok().body(result);

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}