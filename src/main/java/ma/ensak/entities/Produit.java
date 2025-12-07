package ma.ensak.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUITS", catalog = "db_catalogue")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String nomProduit;
    private double prix;
    private int quantite;

    public Produit() {
    }

    public Produit(String nomProduit, double prix, int quantite) {
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
