package tn.esprit.pibakcend.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pibakcend.Repositories.ProduitRipository;
import tn.esprit.pibakcend.Service.IProduit;
//import tn.esprit.pibakcend.Service.ProduitServiceImplementation;
import tn.esprit.pibakcend.Utils.QRCodeGenerator;
//import tn.esprit.pibakcend.entities.CategorieProduit;
import tn.esprit.pibakcend.entities.Produit;
//import java.io.IOException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import java.util.List;
//import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProduitRestController {
    IProduit iProduit;
    ProduitRipository produitRipository;
    @CrossOrigin(origins = "*")
    @PostMapping("/addProducts")
    public Produit addProduit(@RequestBody Produit produit) {
        return iProduit.addProduit(produit);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/updateProducts") //@PutMapping
    public Produit updateProduit(@RequestBody Produit produit) {
        return iProduit.updateProduit(produit);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/getProductById/{id}")
    public Produit retrieveProduitById(@PathVariable("id") Long id) {
        return iProduit.retrieveProduitById(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/getAllProducts")
    public List<Produit> retrieveAllProduit() {
        return iProduit.retrieveAllProduit();
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delProduct/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        iProduit.deleteProduit(id);
    }

    @PostMapping("/assignProduitToCategory/{numCategorieProduit}")
    Produit assignProduitToCategory(@RequestBody Produit produit, @PathVariable Long numCategorieProduit) {
        return iProduit.AssignProduitToCategorie(produit, numCategorieProduit);
    }

    @GetMapping("/products/{productId}/qrcode")
    public ResponseEntity<byte[]> getProductQRCode(@PathVariable long productId,
                                                   @RequestParam int width,
                                                   @RequestParam int height) {
        Optional<Produit> optionalProduit = produitRipository.findById(productId);
        Produit product = optionalProduit.orElseThrow(() -> new RuntimeException("Produit not found"));

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            byte[] qrCode = QRCodeGenerator.generateQRCodeForProduct(product, width, height);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   /* @GetMapping("/getSortedProduct")
    public Map<CategorieProduit, List<Produit>> listProduitsParCategorieSortedByPrice(CategorieProduit categorieProduit){
         return (Map<CategorieProduit, List<Produit>>) iProduit.getProduitsByCategorie(categorieProduit);
    }*/
   @CrossOrigin(origins = "*")
   @PutMapping("/UpdateProdById/{id}")
    public Produit updateProduit(@PathVariable(value = "id") Long prodId, @RequestBody Produit produit) throws ResourceNotFoundException {
        Produit produit1 = produitRipository.findById(prodId)
                .orElseThrow(null);

        produit1.setNomProduit(produit.getNomProduit());
        produit1.setPrixProduit(produit.getPrixProduit());
        produit1.setDescriptionProduit(produit.getDescriptionProduit());
        produit1.setCategorieProduit(produit.getCategorieProduit());

        return produitRipository.save(produit1);
    }

}



