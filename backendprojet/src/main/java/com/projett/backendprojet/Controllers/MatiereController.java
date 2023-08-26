package com.projett.backendprojet.Controllers;

import com.projett.backendprojet.Response.Reponse;
import com.projett.backendprojet.Services.MatiereService;
import com.projett.backendprojet.models.Matiere;
import com.projett.backendprojet.models.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ={
        "http://localhost:4200",
        "https://staging.example.com",
        "https://app.example.com"
},methods = {
        RequestMethod.DELETE,RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.POST
}
)@RestController
public class MatiereController {
    @Autowired
    private MatiereService matiereService;
    @PostMapping ("/ajouterMatiere")
    public Reponse ajoutermatiere(@RequestBody Matiere matiere){
       return matiereService.ajoutermatiere(matiere);
    }
    @GetMapping("/afficheMatiere")
    public List<Matiere> getpersonne(){
        return  matiereService.affichematere();
    }
    @GetMapping("/afficheMatiereavecmotcle/{motcle}")
    public Matiere affichematiereaveccode(@PathVariable String motcle){
        return matiereService.affichematiereaveccode(motcle);
    }
    @DeleteMapping("/supprimematiere/{motcle}")
    public Reponse supprimematiere(@PathVariable String motcle){
        return matiereService.supprimematiere(motcle);
    }
    @PutMapping ("/modifiermatiere")
    public Reponse modifiermatiere(@RequestBody Matiere matiere){
        return matiereService.modifiermatiere(matiere);
    }


}
