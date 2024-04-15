package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import esig.tarefas.gestaodetarefas.modules.task.useCases.UpdateTaskUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class updateTaskController {

    @Autowired
    private UpdateTaskUseCase updateTaskUseCase;

    @PutMapping("/update")
    @Tag(name = "Tarefa", description = "Informações da tarefa")
    @Operation(summary = "Atualizar tarefa", description = "Essa função é responsável por atualizar uma tarefa. Para isso, é importante informar o id junto com os dados a serem atualizados")
    public ResponseEntity<Object> updated(
            @Valid @RequestBody TaskEntity taskEntity) {

        try {
            this.updateTaskUseCase.execute(taskEntity);
            return ResponseEntity.ok().build();

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}