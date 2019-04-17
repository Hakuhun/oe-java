package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SuperHero;
import service.TeamArranger;

/**
 *
 * @author BakonyiGergőIstván
 */
public class AddHeroServlet extends HttpServlet {

    TeamArranger ta = TeamArranger.getInstance();
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
        
        /*
            Karakterkódolás.
        */
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        /*
            Paraméterek lekérése a servletből
        */

        String name = request.getParameter("name");
        String power = request.getParameter("power");
        
        /*
            Hős objektum létrehozása.
        */
        SuperHero sh = new SuperHero(name, power);
        
        /*
            Hős hozzáadása
        */
        
        ta.addHero(sh);
        
        /*
            Átirányítás
        */
        response.sendRedirect("index.jsp"); //-> session nélkül 
        
        /*
        //Titkosításra, session eléréshez
        response.sendRedirect(response.encodeRedirectURL("index.jsp"));
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        
        //Két szervlet közötti kommunikáció
        rd.forward(request, response);
        //Szervlet és kliens közötti "kommunikáció"
        rd.include(request, response);
        */
        
        
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
