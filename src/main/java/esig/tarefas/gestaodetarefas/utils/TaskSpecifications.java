package esig.tarefas.gestaodetarefas.utils;

import org.springframework.data.jpa.domain.Specification;

import esig.tarefas.gestaodetarefas.modules.entities.StatusTask;
import esig.tarefas.gestaodetarefas.modules.entities.TaskEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class TaskSpecifications {

    public static Specification<TaskEntity> withFilters(String titleOrDescription,
            Integer priority,
            String responsibleUser,
            StatusTask status) {
        return (Root<TaskEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            jakarta.persistence.criteria.Predicate predicate = criteriaBuilder.conjunction();

            if (titleOrDescription != null && !titleOrDescription.isEmpty()) {
                predicate = criteriaBuilder.or(
                        criteriaBuilder.like(root.get("title"), "%" + titleOrDescription + "%"),
                        criteriaBuilder.like(root.get("description"), "%" + titleOrDescription + "%"));
            }

            if (priority != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("priority"), priority));
            }

            if (responsibleUser != null && !responsibleUser.isEmpty()) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(root.get("responsibleUser"), responsibleUser));
            }

            if (status != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
            }

            return predicate;
        };
    }
}
