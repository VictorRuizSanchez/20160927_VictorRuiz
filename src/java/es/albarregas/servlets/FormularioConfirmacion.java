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

/**
 *
 * @author Zack
 */
@WebServlet(name = "FormularioConfirmacion", urlPatterns = {"/FormularioConfirmacion"})
public class FormularioConfirmacion extends HttpServlet {

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
            out.println("<title>Servlet FormularioConfirmacion</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../CSS/estiloform.css\" />");
            out.println("</head>");
            boolean NombreError;
            boolean UsuarioError;
            boolean PassError;
            if("".equals(request.getParameter("nombre")) || request.getParameter("nombre")==null)
            {
                NombreError=true;
            }
            else
            {
                NombreError=false;
            }
            if("".equals(request.getParameter("usuario")) || request.getParameter("usuario")==null)
            {
                UsuarioError=true;
            }
            else
            {
                UsuarioError=false;
            }
            if("".equals(request.getParameter("pass")) || request.getParameter("pass")==null)
            {
                PassError=true;
            }
            else
            {
                PassError=false;
            }
            if( NombreError || UsuarioError || PassError)
            {
            out.println("<body>");
            out.println("<form>");
            out.println("<fieldset>");
            if(NombreError)
            {
                out.println("<p>Hay errores en el nombre");
            }
            if(UsuarioError)
            {
                out.println("<p>Hay errores en el Usuario");
            }
            if(PassError)
            {
                out.println("<p>Hay errores en el Password");
            }
            
            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<legend>Datos personales</legend>");
            out.println("<label for=\"nombre\">* Nombre: </label>");
            out.println("<input type=\"text\" name=\"Nombre\" id=\"nombre\" value=\"" + request.getParameter("nombre") + "\">");
            out.println("<br/> <br/>");
            out.println("<label for=\"apellidos\">Apellidos: </label>");
            out.println("<input type=\"text\" name=\"apellidos\" id=\"apellidos\" value=\"" + request.getParameter("apellidos") + "\">");
            out.println("<br/> <br/>");
            out.println("Sexo:");
            if ("hombre".equals(request.getParameter("genero"))) {
            out.println("<input type=\"radio\" name=\"genero\" value=\"hombre\" checked>Hombre");
            out.println("<input type=\"radio\" name=\"genero\" value=\"mujer\">Mujer");
            }
            else
            {
            out.println("<input type=\"radio\" name=\"genero\" value=\"hombre\">Hombre");
            out.println("<input type=\"radio\" name=\"genero\" value=\"mujer\" checked>Mujer");
            }
            out.println("<br/> <br/>");
            out.println("<label for=\"edad\">Edad:</label>");
            out.println("<input type=\"text\" name=\"Edad\" id=\"edad\"  placeholder=\"22\" value=\"" + request.getParameter("Edad") + "\">");
            out.println("</fieldset>");
            out.println("<br/>");
            out.println("<fieldset>");
            out.println("<legend>Datos de acceso</legend>");
            out.println("<label for=\"usuario\">* Usuario: </label>");
            out.println("<input type=\"text\" name=\"Usuario\" id=\"usuario\" value=\"" + request.getParameter("usuario") + "\">");
            out.println("<br/> <br/>");
            out.println("<label for=\"pass\" >* Password:</label>");
            out.println("<input type=\"password\" id=\"pass\" name=\"pass\" value=\"" + request.getParameter("pass") + "\" >");   
            out.println("</fieldset>");
            out.println("<br/>");
            out.println("<fieldset>");
            out.println("<legend>Informacion General</legend>");
            out.println("<input type=\"checkbox\" name=\"deporte\" value=\"Deporte\"> Deporte<br>");
            out.println("<input type=\"checkbox\" name=\"lectura\" value=\"Lectura\"> Lectura <br>");
            out.println("<input type=\"checkbox\" name=\"cine\" value=\"Cine\"> Cine <br>");    
            out.println("<input type=\"checkbox\" name=\"viajes\" value=\"Viajes\"> Viajes <br>");     
            out.println("</fieldset>");
            out.println("<input type=\"submit\" value=\"Enviar\" id=\"enviar\" class=\"boton\"/>");
            out.println("<a href='formularioConfirm.html'><button>Limpiar</button></a>");
            out.println("</form>");
            out.println("</body>");
            }
            else
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulario Con Errores</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloFormCom.css\" />");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Formulario Con Errores</h1>");
            java.util.Enumeration<String> pruebaParametros = request.getParameterNames();
            while (pruebaParametros.hasMoreElements()){
                String nombre = (String) pruebaParametros.nextElement();
                if(!nombre.startsWith("env")){
                    if(!nombre.startsWith("check")){
                        String valor = (String) request.getParameter(nombre);
                        out.println("<p>"+nombre+": "+valor+"</p>");
                    }
                    else
                    {
                        out.println("<p>Preferencias</p>");
                        out.println("<ul>");
                        String[] valor = request.getParameterValues("check");
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
            out.println("</html>");
            
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
