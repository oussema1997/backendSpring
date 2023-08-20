package tn.esprit.pibakcend.RestController;

import lombok.AllArgsConstructor;
//import lombok.Data;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pibakcend.Service.ICategorieProduit;
//import tn.esprit.pibakcend.Service.IProduit;
import tn.esprit.pibakcend.entities.CategorieProduit;


import java.util.List;

@AllArgsConstructor


public class CategorieProduitRestController {
    ICategorieProduit iCategorieProduit;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCategorieProduit")
    public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit categorieProduit){
        return iCategorieProduit.addCategorieProduit(categorieProduit);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateCategorieProduit") //@PutMapping
    public CategorieProduit updateCategorieProduit(@RequestBody CategorieProduit categorieProduit){
        return iCategorieProduit.updateCategorieProduit(categorieProduit);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getCategorieProduitById/{id}")
    public CategorieProduit retrieveProduitById(@PathVariable("id") Long id){
        return iCategorieProduit.retrieveCategorieProduitById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllCategorieProduit")
    public List<CategorieProduit> retrieveAllPCategorieProduit(){
        return iCategorieProduit.retrieveAllCategorieProduit();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delCategorieProduit/{id}")
    public void deleteCategorieProduit(@PathVariable("id") Long id){
        iCategorieProduit.deleteCategorieProduit(id);
    }



}

