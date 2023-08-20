package tn.esprit.pibakcend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table
@Entity
public class CategorieProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorieProduit;
    @Column
    private String nomCategorieProduit;

    @OneToMany//(mappedBy = "CategorieProduit")
    @JsonIgnore
    List<Produit> produits;
}
