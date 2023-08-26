package com.projett.backendprojet.Services;

import com.projett.backendprojet.Repository.PersonRepository;
import com.projett.backendprojet.Response.Reponse;
import com.projett.backendprojet.models.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    @Autowired
    private PersonRepository personneRepository;

    public Reponse ajouterpersonne(Personne personne) {
        Personne p=personneRepository.findPersonneByEmail(personne.getEmail()).orElse(null);
        if (p==null) {
            personneRepository.save(personne);
            return new Reponse("ajoute avec succes");
        }
        else{
            throw  new IllegalStateException(" deja ajoute");
        }
    }
    public List<Personne> affichepersonne() {
        return personneRepository.getpersonne();
    }

    public Personne affichepersonneavecid(int id) {
        Personne p= personneRepository.findById(id).orElse(null);
        if (p==null){
            throw new IllegalStateException("personne innexistant");
        }
       return p ;

    }

    public Reponse supprimepersonne(int id) {
        Personne p = personneRepository.findById(id).orElse(null);
        if (p==null){
            return new Reponse("personne deja inexistant");
        }
        else {
            personneRepository.deleteById(id);
            return new Reponse("supprime avec succes");
        }
    }

    public Reponse modifierpersonne(Personne personne) {
        Personne p=personneRepository.findById(personne.getId()).orElse(null);
        if (p==null){            throw new IllegalStateException("personne innexistant");
        }
        else {
            Personne personneavecemail= personneRepository.findPersonneByEmail(personne.getEmail()).orElse(null);
            if(personneavecemail!=null &&  personneavecemail.getId()!=p.getId()){
                throw new IllegalStateException("email existant");

            }
            else {
                p.setNom(personne.getNom());
                p.setPrenom(personne.getPrenom());
                p.setProfession(personne.getProfession());
                p.setEmail(personne.getEmail());
                p.setMotdepasse(personne.getMotdepasse());
                personneRepository.save(p);
                return new Reponse("personne modifie") ;
            }
        }
    }
}
