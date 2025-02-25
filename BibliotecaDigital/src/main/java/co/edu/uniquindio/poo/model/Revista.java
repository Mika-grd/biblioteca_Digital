package co.edu.uniquindio.poo.model;

public class Revista extends MaterialBibliografico{
    private String edicion;

    public Revista(Usuario registradoPor, String titulo, String autor, String id, String anioPublicacion, boolean disponible, boolean prestado, String edicion) {
        super(registradoPor, titulo, autor, id, anioPublicacion, disponible, prestado);
        this.edicion = edicion;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
}
