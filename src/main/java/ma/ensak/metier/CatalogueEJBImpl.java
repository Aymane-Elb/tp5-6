package ma.ensak.metier;

import ma.ensak.entities.Produit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CatalogueEJBImpl implements ICatalogueLocal, ICatalogueRemote {

    @PersistenceContext(unitName = "UP_CATALOGUE")
    private EntityManager em;

    @Override
    public void addProduit(Produit p) {
        em.persist(p);
    }

    @Override
    public List<Produit> getAllProduits() {
        return em.createQuery("SELECT p FROM Produit p", Produit.class)
                .getResultList();
    }

    @Override
    public Produit getProduit(Long id) {
        return em.find(Produit.class, id);
    }

    @Override
    public void deleteProduit(Long id) {
        Produit p = em.find(Produit.class, id);
        if (p != null) {
            em.remove(p);
        }
    }

    @Override
    public Produit updateProduit(Produit p) {
        return em.merge(p);
    }

    @Override
    public List<Produit> searchProduits(String mc) {
        return em.createQuery(
                        "SELECT p FROM Produit p WHERE p.nomProduit LIKE :x",
                        Produit.class)
                .setParameter("x", "%" + mc + "%")
                .getResultList();
    }
}
