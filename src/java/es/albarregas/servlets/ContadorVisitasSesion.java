/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zack
 */
@WebServlet(name = "ContadorVisitasSesion", urlPatterns = {"/ContadorVisitasSesion"})
public class ContadorVisitasSesion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitasSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorVisitasSesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
            HttpSession sesion = request.getSession(true);
            int contador = 0;
            response.setContentType("text/html");
    boolean isInvalidate = true;
    if(request.getParameter("eliminar") != null && request.getParameter("eliminar").equals("true")) {
    sesion.invalidate();
    isInvalidate = true;
    }else{
    if(sesion.getAttribute("contaSesion") != null){
    contador = ((Integer)sesion.getAttribute("contaSesion"));
    }
    sesion.setAttribute("contaSesion", new Integer(contador + 1));
    }
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contador de visitas con Cookie</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ContadorVisitasSesion\" method=\"post\">");
            
            if(isInvalidate){
            out.println("<h1>El numero de visitas a esta pagina es de " + (contador+1) + "</h1>");
            out.println("<br>");
            out.println("<br>");
            out.println("Invalidar sesion: <input type='checkbox' name='eliminar' value='true'>");
            }
            out.println("<br/>");
            out.println("<br/>");
            out.println("<input type=\"submit\" value='refrescar' >");
            out.println("</form>");
            out.println("</body>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<volver>");
            out.println("<a href=\"index.html\">Volver a Menu</a>");
            out.println("</volver>");
            out.println("</html>");
     }
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
