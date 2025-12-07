package ma.ensak.web;

import ma.ensak.entities.Produit;
import ma.ensak.metier.ICatalogueRemote;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

@Named("produitBean")
@RequestScoped
public class ProduitBean {

    @EJB
    private ICatalogueRemote metier;

    private String nom;
    private double prix;
    private int quantite;

    private List<Produit> produits;

    public ProduitBean() {
    }

    @PostConstruct
    public void init() {
        produits = metier.getAllProduits();
    }

    public String ajouter() {
        Produit p = new Produit(nom, prix, quantite);
        metier.addProduit(p);
        produits = metier.getAllProduits();
        return null;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public List<Produit> getProduits() { return produits; }
}
