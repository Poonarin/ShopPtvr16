package secure;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.CustomerFacade;
import session.CustomerRolesFacade;
import session.RoleFacade;
import util.EncriptPass;
import util.PageReturner;

/**
 *
 * @author Sanata
 */
//loadOnStartup = 1, - назначение админа сразу при старте приложения
@WebServlet(loadOnStartup = 1, name = "SecureAdmin", urlPatterns = {"/login",
    "/logout",
    "/showLogin",
    "/showCustomerRoles",
    "/changeCustomerRole"})
public class SecureAdmin extends HttpServlet {

    @EJB
    RoleFacade roleFacade;
    @EJB
    CustomerFacade customerFacade;
    @EJB
    CustomerRolesFacade customerRolesFacade;

    @Override // когда БД пользователей еще пуста, создание первого пользователя, назначение ему роли админа, запись в БД
    public void init() throws ServletException {
        List<Customer> listCustomers = customerFacade.findAll();
        if (listCustomers.isEmpty()) {
            EncriptPass ep = new EncriptPass();
            String salts = ep.createSalts();
            String encriptPass = ep.setEncriptPass("123456", salts);

            Customer customer = new Customer("Sam", "Sambba", "55555555", "Tallinn", "sambba", encriptPass, salts, 1000);// dannoe
            customerFacade.create(customer);
            Role role = new Role();//sozdat pustuja rol
            role.setName("ADMIN"); //iniciacija adminom
            roleFacade.create(role);//sozdanie v DB
            CustomerRoles cr = new CustomerRoles();//
            cr.setCustomer(customer);
            cr.setRole(role);
            customerRolesFacade.create(cr);
            role.setName("USER");
            roleFacade.create(role);//novaja zapis v DB s novot rolju
            cr.setCustomer(customer);
            cr.setRole(role);
            customerRolesFacade.create(cr);//sozdanie novoi zapisi s nov.dannimi
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");
        HttpSession session = request.getSession(false);//esli sessii net< jna ne sozdaetsja
        Customer regUser = null;
        if (session != null) {
            try {
                regUser = (Customer) session.getAttribute("regUser");
            } catch (Exception e) {
                regUser = null;
            }
        }
        SecureLogic sl = new SecureLogic();
        String path = request.getServletPath();
        if (null != path) {
            switch (path) {
                case "/login":
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    request.setAttribute("info", "Нет такого пользователя!");
                    regUser = customerFacade.fineByLogin(login);
                    if (regUser == null) {
//                        request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                        request.getRequestDispatcher("/WEB-INF/showLogin.jsp").forward(request, response);
                        break;
                    }
                    EncriptPass ep = new EncriptPass();
                    String salts = regUser.getSalts();
                    String encriptPass = ep.setEncriptPass(password, salts);
                    if (encriptPass.equals(regUser.getPassword())) {
                        session = request.getSession(true);
                        session.setAttribute("regUser", regUser);
                        request.setAttribute("info", regUser.getName() + "! Вы увспешно вошли в систему!");
                        request.getRequestDispatcher(PageReturner.getPage("welcom")).forward(request, response);
//                        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
                        break;
                    }
                    request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
//                    request.getRequestDispatcher("/WEB-INF/showLogin.jsp").forward(request, response);
                    break;
                case "/showLogin":
                    request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                    break;
                case "/logout":
                    if (session != null) {
                        session.invalidate();
                        request.setAttribute("info", "Вы вышли из системы");
                    }
                    request.getRequestDispatcher(PageReturner.getPage("welcom"))
                            .forward(request, response);
                    break;
                case "/showCustomerRoles":
                    if (!sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                        request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                                .forward(request, response);
                        break;
                    }
                    Map<Customer, String> mapCustomers = new HashMap<>();
                    List<Customer> listCustomers = customerFacade.findAll();
                    int n = listCustomers.size();
                    for (int i = 0; i < n; i++) {
                        mapCustomers.put(listCustomers.get(i), sl.getRole(listCustomers.get(i)));
                    }

                    List<Role> listRoles = roleFacade.findAll();
                    request.setAttribute("mapCustomers", mapCustomers);
                    request.setAttribute("listRoles", listRoles);
                    request.getRequestDispatcher(PageReturner.getPage("showCustomerRoles"))
                            .forward(request, response);
                    break;
                case "/changeCustomerRole":
                    if (!sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                        request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                                .forward(request, response);
                        break;
                    }
                    String setButton = request.getParameter("setButton");
                    String deleteButton = request.getParameter("deleteButton");
                    String customerId = request.getParameter("Customer");
                    String roleId = request.getParameter("role");
                    Customer customer = customerFacade.find(new Long(customerId));
                    Role roleToCustomer = roleFacade.find(new Long(roleId));
                    CustomerRoles cr = new CustomerRoles(customer, roleToCustomer);

                    if (setButton != null) {
                        sl.addRoleToCustomer(cr);
                    }
                    if (deleteButton != null) {
                        sl.deleteRoleToCustomer(cr.getCustomer());
                    }
                    mapCustomers = new HashMap<>();
                    listCustomers = customerFacade.findAll();
                    n = listCustomers.size();
                    for (int i = 0; i < n; i++) {
                        mapCustomers.put(listCustomers.get(i), sl.getRole(listCustomers.get(i)));
                    }
                    request.setAttribute("mapUsers", mapCustomers);
                    List<Role> newListRoles = roleFacade.findAll();
                    request.setAttribute("listRoles", newListRoles);
                    request.getRequestDispatcher(PageReturner.getPage("showCustomerRoles")).forward(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
