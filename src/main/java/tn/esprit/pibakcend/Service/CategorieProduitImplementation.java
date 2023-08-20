package tn.esprit.pibakcend.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tn.esprit.pibakcend.Repositories.CategorieProduitRepository;
import tn.esprit.pibakcend.entities.CategorieProduit;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieProduitImplementation implements ICategorieProduit {

    CategorieProduitRepository categorieProduitRepository;

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit categorieProduit) {
        return categorieProduitRepository.save(categorieProduit);
    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit categorieProduit) {
        return categorieProduitRepository.save(categorieProduit);
    }

    @Override
    public CategorieProduit retrieveCategorieProduitById(Long id) {
        return categorieProduitRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategorieProduit> retrieveAllCategorieProduit() {
        return categorieProduitRepository.findAll();
    }

    @Override
    public void deleteCategorieProduit(Long id) {
        categorieProduitRepository.deleteById(id);
    }






}
