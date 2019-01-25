package session;

import entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Lenovo
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {//UserFacade

    @PersistenceContext(unitName = "KTVR17WebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    public Customer fineByLogin(String login) {
        try{
            return (Customer) em.createQuery("SELECT c FROM Customer c WHERE c.login = :login")
                    .setParameter("login", login)
                    .getSingleResult() ;
        }catch(Exception e){
                 return null;
        }
    }
}
