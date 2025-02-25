package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class BibliotecaMain {
    private String nombre;
    private LinkedList<MaterialBibliografico> listaMateriales;
    private LinkedList<Prestamo> listaPrestamos;
    private LinkedList<Usuario> listaUsuarios;

    /* Metodo para contar los prestamos pendientes de todos los usuarios */

    private int contarPrestamoSinAprobar(){
        int contadorPrestamoSinAprobar = 0;
        for (Usuario usuario : listaUsuarios) {
            for (Prestamo prestamo : usuario.getPrestamosPropios()) {
                if (!prestamo.isAprobado()) {
                    contadorPrestamoSinAprobar++;
                }
            }
        }
        return contadorPrestamoSinAprobar;
    }

    /* Metodo para encontrar los usuarios con prestamos sin aprobar  */

    private String usuariosPrestamoSinAprobar(){
        String usuarios = "";
        for (Usuario usuario : listaUsuarios) {
            for (Prestamo prestamo : usuario.getPrestamosPropios()) {
                if (!prestamo.isAprobado()) {
                    usuarios = usuarios + usuario.getNombre() + ", ";
                    break;
                }
            }
        }
        return usuarios;
    }

    /*Metodo para buscarun material por el autor*/


    public MaterialBibliografico buscarMaterialAutor(String autor) {
        for (MaterialBibliografico material : listaMateriales) {
            if (material.getAutor().equals(autor)) {
                return material;
            }
        }
        return null;
    }
    /*CRUD Material    */

    public String agregarMaterial(MaterialBibliografico material) {
        String resultado = "Exitoso";
        if (material != null) {
            listaMateriales.add(material);
            return resultado;
        }
        return "No exitoso";
    }

    public String eliminarMaterial(MaterialBibliografico material) {
        String resultado = "Exitoso";
        if (material != null) {
            listaMateriales.remove(material);
            return resultado;
        }
        return "No exitoso";
    }

    public String editarMaterial(MaterialBibliografico material, MaterialBibliografico materialNuevo) {
        String resultado = "Exitoso";
        if (material != null && materialNuevo != null) {
            listaMateriales.remove(material);
            listaMateriales.add(materialNuevo);
            return resultado;
        }
        return "No exitoso";
    }

    public MaterialBibliografico buscarMaterial(String id) {
        for (MaterialBibliografico material : listaMateriales) {
            if (material.getId().equals(id)) {
                return material;
            }
        }
        return null;
    }

    /*CRUD Prestamo     */

    private Prestamo buscarPrestamo(String id) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId().equals(id)) {
                return prestamo;
            }
        }
        return null;
    }

    public String agregarPrestamo(Prestamo prestamo) {
        String resultado = "Exitoso";
        if (prestamo != null) {
            listaPrestamos.remove(prestamo);
            return resultado;
        }
        return "No exitoso";
    }

    private String eliminarPrestamo(Prestamo prestamo) {
        String resultado = "Exitoso";
        if (prestamo != null) {
            listaPrestamos.remove(prestamo);
            return resultado;

        }
        return "No exitoso";
    }

    private String editarPrestamo(Prestamo prestamo, Prestamo prestamoNuevo) {
        String resultado = "Exitoso";
        if (prestamo != null && prestamoNuevo != null) {
            listaPrestamos.remove(prestamo);
            listaPrestamos.add(prestamoNuevo);
            return resultado;

        }
        return "No exitoso";
    }

    /*CRUD Usuario      */

    private Usuario buscarUsuario(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;

            }
        }
        return null;
    }

    private String eliminarUsuario(Usuario usuario) {
        String resultado = "Exitoso";
        if (usuario != null) {
            listaUsuarios.remove(usuario);
            return resultado;
        }
        return "No exitoso";

    }

    private String editarUsuario(Usuario usuario, Usuario usuarioNuevo) {
        String resultado = "Exitoso";
        if (usuario != null && usuarioNuevo != null) {
            listaUsuarios.remove(usuario);
            listaUsuarios.add(usuarioNuevo);
            return resultado;
        }
        return "No exitoso";
    }

    private String agregarUsuario(Usuario usuario) {
        String resultado = "Exitoso";
        if (usuario != null) {
            listaUsuarios.add(usuario);
            return resultado;
        }
        return "No exitoso";

    }


    /*     *Constructor y Gets & Sets
     */
    public BibliotecaMain(String nombre, LinkedList<MaterialBibliografico> listaMateriales, LinkedList<Prestamo> listaPrestamos, LinkedList<Usuario> listaUsuarios) {
        this.nombre = nombre;
        this.listaMateriales = listaMateriales;
        this.listaPrestamos = listaPrestamos;
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<MaterialBibliografico> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(LinkedList<MaterialBibliografico> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public LinkedList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(LinkedList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
