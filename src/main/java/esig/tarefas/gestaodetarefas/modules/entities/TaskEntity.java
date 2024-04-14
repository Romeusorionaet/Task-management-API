package esig.tarefas.gestaodetarefas.modules.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Data
@Entity(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(min = 3, message = "O título deve conter no mínimo 3 caracteres.")
    @Length(max = 100, message = "O título pode conter no máximo 100 caracteres.")
    private String title;

    @Column(length = 2000)
    @Length(min = 10, message = "A descrição da tarefa deve conter no mínimo 10 caracteres para fornecer detalhes adequados sobre a tarefa.")
    @Length(max = 2000, message = "A descrição da tarefa pode conter no máximo 2000 caracteres.")
    private String description;

    @Length(min = 1, message = "É obrigatório indentificar o responsável pela tarefa.")
    private String responsibleUser;

    @Enumerated(EnumType.ORDINAL)
    private PriorityTask priority;

    private LocalDateTime deadline;

    @Enumerated(EnumType.ORDINAL)
    private StatusTask status;

    @CreationTimestamp
    private LocalDateTime createdAt;
}