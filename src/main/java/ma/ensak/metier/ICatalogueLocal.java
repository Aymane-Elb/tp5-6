package ma.ensak.metier;

import ma.ensak.entities.Produit;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ICatalogueLocal {
    void addProduit(Produit p);
    List<Produit> getAllProduits();
    Produit getProduit(Long id);
    void deleteProduit(Long id);
    Produit updateProduit(Produit p);
    List<Produit> searchProduits(String mc);
}
