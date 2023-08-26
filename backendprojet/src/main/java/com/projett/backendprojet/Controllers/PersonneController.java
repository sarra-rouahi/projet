package com.projett.backendprojet.Controllers;

import com.projett.backendprojet.Response.Reponse;
import com.projett.backendprojet.Services.PersonneService;
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
public class PersonneController {
    @Autowired
    private PersonneService personneService;
    @PostMapping("/ajouterPersonne")
    public Reponse ajouterpersonne(@RequestBody Personne personne){
      return personneService.ajouterpersonne(personne);
    }
    @GetMapping("/affichePersonne")
    public List<Personne> getpersonne(){
        return  personneService.affichepersonne();
    }
    @GetMapping("/affichePersonneavecid/{id}")
    public Personne affichepersonneavecid(@PathVariable int id){
        return personneService.affichepersonneavecid(id);
    }
    @DeleteMapping("/supprimepersonne/{id}")
    public Reponse supprimepersonne(@PathVariable int id){
        return personneService.supprimepersonne(id);
    }
    @PutMapping("/modifierpersonne")
    public Reponse modifierpersonne(@RequestBody Personne personne){
        return personneService.modifierpersonne(personne);
    }
}

