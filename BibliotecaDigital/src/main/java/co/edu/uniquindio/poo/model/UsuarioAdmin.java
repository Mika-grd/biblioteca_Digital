package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class UsuarioAdmin extends Usuario {

    private BibliotecaMain bibliotecaMain;
    private LinkedList<Prestamo> listaPrestamosAPorbados = new LinkedList<>();


    public UsuarioAdmin(String password, String nombre, String id, String correo, boolean sancionado) {
        super(password, nombre, id, correo, sancionado);
    }

    /*Gestionar Materiales */
    private String agregarMaterial(MaterialBibliografico material) {
        return bibliotecaMain.agregarMaterial(material);
    }
    private String eliminarMaterial(MaterialBibliografico material) {
        return bibliotecaMain.eliminarMaterial(material);
    }

    private String editarMaterial(MaterialBibliografico material, MaterialBibliografico materialNuevo) {
        return bibliotecaMain.editarMaterial(material, materialNuevo);
    }

    private MaterialBibliografico buscarMaterialBibliografico(String id) {
        return bibliotecaMain.buscarMaterial(id);
    }

    /*Metodo para aprobar los prestamos de un usuario y añadirlos a la lista de prestamos de la biblioteca */
    private String aprobarPrestamos(Usuario usuario, String id, LocalDate fechaInicio, LocalDate fechaFin) {
        String aprobado = "No hay prestamos sin aprobar";
        for (Prestamo prestamo : usuario.getPrestamosPropios()) {
            if (!prestamo.isAprobado()) {
                prestamo.setAprobado(true);
                prestamo.setId(id);
                prestamo.setFechaInicio(fechaInicio);
                prestamo.setFechaFin(fechaFin);
                bibliotecaMain.agregarPrestamo(prestamo);
                prestamo.getMaterial().setDisponible(false);
            }
            return "Exitoso";
        }
        return aprobado;

    }

    /*Metodo para sancionar a todos los usuarios con prestamos vencidos*/
    private void sacionarUsuariosPrestamosVencidos(){
        for (Usuario u : bibliotecaMain.getListaUsuarios()){
            for (Prestamo p: u.getPrestamosPropios()){
                if (p.isVencido()){
                    u.setSancionado(true);
                }
            }
        }
    }

    /*Metodo para sancionar a usuario especifico a partir de @param id*/
    private String sancionarUsuario(String id) {
        String resultado = "Exitoso";
        if (id != null) {
            for (Usuario u : bibliotecaMain.getListaUsuarios()) {
                if (u.getId().equals(id)) {
                    u.setSancionado(true);
                    return resultado;
                }
            }
        }

        return "No exitoso";
    }

    public LinkedList<Prestamo> getListaPrestamosAPorbados() {
        return listaPrestamosAPorbados;
    }

    public void setListaPrestamosAPorbados(LinkedList<Prestamo> listaPrestamosAPorbados) {
        this.listaPrestamosAPorbados = listaPrestamosAPorbados;
    }
}
