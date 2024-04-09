package esig.tarefas.gestaodetarefas.modules.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import esig.tarefas.gestaodetarefas.modules.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}
