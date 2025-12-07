package ma.ensak.metier;

import ma.ensak.entities.Produit;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface ICatalogueRemote {
    void addProduit(Produit p);
    List<Produit> getAllProduits();
    Produit getProduit(Long id);
    void deleteProduit(Long id);
    Produit updateProduit(Produit p);
    List<Produit> searchProduits(String mc);
}
