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

        // Prestar libro con validaciones directamente en Main
        try {
            // Validar si el libro existe en la biblioteca
            if (!biblioteca.getCatalogo().contains(libro1)) {
                throw new IllegalArgumentException("El libro no se encuentra en el catálogo.");
            }

            // Validar si el libro está disponible
            if (!libro1.estaDisponible()) {
                throw new IllegalStateException("El libro '" + libro1.getTitulo() + "' no está disponible.");
            }

            // Prestar el libro
            libro1.setDisponible(false); // Cambiar el estado del libro
            usuario1.prestarLibro(libro1); // Añadir el libro a la lista del usuario
            System.out.println(usuario1.getNombre() + " ha prestado el libro: " + libro1.getTitulo());

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Error al prestar libro: " + e.getMessage());
        }

        // Mostrar estado
        System.out.println("Catálogo de libros:");
        biblioteca.mostrarCatalogo();
        System.out.println("Usuarios registrados:");
        biblioteca.getUsuarios().forEach(System.out::println);

        // Devolver libro
        usuario1.devolverLibro(libro1);
    }
}
