/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.beans.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "Sesiones", urlPatterns = {"/Sesiones"})
public class Sesiones extends HttpServlet {

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
         
            if(request.getParameter("enviar") == null && request.getParameter("cerrar") == null)
            {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contador de visitas con Cookie</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"Sesiones\" method=\"post\">");
            out.println("Usuario 1");
            out.println("<br>");
            out.println("<label for='id'> ID: </label>");
            out.println("<input type=\"text\" name=\"id\" value=\"\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='nombre'> Nombre: </label>");
            out.println("<input type=\"text\" name=\"nombre\" value=\"\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='sueldo'> Sueldo: </label>");
            out.println("<input type=\"text\" name=\"sueldo\" value=\"\">");
            out.println("<br/>");
            out.println("<br/>");
            out.println("Usuario 2");
            out.println("<br>");
            out.println("<label for='id2'> ID: </label>");
            out.println("<input type=\"text\" name=\"id2\" value=\"\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='nombre2'> Nombre: </label>");
            out.println("<input type=\"text\" name=\"nombre2\" value=\"\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='sueldo2'> Sueldo: </label>");
            out.println("<input type=\"text\" name=\"sueldo2\" value=\"\">");
            out.println("<br/>");
            out.println("<br/>");
            out.println("Usuario 3");
            out.println("<br>");
            out.println("<label for='id3'> ID: </label>");
            out.println("<input type=\"text\" name=\"id3\" value=\"\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='nombre3'> Nombre: </label>");
            out.println("<input type=\"text\" name=\"nombre3\" value=\"\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='sueldo3'> Sueldo: </label>");
            out.println("<input type=\"text\" name=\"sueldo3\" value=\"\">");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<input type=\"submit\" name='enviar' value='Enviar' >");
            out.println("</form>");
            out.println("</body>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<volver>");
            out.println("<a href=\"index.html\">Volver a Menu</a>");
            out.println("</volver>");
            out.println("</html>");
            } else if (request.getParameter("cerrar") == null)
            {
                
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<h2>Los datos se han recogido</h2>");
                out.println("<form action=\"Sesiones\" method=\"post\">");
                HttpSession sesion = request.getSession(true);
                ArrayList<Usuario> usuarios = new ArrayList();
                Usuario usuario = new Usuario ();
                Usuario usuario2 = new Usuario ();
                Usuario usuario3 = new Usuario ();
                usuario.setId(Integer.parseInt(request.getParameter("id")));
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setSueldo(Integer.parseInt(request.getParameter("sueldo")));
                usuario2.setId(Integer.parseInt(request.getParameter("id2")));
                usuario2.setNombre(request.getParameter("nombre2"));
                usuario2.setSueldo(Integer.parseInt(request.getParameter("sueldo2")));
                usuario3.setId(Integer.parseInt(request.getParameter("id3")));
                usuario3.setNombre(request.getParameter("nombre3"));
                usuario3.setSueldo(Integer.parseInt(request.getParameter("sueldo3")));
                sesion.setAttribute("people", usuarios);
                out.println("<br>");
                out.println("<br>");
                out.println("<input type=\"submit\" name='cerrar' value='Cerrar' >");
                out.println("</form>");
                out.println("</html>");
            }
            else
            {
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<body>");
                
                
                HttpSession sesion = request.getSession(true);
                ArrayList<Usuario> usuarios = (ArrayList)sesion.getAttribute("people");
                out.println("<h2>Los datos obtenidos son</h2>");
                Iterator<Usuario> it = usuarios.iterator();
                int i = 0;
                while(it.hasNext())
                {
                    Usuario usuario = it.next();
                    out.println("<p>Usuario "+ ++i +"º");
                    out.println("<ul>");
                    out.println("<li>ID: " + usuario.getId() +"</li>");
                    out.println("<li>Nombre: " + usuario.getNombre() +"</li>");
                    out.println("<li>Sueldo: " + usuario.getSueldo() +"</li>");
                    out.println("</ul>");
                }
                out.println("<a href=\"localhost:8084/20160927_VictorRuiz/Sesiones\">Volver a Menu</a>");
                out.println("</body>");
                
                out.println("</html>");
            }
     }
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
/* libro1.setNombre(nombre);
            int posicion = -1;
            if(libreria != null)
            {
                for (Libros libreto : libreria) {
                    if (libreto.equals(libro1)) {
                        posicion = libreria.indexOf(libreto);
                    }
                }
            if(posicion == -1){
            libro1.setCantidad(cantidad);
            libreria.add(libro1); 
*/