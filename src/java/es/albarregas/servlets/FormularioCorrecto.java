/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zack
 */
@WebServlet(name = "FormularioCorrecto", urlPatterns = {"/FormularioCorrecto"})
public class FormularioCorrecto extends HttpServlet {

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
            String usuario,password;
            
            if ("".equals(request.getParameter("usuario")) || request.getParameter("usuario")==null) {
                usuario = "";
            } else {
                usuario = request.getParameter("usuario");
            }
            if ("".equals(request.getParameter("password")) || request.getParameter("password")==null) {
                password = "";
            } else {
                password = request.getParameter("password");
            }
            
            if(request.getParameter("confirmar") != null){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioCorrecto</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloform.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Formulario correcto</h1>");
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
            }else if (request.getParameter("enviar") != null) 
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioCorrecto</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloform.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>FormularioCorrecto</h1>");
            out.println("<p>Confirmar Datos</p>");
            java.util.Enumeration<String> pruebaParametros = request.getParameterNames();
            while (pruebaParametros.hasMoreElements())
            {
                String nombre = (String) pruebaParametros.nextElement();
                if(!nombre.startsWith("env"))
                {
                    if(!nombre.startsWith("check"))
                    {
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
                
                out.println("<form action=\"FormularioCorrecto\" method=\"post\">");
                out.println("<input type=\"hidden\" name=\"usuario\" value=\"" + usuario + "\"><br> ");
                out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\"> <br>");
                
                if ("hombre".equals(request.getParameter("sexo"))) 
                {
                    out.println("<input type=\"hidden\" name=\"sexo\" id=\"sexo\" value=\"hombre\" checked>");
                } 
                else 
                {
                    out.println("<input type=\"hidden\" name=\"sexo\" value=\"mujer\" checked><br>");
                }
                if (request.getParameter("check") == null) 
                {
                    out.print("<input type=\"hidden\" name=\"check\" value=\"Informatica\" checked >");
                }
                if (request.getParameter("check") == null) 
                {
                    out.print("<input type=\"hidden\" name=\"check\" value=\"Viajar\" checked>");
                }
                if (request.getParameter("check") == null) {
                    out.print("<input type=\"hidden\" name=\"check\" value=\"Musica\" checked>");
                }
                if (request.getParameter("check") == null) {
                    out.print("<input type=\"hidden\" name=\"check\" value=\"Cine\" checked>");
                }

                out.println("<input type=\"submit\" name=\"confirmar\" value=\"Confirmar\">");                
                out.println("<input type=\"submit\" name=\"retroceder\" value=\"Retroceder\"><br>");
                out.println("</form");
                out.println("</body>");
                out.println("</html>");
            } else if (request.getParameter("limpiar") != null) {
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet FormularioCorrecto</title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloform.css\" />");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Formulario correcto</h1>");
                out.println("<form action=\"FormularioCorrecto\" method=\"post\">");
                out.println("<fieldset>");
                out.println("<legend>Informacion personal</legend>");
                out.println("<br/>");
                out.println("<label for=\"usuario\">Usuario</label>");
                out.println("<input type=\"text\" name=\"usuario\" \"><br> ");
                out.println("<br/>");
                out.println("<label for=\"password\">Password</label>");
                out.println("<input type=\"password\" name=\"password\" \"> <br>");
                out.println("<br/>");
                out.println("<label for=\"sexo\">Sexo</label>");
                out.println("<input type=\"radio\" name=\"sexo\" \" checked> Hombre ");
                out.println("<input type=\"radio\" name=\"sexo\" \"> Mujer <br>");
                out.println("<br/>");
                out.println("<label for=\"aficiones\">Aficiones</label>");
                out.println("<input type=\"checkbox\" name=\"check\" value='Informatica'\"> Informatica ");
                out.println("<input type=\"checkbox\" name=\"check\" value='Viajar'\"> Viajar ");
                out.println("<input type=\"checkbox\" name=\"check\" value='Musica'\"> Musica ");
                out.println("<input type=\"checkbox\" name=\"check\" value='Cine'\"> Cine ");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"enviar\">");
                out.println("<input type=\"submit\" name=\"limpiar\"><br>");
                out.println("</fieldset>");
                out.println("</form");
                out.println("</body>");
                out.println("</html>");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet FormularioCorrecto</title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estiloform.css\" />");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Formulario correcto</h1>");
                out.println("<form action=\"FormularioCorrecto\" method=\"post\">");
                out.println("<fieldset>");
                out.println("<legend>Informacion personal</legend>");
                out.println("<br/>");
                out.println("<label for=\"usuario\">Usuario</label>");
                out.println("<input type=\"text\" name=\"usuario\" value=\"" + usuario + "\"><br> ");
                out.println("<br/>");
                out.println("<label for=\"password\">Password</label>");
                out.println("<input type=\"password\" name=\"password\" value=\"" + password + "\"> <br>");
                out.println("<br/>");
                out.println("<label for=\"sexo\">Sexo</label>");
                
                if ("hombre".equals(request.getParameter("sexo"))) 
                {
                    out.println("<input type=\"radio\" name=\"sexo\" id=\"sexo\" value=\"hombre\" checked> Hombre");
                    out.println("<input type=\"radio\" name=\"sexo\" value=\"mujer\"> Mujer <br>");
                } 
                else 
                {
                    out.println("<input type=\"radio\" name=\"sexo\" id=\"sexo\" value=\"hombre\" > Hombre");
                    out.println("<input type=\"radio\" name=\"sexo\" value=\"mujer\" checked> Mujer  <br>");
                }
                out.println("<br/>");
                out.println("<label for=\"aficiones\">Aficiones</label>");
                if (request.getParameter("check") == null) 
                {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Informatica\"> Informatica ");
                } else {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Informatica\" checked > Informatica ");
                }
                if (request.getParameter("check") == null) 
                {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Viajar\"> Viajar ");
                } else {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Viajar\" checked> Viajar");
                }
                if (request.getParameter("check") == null) {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Musica\"> Musica");
                } else {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Musica\" checked> Musica");
                }
                if (request.getParameter("check") == null) {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Cine\"> Cine");
                } else {
                    out.print("<input type=\"checkbox\" name=\"check\" value=\"Cine\" checked> Cine");
                }
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Enviar\">");                
                out.println("<input type=\"submit\" name=\"limpiar\" value=\"Limpiar\">");
                out.println("</fieldset>");
                out.println("</form");
                out.println("</body>");
                out.println("</html>");
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
