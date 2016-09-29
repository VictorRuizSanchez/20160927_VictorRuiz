/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zack
 */
@WebServlet(name = "CicloVida", urlPatterns = {"/ciclo"})
public class CicloVida extends HttpServlet {

    
    @Override
    public void init(ServletConfig config){
        
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Par&aacute;metros</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Par&aacute;metros iniciales</h1>");
            java.util.Enumeration<String> parametros = request.getParameterNames();
            while(parametros.hasMoreElements()){
                String elemento = parametros.nextElement();
                String valor = request.getParameter(elemento);
                out.print("<p>"+elemento + "-" + valor+"</p>");
            }
            out.println("<br/>");
            out.println("<br/>");
            out.println("<a href=\"index.html\">Volver a Index</a>");
            out.println("</body>");
            out.println("</html>");
        }
    
    
    
    @Override
    public void destroy(){
        System.out.println("destroy()");
    }
}


    