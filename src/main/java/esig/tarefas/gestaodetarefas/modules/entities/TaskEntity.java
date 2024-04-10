package esig.tarefas.gestaodetarefas.modules.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(min = 3, max = 10, message = "O título deve conter no mínimo 3 caracteres.")
    private String title;

    @Length(min = 10, message = "A descrição da tarefa deve conter no mínimo 10 caracteres para fornecer detalhes adequados sobre a tarefa.")
    private String description;

    private String responsibleUser;

    @Range(min = 1, max = 10, message = "O valor esperado deve ser entre 1 a 10.")
    private int priority;

    private LocalDateTime deadline;

    @CreationTimestamp
    private LocalDateTime createdAt;
}