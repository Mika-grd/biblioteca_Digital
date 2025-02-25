package co.edu.uniquindio.poo.model;

public abstract class MaterialBibliografico {
    private Usuario registradoPor;
    private String titulo;
    private String autor;
    private String id;
    private String anioPublicacion;
    private boolean disponible;
    private boolean prestado;

    public MaterialBibliografico(Usuario registradoPor, String titulo, String autor, String id, String anioPublicacion, boolean disponible, boolean prestado) {
        this.registradoPor = registradoPor;
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
        this.prestado = prestado;
    }

    public Usuario getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(Usuario registradoPor) {
        this.registradoPor = registradoPor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
