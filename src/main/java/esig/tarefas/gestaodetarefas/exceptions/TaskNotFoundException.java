package esig.tarefas.gestaodetarefas.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("Tarefa não encontrada.");
    }
}
