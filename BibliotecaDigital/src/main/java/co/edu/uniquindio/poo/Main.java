package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.*;

public class Main {

    public static void main(String[] args) {
        BibliotecaMain bibliotecaMain = BibliotecaMain.getInstance();
        Usuario usuario1 = new Usuario("u1", "1", null, "123", false);
        UsuarioAdmin usad1 = new UsuarioAdmin("u2", "2", null, "456", false);


        System.out.println(bibliotecaMain.toString());
    }
}