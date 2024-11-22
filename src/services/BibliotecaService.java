package services;

import models.Libro;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Libro> catalogo;
    private List<Usuario> usuarios;

    public BibliotecaService() {
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void mostrarCatalogo() {
        catalogo.forEach(System.out::println);
    }
}
