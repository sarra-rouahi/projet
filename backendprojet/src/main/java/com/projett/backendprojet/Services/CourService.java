package com.projett.backendprojet.Services;

import com.projett.backendprojet.Repository.CourRepository;
import com.projett.backendprojet.Repository.MatiereRepository;
import com.projett.backendprojet.Response.Reponse;
import com.projett.backendprojet.models.Cour;
import com.projett.backendprojet.models.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourService {
    @Autowired
    private CourRepository courRepository;
    public Reponse ajoutercour(Cour cour) {
       Cour c= courRepository.findMatiereBynom(cour.getNom()).orElse(null);
        if (c==null){
           courRepository.save(cour);
            return new Reponse("ajoute avec succes") ;

        }
        else{
            throw  new IllegalStateException("  cour deja ajoute");
        }

    }

    public List<Cour> affichecour() {
        return courRepository.gettcour();
    }

    public Cour affichecouravecnom(String nom) {
        Cour c= courRepository.findMatiereBynom(nom).orElse(null);
        if (c==null){
            throw new IllegalStateException("cour inexistant");
        }
        return c;
    }

    public Reponse suppricour(String nom) {
        Cour c = courRepository.findMatiereBynom(nom).orElse(null);
        if (c==null){
            return new Reponse("cour deja inexistant");
        }
        else {
            courRepository.deleteMatiereBynom(nom);
            return new Reponse("supprime avec succes");
        }
    }

    public Reponse modifiercour(Cour cour) {
        Cour c=courRepository.findMatiereBynom(cour.getNom()).orElse(null);
        if (c==null){            throw new IllegalStateException("cour innexistant");
        }
        else {
            Cour couravecnom=courRepository.findMatiereBynom(cour.getNom()).orElse(null);
            if(couravecnom!=null &&  couravecnom.getNom() != c.getNom()){
                throw new IllegalStateException("nom existant");

            }
            else {
                c.setNom(cour.getNom());
                c.setPiecejointe(cour.getPiecejointe());
                c.setMatiere(cour.getMatiere());


                courRepository.save(c);
                return new Reponse("cour modifie") ;
            }
        }
    }
    }

