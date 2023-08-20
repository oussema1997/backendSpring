package tn.esprit.pibakcend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Produit implements Serializable/*,Comparable<Produit>*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long IdProduit;
    @Column
    private String NomProduit;
    @Column
    private float PrixProduit;
    @Column
    private String DescriptionProduit;
    /*@Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image", nullable = true, columnDefinition = "mediumblob")
    private byte[] image;*/
    @ManyToOne
    @JsonIgnore
    CategorieProduit categorieProduit;

   /* @Override
    public int compareTo(Produit autreProduit) {
        return Double.compare(this.getPrixProduit(), autreProduit.getPrixProduit());
    }*/
}
