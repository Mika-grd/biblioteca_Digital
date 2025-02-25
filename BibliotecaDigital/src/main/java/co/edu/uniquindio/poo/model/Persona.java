package co.edu.uniquindio.poo.model;

public abstract class Persona {
    private String nombre;
    private String id;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Persona(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }


}
