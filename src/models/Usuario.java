package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Libro> librosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void prestarLibro(Libro libro) {
        if (!libro.isPrestado()) {
            librosPrestados.add(libro);
            libro.prestar();
        } else {
            System.out.println("El libro ya está prestado.");
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.remove(libro)) {
            libro.devolver();
        } else {
            System.out.println("El usuario no tiene este libro.");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", librosPrestados=" + librosPrestados +
                '}';
    }
}
