package co.edu.uniquindio.poo.model;

public class DVD extends  MaterialBibliografico {
    private float duracion;

    public DVD(Usuario registradoPor, String titulo, String autor, String id, String anioPublicacion, boolean disponible, boolean prestado, float duracion) {
        super(registradoPor, titulo, autor, id, anioPublicacion, disponible, prestado);
        this.duracion = duracion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
}
