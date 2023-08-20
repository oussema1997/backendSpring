package tn.esprit.pibakcend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pibakcend.entities.Produit;

@Repository
public interface ProduitRipository  extends JpaRepository<Produit, Long> {


}
