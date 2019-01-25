package session;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import secure.CustomerRoles;

/**
 *
 * @author pupil
 */
@Stateless
public class CustomerRolesFacade extends AbstractFacade<CustomerRoles> {// UserRolesFacade

    @PersistenceContext(unitName = "KTVR17WebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerRolesFacade() {
        super(CustomerRoles.class);
    }
    public List<CustomerRoles> findByCustomer (Customer customer){//findByUser
    return em.createQuery("SELECT cr FROM CustomerRoles cr WHERE cr.customer = :customer")
               .setParameter("customer", customer)
               .getResultList();
    
    }
}
