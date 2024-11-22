package main;

import models.Libro;
import models.Usuario;
import services.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        // Crear libros
        Libro libro1 = new Libro("1984", "George Orwell");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Registrar usuarios
        Usuario usuario1 = new Usuario("Juan Pérez");
        biblioteca.registrarUsuario(usuario1);

        // Prestar libro
        usuario1.prestarLibro(libro1);

        // Mostrar estado
        System.out.println("Catalogo de libros:");
        biblioteca.mostrarCatalogo();
        System.out.println("Usuarios registrados:");
        biblioteca.getUsuarios().forEach(System.out::println);

        // Devolver libro
        usuario1.devolverLibro(libro1);
    }
}
