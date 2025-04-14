package ru.perm.v.tutorial.critery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import ru.perm.v.tutorial.entity.TutorialEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class TutorialSpecification {
    private static EntityManager entityManager;

    public static Specification<TutorialEntity> hasWithTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), title);
    }
    public static Specification<TutorialEntity> nIn(List<Long> nn) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get("n")).value(nn);
    }

}
