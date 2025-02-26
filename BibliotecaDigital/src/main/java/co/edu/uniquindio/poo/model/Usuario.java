package co.edu.uniquindio.poo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class Usuario extends Persona implements IMiembro{
    private BibliotecaMain biblioteca = BibliotecaMain.getInstance();
    private String password;
    private boolean sancionado;
    private LinkedList<Prestamo> prestamosPropios = new LinkedList<>();

    /*Buscar libro por id*/
    public MaterialBibliografico buscarMaterialBibliografico(String id) {
        return biblioteca.buscarMaterial(id);
    };

    /*Buscar libro por autor*/
    public MaterialBibliografico buscarMaterialBibliograficoAutor(String autor) {
        return biblioteca.buscarMaterialAutor(autor);
    };


    /*Metodo para crear un prestamo en la lista de prestamos propios, para que eventualmente un admin lo apruebe*/
    public String solicitarPrestamo(MaterialBibliografico material) {
        String solicitarPrestamo = "";

        if (material != null) {
            if(material.isDisponible() && !material.isPrestado()){
                prestamosPropios.add(new Prestamo(material,null, null, null, null, null, false, false));
            }
        }

        return solicitarPrestamo;
    }

    /*Metodo para devolver el material de algun prestamo y marcar como vencido o no vencido el prestamo y volver a marcar como disponible el material*/
    public String devolverMaterial(MaterialBibliografico material, LocalDate fechaActual) {
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

    public Usuario(String nombre, String id, String correo, BibliotecaMain biblioteca, String password, boolean sancionado, LinkedList<Prestamo> prestamosPropios) {
        super(nombre, id, correo);
        this.biblioteca = biblioteca;
        this.password = password;
        this.sancionado = sancionado;
        this.prestamosPropios = prestamosPropios;
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


    public boolean isSancionado() {
        return sancionado;
    }

    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }
}
