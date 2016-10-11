<%-- 
    Document   : calculadora
    Created on : 10-oct-2016, 18:39:39
    Author     : Zack
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css" />
        <title>JSP Page</title>
    </head>
    <body>
        
<%!
public int sumar(int param1, int param2){
return param1 + param2;
}
%>

<%!
public int restar(int param1, int param2){
return param1 - param2;
}
%>

<%!
public int multiplicar(int param1, int param2){
return param1 * param2;
}
%>

<%!
public int dividir(int param1, int param2){
return param1 / param2;
}
%>
<%
            final String Meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            final String Dias[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Sabado"};
            if ("Enviar".equals(request.getParameter("enviar"))) {
                //averiguamos la fecha actual
                Calendar fecha = Calendar.getInstance();
                int ds = fecha.get(Calendar.DAY_OF_WEEK);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int mes = fecha.get(Calendar.MONTH);
                int year = fecha.get(Calendar.YEAR);
                String fechastr = Dias[ds - 1] + ", " + dia + " de " + Meses[mes] + " de " + year;
        %>
        <h2><%=fechastr%></h2>
            <%
            Enumeration<String> cabecera = request.getHeaderNames();
            while (cabecera.hasMoreElements()) {
                String elemCab = cabecera.nextElement();
                if (elemCab.equals("user-agent")) {
                    out.write(elemCab + ": ");
                    Enumeration<String> cabeceras = request.getHeaders(elemCab);
                    while (cabeceras.hasMoreElements()) {
                        String valor = cabeceras.nextElement();
                        out.write(valor + "<br/>");
                    }
                }
            }
            out.println("<br>");
            out.println("<br>");

        try {
                int param1 = Integer.parseInt(request.getParameter("param1"));
                int param2 = Integer.parseInt(request.getParameter("param2"));
                int result = 0;
                if("sumar".equals(request.getParameter("operacion")))
                {
                    %>
                    El resultado de la suma es: <%= sumar(param1, param2) %><BR><BR>
                    <%
                }
                if("restar".equals(request.getParameter("operacion")))
                {
                    %>
                    El resultado de la resta es: <%= restar(param1, param2) %><BR><BR>
                    <%
                }
                if("multiplicar".equals(request.getParameter("operacion")))
                {
                    %>
                    El resultado de la multiplicacion es: <%= multiplicar(param1, param2) %><BR><BR>
                    <%
                }
                if("dividir".equals(request.getParameter("operacion")))
                {
                    %>
                    El resultado de la division es: <%= dividir(param1, param2) %><BR><BR>
                    <%
                }
        }catch (NumberFormatException ex) {
        %>
        <h4>Alguno de los números no contenía dígitos válidos...</h4>
        <%
        } catch (ArithmeticException exc) {
        %>
        <h4>Se esta intentando dividir entre 0</h4>
        <%
        }
}
%>


        <form method="post" action="calculadora.jsp">
            <label for="param1">Numero 1:</label>
            <input type="text" name="param1" id="param1">&nbsp;&nbsp;&nbsp;
            <label for="param2">Numero 2:</label>
            <input type="text" name="param2" id="param2"><br>
            <br>
            <br>
            <label for="operando">Operador</label>
            <input type="radio" name="operacion" value="sumar" id="operando" checked> Sumar
            <input type="radio" name="operacion" value="restar"> Restar
            <input type="radio" name="operacion" value="multiplicar"> Multiplicar 
            <input type="radio" name="operacion" value="dividir"> Dividir <br>
            <br>
            <br>
            <input type="submit" name="enviar" value="Enviar">
            <input type="submit" name="limpiar" value="Limpiar">
        </form>
<br>
<br>
         <volver>
         <a href="../index.html">Volver a Menu</a>
         </volver>
    </body>
</html>
