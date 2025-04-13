package ru.perm.v.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.tutorial.entity.TutorialEntity;

import java.util.List;

// , QueryByExampleExecutor<CompanyEntity>

@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, Long> {
    List<TutorialEntity> findByNameOrderByNDesc(String name);

//    Optional<CompanyEntity> findById(Long n);
//    List<CompanyEntity> findAll();
}
