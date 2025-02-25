package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Usuario {
    private BibliotecaMain biblioteca;
    private String password;
    private String nombre;
    private String id;
    private String correo;
    private boolean sancionado;
    private LinkedList<Prestamo> prestamosPropios = new LinkedList<>();

    /*Buscar libro por id*/
    private MaterialBibliografico buscarMaterialBibliografico(String id) {
        return biblioteca.buscarMaterial(id);
    };

    /*Buscar libro por autor*/
    private MaterialBibliografico buscarMaterialBibliograficoAutor(String autor) {
        return biblioteca.buscarMaterialAutor(autor);
    };


    /*Metodo para crear un prestamo en la lista de prestamos propios, para que eventualmente un admin lo apruebe*/
    private String solicitarPrestamo(MaterialBibliografico material) {
        String solicitarPrestamo = "";

        if (material != null) {
            if(material.isDisponible() && material.isPrestado()){
                prestamosPropios.add(new Prestamo(material,null, null, null, null, null, false, false));
            }
        }

        return solicitarPrestamo;
    }

    /*Metodo para devolver el material de algun prestamo y marcar como vencido o no vencido el prestamo y volver a marcar como disponible el material*/
    private String devolverMaterial(MaterialBibliografico material, LocalDate fechaActual) {
        String devolverMaterial = "";

        if (material != null) {
            material.setDisponible(true);
            for (Prestamo prestamo : prestamosPropios) {
                if (prestamo.getMaterial().equals(material)) {
                    if (fechaActual.isAfter(prestamo.getFechaFin())) {
                        prestamo.setVencido(true);
                        devolverMaterial = "Devuelto exitosamente después del plazo";
                    } prestamo.setVencido(false);
                     devolverMaterial = "devuelto exitosamente";
                }
            }
        }
        return devolverMaterial;
    }

    /*Constructor Gets & Sets*/
    public Usuario(String password, String nombre, String id, String correo, boolean sancionado) {
        this.password = password;
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.sancionado = sancionado;
    }

    public LinkedList<Prestamo> getPrestamosPropios() {
        return prestamosPropios;
    }

    public void setPrestamosPropios(LinkedList<Prestamo> prestamosPropios) {
        this.prestamosPropios = prestamosPropios;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isSancionado() {
        return sancionado;
    }

    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }
}
