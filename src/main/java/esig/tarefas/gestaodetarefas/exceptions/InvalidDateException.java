package esig.tarefas.gestaodetarefas.exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException() {
        super("A data de vencimento deve ser de no mínimo 1 dia futuro de diferença da data atual.");
    }
}
