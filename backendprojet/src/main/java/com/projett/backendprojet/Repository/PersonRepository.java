package com.projett.backendprojet.Repository;

import com.projett.backendprojet.models.Matiere;
import com.projett.backendprojet.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Personne,Integer> {
    Optional<Personne> findPersonneByEmail(String email);
@Query(value = "SELECT * from personne",nativeQuery = true)
    List<Personne> getpersonne();
}
