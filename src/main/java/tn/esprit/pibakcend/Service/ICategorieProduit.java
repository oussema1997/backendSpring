package tn.esprit.pibakcend.Service;

import tn.esprit.pibakcend.entities.CategorieProduit;

import java.util.List;

public interface ICategorieProduit {
    CategorieProduit addCategorieProduit(CategorieProduit categorieProduit);
    CategorieProduit updateCategorieProduit(CategorieProduit categorieProduit);
    CategorieProduit retrieveCategorieProduitById(Long id);
    List<CategorieProduit> retrieveAllCategorieProduit();
    void deleteCategorieProduit (Long id);
}
