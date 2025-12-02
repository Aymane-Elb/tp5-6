package ma.ensak.web;

import ma.ensak.entities.Produit;
import ma.ensak.metier.ICatalogueRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ProduitBean {

    @EJB
    private ICatalogueRemote metier;

    private String nom;
    private double prix;
    private int quantite;

    private List<Produit> produits;

    @PostConstruct
    public void init() {
        produits = metier.getAllProduits();
    }

    public String ajouter() {
        Produit p = new Produit(nom, prix, quantite);
        metier.addProduit(p);
        produits = metier.getAllProduits();
        return null; // rester sur la même page
    }

    // getters / setters

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public List<Produit> getProduits() { return produits; }
}
