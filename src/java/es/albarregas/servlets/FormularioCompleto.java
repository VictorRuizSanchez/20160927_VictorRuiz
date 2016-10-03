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
            out.println("<p>"+"Nombre: "+request.getParameter("nombre")+"</p>");
            out.println("<p>"+"Password: "+request.getParameter("pass")+"</p>");
            out.println("<p>"+"Edad: "+request.getParameter("edad")+"</p>");
            String ecivi=request.getParameter("Estado Civil");
            String soltero="1";
            String casado="2";
            String divorciado="3";
            String viudo="4";
            if(ecivi.equals(soltero))
            {
                out.println("<p>Estado Civil: Soltero</p>" );
            }
            if(ecivi.equals(casado))
            {
                out.println("<p>Estado Civil: Casado</p>" );
            }
            if(ecivi.equals(divorciado))
            {
                out.println("<p>Estado Civil: Divorciado</p>" );
            }
            if(ecivi.equals(viudo))
            {
                out.println("<p>Estado Civil: Viudo</p>" );
            }
            
            out.println("<p>Aficciones</p>");
            String deporte="1";
            String musica="2";
            String informatica="3";
            String viajes="4";
            String tiendas="5";
            String juegos="6";
            String[] afic = request.getParameterValues("aficciones");
            for(String af: afic)
            {
                out.println("<ul>");
                if(af.equals(deporte))
                {
                    out.println("<li>Deporte</li>" + "");
                }
                if(af.equals(musica))
                {
                    out.println("<li>Musica</li>" + "");
                }
                if(af.equals(informatica))
                {
                    out.println("<li>Informatica</li>" + "");
                }
                if(af.equals(viajes))
                {
                    out.println("<li>Viajes</li>" + "");
                }
                if(af.equals(tiendas))
                {
                    out.println("<li>Tiendas</li>" + "");
                }
                if(af.equals(juegos))
                {
                    out.println("<li>Juegos</li>" + "");
                }
                out.println("</ul>");
            }
            
            out.println("<p>"+"Comentarios: "+request.getParameter("coment")+"</p>");
            String inet=request.getParameter("inet");
            String si="1";
            String no="2";
            if(inet.equals(si))
            {
                out.println("<p>Acceso a Internet: Si</p>" );
            }
            if(inet.equals(no))
            {
                out.println("<p>Acceso a Internet: No</p>" );
            }
            String so=request.getParameter("sys");
            String windows="1";
            String linux="2";
            String mac="3";
            String solaris="4";
            if(ecivi.equals(windows))
            {
                out.println("<p>Sistema Operativo: Windows</p>" );
            }
            if(ecivi.equals(linux))
            {
                out.println("<p>Sistema Operativo: Linux</p>" );
            }
            if(ecivi.equals(mac))
            {
                out.println("<p>Sistema Operativo: Macintosh</p>" );
            }
            if(ecivi.equals(solaris))
            {
                out.println("<p>Sistema Operativo: Solaris</p>" );
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
