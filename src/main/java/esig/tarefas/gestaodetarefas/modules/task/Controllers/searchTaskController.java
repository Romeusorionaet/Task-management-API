package esig.tarefas.gestaodetarefas.modules.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import esig.tarefas.gestaodetarefas.modules.entities.StatusTask;
import esig.tarefas.gestaodetarefas.modules.task.useCases.SearchTaskUseCase;

@RestController
@RequestMapping("/task")
public class searchTaskController {

    @Autowired
    private SearchTaskUseCase searchTaskUseCase;

    @GetMapping("/search")
    public ResponseEntity<Object> create(
            @RequestParam String titleOrDescription,
            @RequestParam(required = false) Integer priority,
            @RequestParam String responsibleUser,
            @RequestParam(required = false) StatusTask status) {

        try {
            var result = this.searchTaskUseCase.execute(
                    titleOrDescription,
                    priority,
                    responsibleUser,
                    status);
            return ResponseEntity.ok().body(result);

        } catch (Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}