/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zack
 */
@WebServlet(name = "FormularioCompleto", urlPatterns = {"/FormularioCompleto"})
public class FormularioCompleto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulario Completo</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloFormCom.css\" />");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Formulario Completo</h1>");
            out.println("<p>No has accedido al formulario</p>");
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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulario Completo</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloFormCom.css\" />");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Formulario Completo</h1>");
            java.util.Enumeration<String> pruebaParametros = request.getParameterNames();
            while (pruebaParametros.hasMoreElements()){
                String nombre = (String) pruebaParametros.nextElement();
                if(!nombre.startsWith("env")){
                    if(!nombre.startsWith("Afi")){
                        String valor = (String) request.getParameter(nombre);
                        out.println("<p>"+nombre+": "+valor+"</p>");
                    }
                    else
                    {
                        out.println(nombre + ":");
                        out.println("<ul>");
                        String[] valor = request.getParameterValues(nombre);
                        for (int i=0; i<valor.length; i++){
                            out.println("<li>"+valor[i]+"</li>");
                        }
                        out.println("</ul>");
                    }
                }
                
            }
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
