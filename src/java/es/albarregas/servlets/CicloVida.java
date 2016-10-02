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
        System.out.println("init()");
        
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("service()");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ciclo de vida</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\" />");
            out.println("</head>");
            out.println("<body>");
            
            /*
            out.println("<h1>Par&aacute;metros iniciales</h1>");
            java.util.Enumeration<String> parametros = request.getParameterNames();
            while(parametros.hasMoreElements()){
                String elemento = parametros.nextElement();
                String valor = request.getParameter(elemento);
                out.print("<p>"+elemento + "-" + valor+"</p>");
            }
            out.println("<h1>Cabeceras iniciales</h1>");
            java.util.Enumeration<String> cabecera = request.getHeaderNames();
            while(cabecera.hasMoreElements()){
                String elemento = cabecera.nextElement();
                String valor = request.getHeader(elemento);
                out.print("<p>"+cabecera + "-" + valor+"</p>");
            }
            out.println("<br/>");
            out.println("<br/>");
            */
            out.println("<br/>");
            out.println("<br/>");
            out.println("<volver>");
            out.println("<a href=\"index.html\">Volver a Menu</a>");
            out.println("</volver>");
            out.println("</body>");
            out.println("</html>");
        }
    
    @Override
    public void destroy(){
        System.out.println("destroy()");
    }
}


    