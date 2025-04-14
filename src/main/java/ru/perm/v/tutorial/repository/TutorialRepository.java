package ru.perm.v.tutorial.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import ru.perm.v.tutorial.entity.TutorialEntity;

import java.util.List;
import java.util.Optional;

// , QueryByExampleExecutor<CompanyEntity>

@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, Long>  {
    List<TutorialEntity> findByTitleOrderByNDesc(String name);

    Optional<TutorialEntity> findById(Long n);
    List<TutorialEntity> findAll();
    List<TutorialEntity> findAll(Specification<TutorialEntity> spec);
}
