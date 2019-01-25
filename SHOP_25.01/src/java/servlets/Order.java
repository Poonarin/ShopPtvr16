package servlets;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import secure.SecureLogic;
import session.CustomerFacade;
import session.ProductFacade;
import session.PurchaseFacade;
import util.EncriptPass;
import util.PageReturner;
/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Order", urlPatterns = {
    "/home",
    "/newProduct",
    "/addProduct",
    "/newCustomer",
    "/addCustomer",
    "/showProducts",
    "/showCustomers",
    "/purchase",
    "/takeProduct",
    "/showTakeProduct",
    "/returnProduct",
    "/deleteProduct"})
public class Order extends HttpServlet {

    @EJB ProductFacade productFacade;
    @EJB CustomerFacade customerFacade;
    @EJB PurchaseFacade purchaseFacade;
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
       HttpSession session = request.getSession(false);
        Customer regUser = null;
        if(session != null){
            try {
                regUser = (Customer) session.getAttribute("regUser");
            } catch (Exception e) {
                regUser = null;
            }
        }
            
        SecureLogic sl = new SecureLogic();
       String path = request.getServletPath(); 
       if(null != path)switch (path) {
            case "/newProduct":
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            }
//                request.getRequestDispatcher("/WEB-INF/pages/newProduct.jsp").forward(request, response);
                request.getRequestDispatcher(PageReturner.getPage("newProduct")).forward(request, response);
                break;
            case "/addProduct":{
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            } 
                String name = request.getParameter("name");
                String price = request.getParameter("price");
                String countStr = request.getParameter("count");
                Product product = new Product( name, new Integer(price) ,new Integer(countStr));
                productFacade.create(product);
                request.setAttribute("product", product);
                request.getRequestDispatcher(PageReturner.getPage("welcom")).forward(request, response);//request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
                    break;
                }
            case "/newCustomer":
                request.getRequestDispatcher(PageReturner.getPage("newCustomer")).forward(request, response);//request.getRequestDispatcher("/WEB-INF/pages/newCustomer.jsp").forward(request, response);
                break;
            case "/addCustomer":{
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String city = request.getParameter("city");
                String login = request.getParameter("login");
                String password1 = request.getParameter("password1");
                String password2 = request.getParameter("password2");
                String money = request.getParameter("money");
            if (!password1.equals(password2)) {
                request.setAttribute("info", "Неправильно введен логин или пароль");
                request.getRequestDispatcher(PageReturner.getPage("welcom")).forward(request, response);
                break;
            } 
                EncriptPass ep = new EncriptPass();
                String salts = ep.createSalts();
                String encriptPass = ep.setEncriptPass(password1, salts);
                Customer customer = new Customer(name, surname, phone, city, login, encriptPass, salts, new Integer(money));
                customerFacade.create(customer);
                request.setAttribute("customer", customer);
                request.getRequestDispatcher(PageReturner.getPage("welcom")).forward(request, response);//request.getRequestDispatcher("/WEB-INF//pages/home.jsp").forward(request, response);
                    break;
                }
            case "/showProducts":{
                List<Product> listProducts = productFacade.findActived(true);
                request.setAttribute("role", sl.getRole(regUser));
                request.setAttribute("listProducts", listProducts);
                request.getRequestDispatcher(PageReturner.getPage("listProducts")).forward(request, response);//request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
                    break;
                }
            case "/showCustomers":
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            } 
                List<Customer> listCustomers = customerFacade.findAll();
                request.setAttribute("listCustomers", listCustomers);
                request.getRequestDispatcher(PageReturner.getPage("listCustomers")).forward(request, response);//request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
                break;
            case "/purchase":
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            } 
                List<Product> listProducts = productFacade.findActived(true);
                if(listProducts != null) request.setAttribute("listProducts", listProducts);
                request.setAttribute("listCustomers", customerFacade.findAll());
                request.getRequestDispatcher(PageReturner.getPage("takeProducts")).forward(request, response);
//                request.setAttribute("listProducts", productFacade.findActived(true));
//                request.setAttribute("listCustomers", customerFacade.findAll());
//                request.getRequestDispatcher("/purchase.jsp").forward(request, response);
                break;
            case "/showTakeProduct":{
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            }
                List<Purchase> takeProducts = purchaseFacade.findTakeProduct();
                request.setAttribute("takeProducts", takeProducts);
                request.getRequestDispatcher(PageReturner.getPage("listTakeProducts")).forward(request, response);//request.getRequestDispatcher("/listTakeProducts.jsp").forward(request, response);
                    break;
                }
            case "/takeProduct":{
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            } 
                String selectedProduct = request.getParameter("selectedProduct");
                String selectedCountProduct = request.getParameter("selectedCountProduct");
                String selectedCustomer = request.getParameter("selectedCustomer");
                String quantity = request.getParameter("quantity");//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                Product product = productFacade.find(new Long(selectedProduct));
//                Product product = productFacade.find(new Long(selectedCountProduct));//!!!!!!!!!!!!!!!!!!!!!!!
                Customer customer = customerFacade.find(new Long(selectedCustomer));
                Calendar c = new GregorianCalendar();
                if(product.getCount()>0){
                    product.setCount(product.getCount()-1);
                    productFacade.edit(product);
                    Purchase purchase = new Purchase(product, customer, c.getTime(), null, new Integer(quantity));////!!!!!!!!!!!!!!!!
                    purchaseFacade.create(purchase);
                }else{
                    request.setAttribute("info", "Товар весь распродан!");
                }       
                List<Purchase> takeProducts = purchaseFacade.findTakeProduct();
                request.setAttribute("takeProducts", takeProducts);
                request.getRequestDispatcher(PageReturner.getPage("listTakeProducts")).forward(request, response);//request.getRequestDispatcher("/listTakeProducts.jsp").forward(request, response);
                    break;
                }
            case "/returnProduct":{
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            } 
                String purchaseId = request.getParameter("purchaseId");
                Purchase purchase = purchaseFacade.find(new Long(purchaseId));
                Calendar c = new GregorianCalendar();
                purchase.setDateReturn(c.getTime());
                purchase.getProduct().setCount(purchase.getProduct().getCount()+1);
                purchaseFacade.edit(purchase);
                List<Purchase> takeProducts = purchaseFacade.findTakeProduct();
                request.setAttribute("takeProducts", takeProducts);
                request.getRequestDispatcher(PageReturner.getPage("listTakeProducts")).forward(request, response);//request.getRequestDispatcher("/listTakeProducts.jsp").forward(request, response);
                    break;
                }
            case "/deleteProduct":{
                if(!sl.isRole(regUser, "ADMIN")){
                request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                        .forward(request, response);
                break;
            } 
                String deleteProductId = request.getParameter("deleteProductId");
                Product product = productFacade.find(new Long(deleteProductId));
                product.setActive(Boolean.FALSE);
                productFacade.edit(product);
//                productFacade.remove(deleteProductId);
                listProducts = productFacade.findActived(true);
                request.setAttribute("listProducts", listProducts);
                request.getRequestDispatcher(PageReturner.getPage("listProducts")).forward(request, response);//request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
                    break;
                }
            default:
                 request.getRequestDispatcher(PageReturner.getPage("welcom")).forward(request, response);//request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
                break;
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
