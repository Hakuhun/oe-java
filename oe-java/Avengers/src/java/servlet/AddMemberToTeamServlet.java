package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SuperHero;
import model.SuperTeam;
import service.TeamArranger;

public class AddMemberToTeamServlet extends HttpServlet {

    TeamArranger ta = TeamArranger.getInstance();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
        //Karakter kódolás beállítása
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //Objektum init
        SuperHero hero = null;
        SuperTeam team = null;
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        
        //Paraméterek lekérdezése
//        String heroName = request.getParameter("heroName");
//        String teamName = request.getParameter("teamName");
        
        int heroId = Integer.parseInt(request.getParameter("heroId"));
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        
        try {
//            //Name
//            hero = ta.getHeroByName(heroName);
//            team = ta.getTeamByName(teamName);
//            
            //ID
            hero = ta.getHeroById(heroId);
            team = ta.getTeamById(teamId);
        } catch (NullPointerException ex) {
            //Üzenet írása, a response -> meghívott erőforrás -> index.jsp
            PrintWriter out = response.getWriter();
            out.print("<p style='color: red;'>Ilyen nevű szuperhős, vagy szuperhős csapat nem található a szolgáltatásban.</p>");
            rd.include(request, response);
        }
        ta.addMemberToTeam(team, hero);
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
