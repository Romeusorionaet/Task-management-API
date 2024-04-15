package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.task.useCases.GetTasksUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/task")
public class getTasksController {

    @Autowired
    private GetTasksUseCase getTasksUseCase;

    @GetMapping("/get-tasks")
    @Tag(name = "Tarefa", description = "Infomações da tarefa")
    @Operation(summary = "Listagem de tarefas", description = "Essa função é responsável por listar todas as tarefas")
    public ResponseEntity<Object> get() {
        var result = this.getTasksUseCase.execute();
        return ResponseEntity.ok().body(result);

    }
}