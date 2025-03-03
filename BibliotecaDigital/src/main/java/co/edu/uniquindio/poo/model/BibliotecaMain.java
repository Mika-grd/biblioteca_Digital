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
    private LinkedList<Persona> listaUsuarios;
    private static BibliotecaMain instance;


    /*Implementación del singleton */
    public static BibliotecaMain getInstance() {
        if (instance == null) {
            instance = new BibliotecaMain("UQ",new LinkedList<MaterialBibliografico>(), new LinkedList<Prestamo>(), new LinkedList<Persona>() ); // Se crea solo la primera vez
        }
        return instance;
    }


    /* Metodo para contar los prestamos pendientes de todos los usuarios */

    public int contarPrestamoSinAprobar() {
        int contadorPrestamoSinAprobar = 0;
        for (Persona usuario : listaUsuarios) {
            if (usuario instanceof Usuario) {  // Verifica si es un Usuario
                Usuario u = (Usuario) usuario; // Downcasting seguro
                for (Prestamo prestamo : u.getPrestamosPropios()) {
                    if (!prestamo.isAprobado()) {
                        contadorPrestamoSinAprobar++;
                    }
                }
            }
        }
        return contadorPrestamoSinAprobar;
    }

    /* Metodo para encontrar los usuarios con prestamos sin aprobar  */

    public String usuariosPrestamoSinAprobar() {
        StringBuilder usuarios = new StringBuilder();
        for (Persona usuario : listaUsuarios) {
            if (usuario instanceof Usuario) { // Verifica si es un Usuario
                Usuario u = (Usuario) usuario; // Downcasting seguro
                for (Prestamo prestamo : u.getPrestamosPropios()) {
                    if (!prestamo.isAprobado()) {
                        usuarios.append(usuario.getNombre()).append(", ");
                        break; // Evita agregar el mismo usuario más de una vez
                    }
                }
            }
        }
        // Elimina la última coma y el espacio si hay datos en la lista
        if (!usuarios.isEmpty()) {
            usuarios.setLength(usuarios.length() - 2);
        }
        return usuarios.toString();
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

    public Prestamo buscarPrestamo(String id) {
        return buscarObjeto(id, listaPrestamos);
    }

    public String agregarPrestamo(Prestamo prestamo) {
        return agregarObjeto(prestamo, listaPrestamos);
    }

    public String eliminarPrestamo(Prestamo prestamo) {
        return eliminarObjeto(prestamo, listaPrestamos);
    }

    public String editarPrestamo(Prestamo prestamo, Prestamo prestamoNuevo) {
        return editarObjeto(prestamo, prestamoNuevo, listaPrestamos);
    }

    /*CRUD Usuario      */

    public Persona buscarUsuario(String id) {
        return buscarObjeto(id, listaUsuarios);
    }

    public String eliminarUsuario(Persona usuario) {
        return eliminarObjeto(usuario, listaUsuarios);

    }

    public String editarUsuario(Persona usuario, Persona usuarioNuevo) {
        return editarObjeto(usuario, usuarioNuevo, listaUsuarios);
    }

    public String agregarUsuario(Persona usuario) {
        return agregarObjeto(usuario, listaUsuarios);
    }


    /*     *Constructor y Gets & Sets
     */
    private BibliotecaMain(String nombre, LinkedList<MaterialBibliografico> listaMateriales, LinkedList<Prestamo> listaPrestamos, LinkedList<Persona> listaUsuarios) {
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

    @Override
    public String toString() {
        return "BibliotecaMain{" +
                "nombre='" + nombre + '\'' +
                ", listaMateriales=" + listaMateriales +
                ", listaPrestamos=" + listaPrestamos +
                ", listaUsuarios=" + listaUsuarios +
                '}';
    }

    public LinkedList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(LinkedList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public LinkedList<Persona> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Persona> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
