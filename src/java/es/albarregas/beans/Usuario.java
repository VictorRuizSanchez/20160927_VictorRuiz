package es.albarregas.beans;

public class Usuario {
    
    private int id;
    private String nombre;
    private int sueldo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    /*
    HttpSession sesion = request.getSession(true);
    int contador = 0;
    response.setContentType("text/html");
    boolea isInvalidate = true;
    if(r.gP("eliminar") != null && request.gP(eliminar).equals("true")) {
    sesion.invalidate();
    isInvalidate = true;
    }else{
    if(sesion.getAttribute("contaSesion) != null) { --> contaSesion es donde podemos meter el Objeto contador.getNombre.getID.getEdad
    contador = ((Integer)sesion.getAttribute("contaSesion));
    }
    sesion.setAttribute("contaSesion", new Integer(contador + 1));
    )
    form
    if(!isInvalidate){
        out.println(Visitas + (contador+1));
        Invalidar sesion: <input type='checkbox' name='eliminar' value='true'>
    }
    submit value='refrescar'
    volver
    
    Crear el objeto Objeto o = new Objeto;
    rellenamos o.setEdad(22)
    o.setNombre("Pepe");
    sesion.setAttribute("usuario", new o(contador + 1));
    */
}
