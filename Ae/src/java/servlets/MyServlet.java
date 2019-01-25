/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;

import entity.Reader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/showListBooks","/showListReaders","/showPageGiveBook", "/giveBook", "/addNewBook", "/addNewReader"})
public class MyServlet extends HttpServlet {

    @EJB private BookFacade bookFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private HistoryFacade historyFacade;
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

       
        String path=request.getServletPath();
        if("/showListBooks".equals(path)){
            List<Book> listBooks = bookFacade.findAll();
            request.setAttribute("listBooks", listBooks);
            request.setAttribute("info","Здарова славяне");
            request.getRequestDispatcher("/WEB-INF/showListBooks.jsp").forward(request, response);
            
        }else if("/showListReaders".equals(path)){
            List<Reader> listReaders = readerFacade.findAll();
            request.setAttribute("listReaders", listReaders);
            request.setAttribute("info","Здарова славяне");
            request.getRequestDispatcher("/WEB-INF/showListReaders.jsp").forward(request, response);
        
        }else if("/showPageGiveBook".equals(path)){
            List<Reader> listReaders = readerFacade.findAll();
            List<Book> listBooks = bookFacade.findAll();
            request.setAttribute("listBooks", listBooks);
            request.setAttribute("listReaders", listReaders);
            request.getRequestDispatcher("/WEB-INF/showPageGiveBook.jsp").forward(request, response);
        
        } else if ("/giveBook".equals(path)) {
            String bookId = request.getParameter("bookId");
            String readerId = request.getParameter("readerId");
            Book book = bookFacade.find(new Long(bookId));
            Reader reader = readerFacade.find(new Long(readerId));
            Calendar c = new GregorianCalendar();
            History history = new History(book, reader, c.getTime());
            historyFacade.create(history);
          
            
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
         else if ("/addNewBook".equals(path)) {
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            Book book = new Book(isbn, name, author);
            bookFacade.create(book);
            request.setAttribute("info", "Добавлено!");
          
            
            request.getRequestDispatcher("/WEB-INF/addNewBook.jsp").forward(request, response);
        }
         else if ("/addNewReader".equals(path)) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String code = request.getParameter("email");
            Reader reader = new Reader(code, name, surname);
            readerFacade.create(reader);
            request.setAttribute("info", "Добавлено!");
          
            
            request.getRequestDispatcher("/WEB-INF/addNewReader.jsp").forward(request, response);
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
