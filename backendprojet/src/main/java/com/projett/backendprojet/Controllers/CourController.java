package com.projett.backendprojet.Controllers;

import com.projett.backendprojet.Response.Reponse;
import com.projett.backendprojet.Services.CourService;
import com.projett.backendprojet.Services.MatiereService;
import com.projett.backendprojet.models.Cour;
import com.projett.backendprojet.models.Matiere;
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
)
@RestController
public class CourController {
    @Autowired
    private CourService courService;
    @PostMapping("/ajoutercour")
    public Reponse ajoutercour(@RequestBody Cour cour){
        return courService.ajoutercour(cour);
    }
    @GetMapping("/affichecour")
    public List<Cour> getcour(){
        return  courService.affichecour();
    }
    @GetMapping("/affichecouravecnom/{nom}")
    public Cour affichecouravecnum(@PathVariable String nom){
        return courService.affichecouravecnom(nom);
    }
    @DeleteMapping("/suppricour/{nom}")
    public Reponse supprimecour(@PathVariable String nom){
        return courService.suppricour(nom);
    }
    @PutMapping ("/modifiercour")
    public Reponse modifiercour(@RequestBody Cour cour){
        return courService.modifiercour(cour);
    }

}
