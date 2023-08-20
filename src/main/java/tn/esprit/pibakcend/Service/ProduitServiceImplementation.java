package tn.esprit.pibakcend.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pibakcend.Repositories.CategorieProduitRepository;
import tn.esprit.pibakcend.Repositories.ProduitRipository;
import tn.esprit.pibakcend.entities.CategorieProduit;
import tn.esprit.pibakcend.entities.Produit;
import java.io.IOException;
import com.google.zxing.WriterException;
import tn.esprit.pibakcend.Utils.QRCodeGenerator;
//import javax.persistence.EntityManager;


//import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

@Service

@AllArgsConstructor
public class ProduitServiceImplementation implements IProduit {
    private EntityManager entityManager;
    ProduitRipository produitRipository;
    CategorieProduitRepository categorieProduitRepository;
CategorieProduitImplementation categorieProduitImplementation;


    @Override
    public Produit addProduit(Produit produit) {
        return produitRipository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRipository.save(produit);
    }

    @Override
    public Produit retrieveProduitById(Long id) {
        return produitRipository.findById(id).orElse(null);
    }

    @Override
    public List<Produit> retrieveAllProduit() {
        return produitRipository.findAll();
    }

    @Override
    public void deleteProduit(Long id) {
        produitRipository.deleteById(id);
    }

    public Produit AssignProduitToCategorie(Produit produit,long idCategorie){
        CategorieProduit categorieProduits =categorieProduitRepository.findById(idCategorie).orElse(null);
        produit.setCategorieProduit(categorieProduits);
        return produitRipository.save(produit);
    }

    @Override
    public byte[] generateQRCodeForProduct(long productId, int width, int height) throws IOException, WriterException {
        Produit product = produitRipository.findById(productId).orElse(null);
        if (product == null) {
            return null;
        }
        return QRCodeGenerator.generateQRCodeForProduct(product, width, height);
    }

  /* public List<Produit> trierProduitsParPrix(CategorieProduit categorie) {
        List<Produit> produits =  categorie.getProduits();
        produits.sort(Comparator.comparing(Produit::getPrixProduit));
        return produits;
    }*/

   /* @Override
    public List<Produit> getProduitsByCategorie(CategorieProduit categorieProduit) {
        String jpql = "SELECT Produit  FROM Produit p WHERE p.categorieProduit = :categorie";
        TypedQuery<Produit> query = entityManager.createQuery(jpql, Produit.class);
        query.setParameter("categorie", categorieProduit);
        return query.getResultList();
    }*/
  /*  @Override
    public Map<CategorieProduit, List<Produit>> listProduitsParCategorieSortedByPrice() {
        List<CategorieProduit> categories = categorieProduitImplementation.retrieveAllCategorieProduit();
        Map<CategorieProduit, List<Produit>> produitsParCategorie = new HashMap<>();
        for (CategorieProduit categorie : categories) {
            List<Produit> produits = getProduitsByCategorie(categorie);
            Collections.sort(produits);
            produitsParCategorie.put(categorie, produits);
        }
        return produitsParCategorie;
    }

*/
}
