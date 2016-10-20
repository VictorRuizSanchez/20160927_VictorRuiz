<%-- 
    Document   : calculadora
    Created on : 10-oct-2016, 18:39:39
    Author     : Zack
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="es.albarregas.beans.Libros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/EstiloFinal.css" />
        <title>Tienda de DAW2</title>
    </head>
    <body>
        <%
        HttpSession sesion = request.getSession(true);
        Libros libro1 = new Libros();
        ArrayList<Libros> libreria = new ArrayList();
        libreria = (ArrayList) sesion.getAttribute("libroteca");
        int cantidad;
        String nombre;
        boolean repetido = false;
        
        // Creamos un arrayList de Libros para ir guardando los libros que iremos seleccionando e iniciamos sus variables.
        if("Enviar".equals(request.getParameter("enviar"))){
        // Si el boton de enviar libros es pulsado añadiremos un libro a nuestro arrayList   
            try {
                if(request.getParameter("libros") == null) {
                    %>
            <h3>No ha seleccionado ningun libro</h3>
            <%-- Si el parametro libros no tiene nada selecionado, saltara un error que nos dira que no hay selecionado ningun libro --%>
                    <%
                 } else {
            // En caso contrario, añadiremos a cada variable el valor que introducimos en el formulario.
            nombre = request.getParameter("libros");
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
            if (cantidad <= 0) {
            
            %>
            <h3>La cantidad debe ser superior a 0</h3>
            <%
            // Si la cantidad introducida es 0 o menor, nos mostrara un mensaje de error diciendonos que la cantidad debe ser superior a 0
            } else {
            libro1.setNombre(nombre);
            // En caso contrario le daremos nombre.
            if(libreria == null)
            // Si nuestro array de libros esta vacio crearemos un nuevo array añadiendo la cantidad y el libro
            {
            libreria = new ArrayList();
            libro1.setCantidad(cantidad);
            libreria.add(libro1);

            }else if(libreria != null){
            // En cambio si nuestro array no esta vacio, se iran sumando las cantidades y dandoles nombre que ya recogimos.
            libro1.setCantidad(cantidad);
            libreria.add(libro1);
            }
            %>
            <h4>Se han añadido <%=cantidad%> del libro <%=nombre%> al carrito</h4>
            <%-- Este es el mensaje que nos ira diciendo que vamos añadiendo en nuestro carrito --%>
            <%
            }
            }
            sesion.setAttribute("libroteca", libreria);
            } catch (NumberFormatException ex){
            %>
            <h3>Debe introducir un numero</h3>
            <%
            }
        }
        
        if (!"Finalizar Compra".equals(request.getParameter("terminar"))) {
        // Si el boton de Finalizar Compra no esta pulsado, entraremos en el formulario y podremos ir añadiendo productos.
        %>
        <div id="cabecera" >
            <h1>Tienda de DAW2</h1>
            <img src="../imagenes/libro.jpg" alt=""/>
        </div>
         <form method="post" action="../JSP/carrito.jsp">
            <fieldset>
            <legend>Compra On-line</legend>
            <label for="libros">Elegir un libro</label>
            <select name="libros" size="6" id="libros">
                <option value="STAR WARS">STAR WARS</option>
                <option value="MEMORIAS DE IDHUN">MEMORIAS DE IDHUN</option>
                <option value="BATMAN">BATMAN</option>
                <option value="DC:LA LIGA DE LAS SOMBRAS">DC: LA LIGA DE LAS SOMBRAS</option>
                <option value="HARRY POTTER">HARRY POTTER</option>
                <option value="EL LIBRO DE LA SELVA">EL LIBRO DE LA SELVA</option>
                <option value="SILMARILLON">SILMARILLON</option>
            </select>
            <br/><br/><br/>
            <label for="cantidad">Cantidad: </label>
            <input type="text" name="cantidad" id="cantidad">
            <div id="botones" >
            <input type="submit" name="enviar" value="Enviar">
            <input type="reset" name="limpiar" value="Limpiar">
            <input type="submit" name="terminar" value="Finalizar Compra">
            </div>
            </fieldset>
        </form>
        <%
            }
            try {
                if ("Finalizar Compra".equals(request.getParameter("terminar"))) {
                    // Si el boton de Finalizar Compra se pulsa, se recogeran todos los valores que hemos ido añadiendo.
                    libreria = (ArrayList) sesion.getAttribute("libroteca");
                    Iterator<Libros> it = libreria.iterator();
                    // Con un iterator iremos recorriendo nuestro ArrayList de Libros y mediante una tabla lo presentaremos por pantalla.
                    %>
                    <table border="1">
                    <th>Libro</th>
                    <th>Cantidad</th>
                    </table>
                    <%
                    while (it.hasNext()) {
                        libro1 = it.next();
                        cantidad = libro1.getCantidad();
                        nombre = libro1.getNombre();
        %>
        
        <table border="1">
                            <tr>
                                
                                <td><%= libro1.getNombre()%></td>
                                
                                <td><%= libro1.getCantidad()%></td>
                           </tr>
        </table>
        <%
            }
            sesion.invalidate();
            // Aqui invalidamos la sesion para que si volvemos a entrar no esten los libros guardados.
        %>
        <br/>
        <br/>
        <a href="../index.html">Volver a Menu</a>
        <%
            }
        } catch (NullPointerException nu) {
        %>
        <h3>No ha realizado ninguna compra, vuelva pronto</h3>
        <br/>
        <br/>
        <a href="../index.html">Volver a Menu</a>
        <%
            }
        %>
    </body>
</html>
