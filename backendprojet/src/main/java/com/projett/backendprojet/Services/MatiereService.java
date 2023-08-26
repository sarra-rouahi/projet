package com.projett.backendprojet.Services;

import com.projett.backendprojet.Repository.MatiereRepository;
import com.projett.backendprojet.Response.Reponse;
import com.projett.backendprojet.models.Matiere;
import com.projett.backendprojet.models.Personne;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;

    public Reponse ajoutermatiere(Matiere matiere) {
        Matiere m=matiereRepository.findMatiereByMotcle(matiere.getMotcle()).orElse(null);
        if (m==null){
            matiereRepository.save(matiere);
            return new Reponse("ajoute avec succes") ;

        }
        else{
            throw  new IllegalStateException("  matiere deja ajoutee");
        }
    }

    public List<Matiere> affichematere() {
        return matiereRepository.getmatiere();
    }

    public Matiere affichematiereaveccode(String motcle) {
        Matiere m= matiereRepository.findMatiereByMotcle(motcle).orElse(null);
        if (m==null){
            throw new IllegalStateException("matiere inexistante");
        }
        return m;
    }

    public Reponse supprimematiere(String motcle) {
       Matiere m = matiereRepository.findMatiereByMotcle(motcle).orElse(null);
        if (m==null){
            return new Reponse("matiere deja inexistant");
        }
        else {
          matiereRepository.deleteMatiereByMotcle(motcle);
            return new Reponse("supprime avec succes");
        }
    }

    public Reponse modifiermatiere(Matiere matiere) {
      Matiere m=matiereRepository.findMatiereByMotcle(matiere.getMotcle()).orElse(null);
            if (m==null){            throw new IllegalStateException("matiere innexistant");
            }
            else {
                Matiere matiereavecmotcle=matiereRepository.findMatiereByMotcle(matiere.getMotcle()).orElse(null);
                if(matiereavecmotcle!=null &&  matiereavecmotcle.getMotcle() != m.getMotcle()){
                    throw new IllegalStateException("mot cle existant");

                }
                else {
                    m.setNom(matiere.getNom());


                    matiereRepository.save(m);
                    return new Reponse("Matiere modifie") ;
                }
            }
    }
}

