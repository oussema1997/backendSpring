package tn.esprit.pibakcend.Service;

import com.google.zxing.WriterException;
//import tn.esprit.pibakcend.entities.CategorieProduit;
import tn.esprit.pibakcend.entities.CategorieProduit;
import tn.esprit.pibakcend.entities.Produit;

import java.io.IOException;
import java.util.List;
//import java.util.Map;

public interface IProduit {
    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit);
    Produit retrieveProduitById(Long id);
    List<Produit> retrieveAllProduit();
    void deleteProduit (Long id);

    public Produit AssignProduitToCategorie(Produit produit,long idCategorie);
   // public List<Produit> getProduitsByCategorie(CategorieProduit categorieProduit);
   // public Map<CategorieProduit, List<Produit>> listProduitsParCategorieSortedByPrice();


    byte[] generateQRCodeForProduct(long productId, int width, int height) throws IOException, WriterException;
}
