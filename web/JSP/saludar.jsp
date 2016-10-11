<%-- 
    Document   : saludar
    Created on : 10-oct-2016, 17:24:16
    Author     : Zack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalTime" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String tratamiento = request.getParameter("genero").equals("hombre") ? "señor" : "señora";
            String zonaHoraria;
            if(LocalTime.now().getHour()>12 && LocalTime.now().getHour()<18)
                zonaHoraria="Buenas tardes";
            else if(LocalTime.now().getHour()>18 && LocalTime.now().getHour()<1)
                zonaHoraria="Buenas noches";
            else
                zonaHoraria="Buenos dias";
        %>
         <h2><%= zonaHoraria %> <%=tratamiento%> <%=request.getParameter("nombre")%> </h2>
         <volver>
         <a href="../index.html">Volver a Menu</a>
         </volver>
    </body>
</html>