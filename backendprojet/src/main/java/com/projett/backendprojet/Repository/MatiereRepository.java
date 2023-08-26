package com.projett.backendprojet.Repository;

import com.projett.backendprojet.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MatiereRepository extends JpaRepository<Matiere,Integer> {

    Optional<Matiere> findMatiereByMotcle(String motcle);
    Optional<Matiere> deleteMatiereByMotcle(String motcle);

@Query(value = "SELECT * from matiere", nativeQuery = true)
    List<Matiere> getmatiere();
}
