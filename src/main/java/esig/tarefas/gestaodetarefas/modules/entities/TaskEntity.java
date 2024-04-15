package esig.tarefas.gestaodetarefas.modules.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
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

    @Schema(example = "Tarefa exemplo 1", requiredMode = RequiredMode.REQUIRED)
    @Length(min = 3, message = "O título deve conter no mínimo 3 caracteres.")
    @Length(max = 100, message = "O título pode conter no máximo 100 caracteres.")
    private String title;

    @Schema(example = "Descrição da Tarefa exemplo 1", requiredMode = RequiredMode.REQUIRED)
    @Column(length = 2000)
    @Length(min = 10, message = "A descrição da tarefa deve conter no mínimo 10 caracteres para fornecer detalhes adequados sobre a tarefa.")
    @Length(max = 2000, message = "A descrição da tarefa pode conter no máximo 2000 caracteres.")
    private String description;

    @Schema(example = "Romeu Soares")
    @Length(min = 1, message = "É obrigatório indentificar o responsável pela tarefa.")
    private String responsibleUser;

    @Enumerated(EnumType.ORDINAL)
    private PriorityTask priority;

    @Schema(example = "2030-04-15T17:06:21.516Z", requiredMode = RequiredMode.REQUIRED)
    private LocalDateTime deadline;

    @Enumerated(EnumType.ORDINAL)
    private StatusTask status;

    @CreationTimestamp
    private LocalDateTime createdAt;
}