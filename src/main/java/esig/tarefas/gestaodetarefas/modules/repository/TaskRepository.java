package esig.tarefas.gestaodetarefas.modules.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    List<TaskEntity> findAll(Specification<TaskEntity> specification);
}
