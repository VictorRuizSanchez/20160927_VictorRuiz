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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zack
 */
@WebServlet(name = "ContadorVisitas", urlPatterns = {"/ContadorVisitas"})
public class ContadorVisitas extends HttpServlet {

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
            out.println("<title>Servlet ContadorVisitas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorVisitas at " + request.getContextPath() + "</h1>");
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
         
         Cookie cookie = null; 
         
         Cookie[] cookies = request.getCookies(); // Creamos un array de cookies donde iremos almacenando el numero de cookies
         if(cookies != null) {
             for(int i = 0; i <cookies.length; i++) {
                 if (cookies[i].getName().equals("CONTADOR")) {
                     cookie = cookies[i];
                     break;
                 }
             }
         }
         if(cookie == null) 
         {
             cookie = new Cookie("CONTADOR", "0");
         } else if (request.getParameter("limpiar") != null) {
             cookie.setValue("0");
         }
         int contador = Integer.parseInt(cookie.getValue());
         cookie.setValue(Integer.toString(contador + 1));
         cookie.setMaxAge(3600);
         
         response.addCookie(cookie);
         PrintWriter out = response.getWriter();
            if(request.getParameter("recargar") != null )
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contador de visitas con Cookie</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ContadorVisitas\" method=\"post\">");
            out.println("<h1>El numero de visitas a esta pagina es de "+cookie.getValue()+"</h1>");
            out.println("<input type=\"submit\" name=\"recargar\" value='Recargar'>");
            out.println("<input type=\"submit\" name=\"limpiar\" value='Limpiar'><br>");
            out.println("</form>");
            out.println("</body>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<volver>");
            out.println("<a href=\"index.html\">Volver a Menu</a>");
            out.println("</volver>");
            out.println("</html>");
            }else{     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contador de visitas con Cookie</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ContadorVisitas\" method=\"post\">");
            out.println("<h1>El numero de visitas a esta pagina es de "+cookie.getValue()+"</h1>");
            out.println("<h3>Nombre: " +cookie.getName()+ "<br></h3>");
            out.println("<h3>Dominio: " +cookie.getDomain()+ "<br></h3>");
            out.println("<h3>Path: " +cookie.getPath()+ "<br></h3>");
            out.println("<h3>Seguridad: " +cookie.getSecure()+ "<br></h3>");
            out.println("<h3>Version: " +cookie.getVersion()+ "<br></h3>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type=\"submit\" name=\"recargar\" value='Recargar'>");
            out.println("<input type=\"submit\" name=\"borrar\" value='Borrar'>");
            out.println("</form>");
            out.println("</body>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<volver>");
            out.println("<a href=\"index.html\">Volver a Menu</a>");
            out.println("</volver>");
            out.println("</html>");
            }
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
