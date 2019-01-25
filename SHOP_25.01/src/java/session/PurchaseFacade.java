package session;

import entity.Product;
import entity.Purchase;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Lenovo
 */
@Stateless
public class PurchaseFacade extends AbstractFacade<Purchase> {

    @EJB ProductFacade productFacade;

    @PersistenceContext(unitName = "KTVR17WebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseFacade() {
        super(Purchase.class);
    }
    public List<Purchase> findTakeProduct (){
        return em.createQuery("SELECT p FROM Purchase p WHERE p.dateReturn=NULL").getResultList();
    }
    public List<Purchase> find (Product product){
        return em.createQuery("SELECT p FROM Purchase p WHERE p.product = :product").setParameter("product",product).getResultList();
    
    }
    
    
}
