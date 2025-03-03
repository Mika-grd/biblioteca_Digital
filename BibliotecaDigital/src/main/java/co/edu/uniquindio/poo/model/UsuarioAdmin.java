package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class UsuarioAdmin extends Persona implements IGestorAdmin{
    private BibliotecaMain biblioteca=  BibliotecaMain.getInstance();
    private String password;
    private boolean sancionado;
    private BibliotecaMain bibliotecaMain;
    private LinkedList<Prestamo> listaPrestamosAPorbados = new LinkedList<>();

    public UsuarioAdmin(String nombre, String id, String correo, String password, boolean sancionado) {
        super(nombre, id, correo);
        this.biblioteca = biblioteca;
        this.password = password;
        this.sancionado = sancionado;
        this.bibliotecaMain = bibliotecaMain;
        this.listaPrestamosAPorbados = new LinkedList<>();
    }

    /*Gestionar Materiales */

    public String agregarMaterial(MaterialBibliografico material) {

        return bibliotecaMain.agregarMaterial(material);
    }

    public String eliminarMaterial(MaterialBibliografico material) {
        return bibliotecaMain.eliminarMaterial(material);
    }

    public String editarMaterial(MaterialBibliografico material, MaterialBibliografico materialNuevo) {
        return bibliotecaMain.editarMaterial(material, materialNuevo);
    }

    public MaterialBibliografico buscarMaterial(String id) {
        return bibliotecaMain.buscarMaterial(id);
    }

    /*Metodo para aprobar los prestamos de un usuario y añadirlos a la lista de prestamos de la biblioteca */
    public String aprobarPrestamos(Usuario usuario, String id, LocalDate fechaInicio, LocalDate fechaFin) {
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
    public void sancionarUsuariosPrestamosVencidos() {
        for (Persona u : bibliotecaMain.getListaUsuarios()) {
            if (u instanceof Usuario) { // Verificar si es un Usuario
                Usuario usuario = (Usuario) u; // Downcasting seguro
                for (Prestamo p : usuario.getPrestamosPropios()) {
                    if (p.isVencido()) {
                        usuario.setSancionado(true);
                        break; // Evita sancionar múltiples veces al mismo usuario
                    }
                }
            }
        }
    }
    /*Metodo para sancionar a usuario especifico a partir de @param id*/
    public String sancionarUsuario(String id) {
        String resultado = "No exitoso";
        if (id != null) {
            for (Persona u : bibliotecaMain.getListaUsuarios()) {
                if (u instanceof Usuario && u.getId().equals(id)) { // Verifica tipo y compara ID
                    ((Usuario) u).setSancionado(true); // Downcasting y sanción
                    return "Exitoso";
                }
            }
        }
        return resultado;
    }

    public LinkedList<Prestamo> getListaPrestamosAPorbados() {
        return listaPrestamosAPorbados;
    }

    public void setListaPrestamosAPorbados(LinkedList<Prestamo> listaPrestamosAPorbados) {
        this.listaPrestamosAPorbados = listaPrestamosAPorbados;
    }

    public BibliotecaMain getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(BibliotecaMain biblioteca) {
        this.biblioteca = biblioteca;
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

    public BibliotecaMain getBibliotecaMain() {
        return bibliotecaMain;
    }

    public void setBibliotecaMain(BibliotecaMain bibliotecaMain) {
        this.bibliotecaMain = bibliotecaMain;
    }

}
