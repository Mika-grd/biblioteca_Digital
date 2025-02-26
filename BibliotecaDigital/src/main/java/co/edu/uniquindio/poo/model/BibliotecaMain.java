package co.edu.uniquindio.poo.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BibliotecaMain {
    private String nombre;
    private LinkedList<MaterialBibliografico> listaMateriales;
    private LinkedList<Prestamo> listaPrestamos;
    private LinkedList<Usuario> listaUsuarios;
    private static BibliotecaMain instance;


    /*Implementación del singleton */
    public static BibliotecaMain getInstance(String nombre, LinkedList<MaterialBibliografico> listaMateriales, LinkedList<Prestamo> listaPrestamos, LinkedList<Usuario> listaUsuarios) {
        if (instance == null) {
            instance = new BibliotecaMain("UQ",listaMateriales,listaPrestamos,listaUsuarios); // Se crea solo la primera vez
        }
        return instance;
    }


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

    //CRUD generico

    public <T> String agregarObjeto(T objeto, LinkedList<T> listaObjetos) {
        if (objeto != null) {
            listaObjetos.add(objeto);
            return "Exitoso";
        }
        return "No exitoso";
    }

    public <T> String eliminarObjeto(T objeto, LinkedList<T> listaObjetos) {
        if (objeto != null) {
            listaObjetos.remove(objeto);
            return "Exitoso";
        }
        return "No exitoso";
    }

    public <T> String editarObjeto(T objeto, T objetoNuevo, LinkedList<T> listaObjetos) {
        String resultado = "Exitoso";
        if (objeto != null && objetoNuevo != null) {
            listaObjetos.remove(objeto);
            listaObjetos.add(objetoNuevo);
            return resultado;
        }
        return "No exitoso";
    }


    public <T> T buscarObjeto(Object id, LinkedList<T> listaObjetos) {
        for (T objeto : listaObjetos) {
            try {
                Method getIdMethod = objeto.getClass().getMethod("getId");
                Object objetoId = getIdMethod.invoke(objeto);

                if (objetoId != null && objetoId.equals(id)) {
                    return objeto;
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null; // Retorna null si no se encuentra el objeto con el ID dado
    }

    /*CRUD Material    */

    public String agregarMaterial(MaterialBibliografico material) {
        if (!material.getRegistradoPor().isSancionado()) {
            return agregarObjeto(material, listaMateriales);
        }
        return "No exitoso";
    }

    public String eliminarMaterial(MaterialBibliografico material) {
        return eliminarObjeto(material, listaMateriales);
    }

    public String editarMaterial(MaterialBibliografico material, MaterialBibliografico materialNuevo) {
        if (listaMateriales.contains(material)) {
            return editarObjeto(material, materialNuevo, listaMateriales);
        }
        return "No existe";
    }

    public MaterialBibliografico buscarMaterial(String id) {
        return buscarObjeto(id, listaMateriales);
    }

    /*CRUD Prestamo     */

    private Prestamo buscarPrestamo(String id) {
        return buscarObjeto(id, listaPrestamos);
    }

    public String agregarPrestamo(Prestamo prestamo) {
        return agregarObjeto(prestamo, listaPrestamos);
    }

    private String eliminarPrestamo(Prestamo prestamo) {
        return eliminarObjeto(prestamo, listaPrestamos);
    }

    private String editarPrestamo(Prestamo prestamo, Prestamo prestamoNuevo) {
        return editarObjeto(prestamo, prestamoNuevo, listaPrestamos);
    }

    /*CRUD Usuario      */

    private Usuario buscarUsuario(String id) {
        return buscarObjeto(id, listaUsuarios);
    }

    private String eliminarUsuario(Usuario usuario) {
        return eliminarObjeto(usuario, listaUsuarios);

    }

    private String editarUsuario(Usuario usuario, Usuario usuarioNuevo) {
        return editarObjeto(usuario, usuarioNuevo, listaUsuarios);
    }

    private String agregarUsuario(Usuario usuario) {
        return agregarObjeto(usuario, listaUsuarios);
    }


    /*     *Constructor y Gets & Sets
     */
    private BibliotecaMain(String nombre, LinkedList<MaterialBibliografico> listaMateriales, LinkedList<Prestamo> listaPrestamos, LinkedList<Usuario> listaUsuarios) {
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
