package co.edu.uniquindio.poo.model;

public class Libro extends MaterialBibliografico{
    private String editorial;
    private String genero;

    public Libro(Usuario registradoPor, String titulo, String autor, String id, String anioPublicacion, boolean disponible, boolean prestado, String editorial, String genero) {
        super(registradoPor, titulo, autor, id, anioPublicacion, disponible, prestado);
        this.editorial = editorial;
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
