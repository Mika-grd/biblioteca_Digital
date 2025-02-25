package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Prestamo {
    private MaterialBibliografico material;
    private Usuario usuario;
    private Usuario aprobadoPor;
    private String id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean vencido;
    private boolean aprobado;

    public Prestamo(MaterialBibliografico material, Usuario usuario, Usuario aprobadoPor, String id, LocalDate fechaInicio, LocalDate fechaFin, boolean vencido, boolean aprobado) {
        this.material = material;
        this.usuario = usuario;
        this.aprobadoPor = aprobadoPor;
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vencido = vencido;
        this.aprobado = aprobado;
    }

    public MaterialBibliografico getMaterial() {
        return material;
    }

    public void setMaterial(MaterialBibliografico material) {
        this.material = material;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Usuario aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {

        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;

    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public boolean isVencido() {
        return vencido;
    }
    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }
    public boolean isAprobado() {
        return aprobado;
    }
    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
}
