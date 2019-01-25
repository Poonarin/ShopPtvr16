package secure;

import entity.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CustomerRolesFacade;
import session.RoleFacade;

/**
 *
 * @author pupil
 */
public class SecureLogic {
    private CustomerRolesFacade customerRolesFacade;
    private RoleFacade roleFacade;
//    private String roleName;

    public SecureLogic() {
        Context context;
        try {
            context = new InitialContext();
            this.customerRolesFacade = (CustomerRolesFacade) context.lookup("java:module/CustomerRolesFacade");
            this.roleFacade = (RoleFacade) context.lookup("java:module/RoleFacade");
        } catch (NamingException ex) {
            Logger.getLogger(SecureLogic.class.getName()).log(Level.SEVERE, "Не удалось найти Бин", ex);
        }
    }

    public void addRoleToCustomer(CustomerRoles cr) {
        if (cr.getRole().getName().equals("ADMIN")) {
            customerRolesFacade.create(cr);
            Role addNewRole = roleFacade.findRoleByName("USER");
            CustomerRoles addedNewRoles = new CustomerRoles(cr.getCustomer(), addNewRole);
            customerRolesFacade.create(addedNewRoles);
        } else if (cr.getRole().getName().equals("USER")) {
            customerRolesFacade.create(cr);
        }
    }

    public void deleteRoleToCustomer(Customer customer) {
        List<CustomerRoles> listCustomerRoles = customerRolesFacade.findByCustomer(customer);
        int n = listCustomerRoles.size();
        for (int i = 0; i < n; i++) {
            customerRolesFacade.remove(listCustomerRoles.get(i));
        }
    }

    public boolean isRole(Customer customer, String roleName) {
        if (customer == null) {
            return false;
        }
        List<CustomerRoles> listCustomerRoles = customerRolesFacade.findByCustomer(customer);
        Role role = roleFacade.findRoleByName(roleName);
        int n = listCustomerRoles.size();
        for (int i = 0; i < n; i++) {
            if (listCustomerRoles.get(i).getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }

    public String getRole(Customer regUser) {
        List<CustomerRoles> listCustomerRoles = customerRolesFacade.findByCustomer(regUser);
        int n = listCustomerRoles.size();
        for (int i = 0; i < n; i++) {
            if ("ADMIN".equals(listCustomerRoles.get(i).getRole().getName())) {
                return listCustomerRoles.get(i).getRole().getName();
            }
        }
        for (int i = 0; i < n; i++) {
            if ("USER".equals(listCustomerRoles.get(i).getRole().getName())) {
                return listCustomerRoles.get(i).getRole().getName();
            }
        }
        return null;
    }
}
