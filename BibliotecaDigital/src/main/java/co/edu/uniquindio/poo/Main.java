package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.*;

public class Main {

    public static void main(String[] args) {
        BibliotecaMain bibliotecaMain = BibliotecaMain.getInstance();
        Usuario usuario1 = new Usuario("u1", "1", null, "123", false);
        UsuarioAdmin usad1 = new UsuarioAdmin("u2", "2", null, "456", false);

        bibliotecaMain.agregarUsuario(usuario1);
        bibliotecaMain.agregarUsuario(usad1);

        Libro libro = new Libro(null, "Caida", "MArco", "123", null, true, false, null, null);

        usuario1.buscarMaterialBibliografico(libro.getId());
        usuario1.solicitarPrestamo(libro);

        bibliotecaMain.contarPrestamoSinAprobar();

        usad1.aprobarPrestamos(usuario1, "1", null, null);



        System.out.println(bibliotecaMain.toString());
    }
}