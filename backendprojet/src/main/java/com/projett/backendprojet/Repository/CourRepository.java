package com.projett.backendprojet.Repository;

import com.projett.backendprojet.models.Cour;
import com.projett.backendprojet.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourRepository extends JpaRepository<Cour,Integer> {
     Optional<Cour> findMatiereBynom(String nom);
    Optional<Cour> deleteMatiereBynom(String nom);
    @Query(value = "SELECT * from cour", nativeQuery = true)

    List<Cour> gettcour();
}
