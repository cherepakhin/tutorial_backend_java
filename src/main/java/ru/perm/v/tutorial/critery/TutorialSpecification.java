package ru.perm.v.tutorial.critery;

import ru.perm.v.tutorial.entity.TutorialEntity;
import org.springframework.data.jpa.domain.Specification;

public class TutorialSpecification {
    public static Specification<TutorialEntity> hasWithTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), title);
    }
}
