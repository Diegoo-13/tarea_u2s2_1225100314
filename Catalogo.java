package utng.gtid2.dab.tarea_u2s2;

import java.util.ArrayList; // Permite usar listas dinámicas

public class Catalogo {

    // Lista donde se guardarán varios objetos de tipo Libro
    private ArrayList<Libro> libros;

    // Constructor: se ejecuta al crear un catálogo
    public Catalogo() {
        libros = new ArrayList<Libro>(); // Crea la lista vacía
    }

    // Agrega un libro al catálogo
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Busca un libro por su ISBN
    public Libro buscarPorIsbn(String isbn) {

        // Recorre todos los libros de la lista
        for (Libro libro : libros) {

            // Compara el ISBN del libro actual con el ISBN buscado
            if (libro.getIsbn().equals(isbn)) {
                return libro; // Si lo encuentra, regresa ese libro
            }
        }

        return null; // Si no encuentra nada, regresa null
    }

    // Busca libros por autor
    public ArrayList<Libro> buscarPorAutor(String autor) {

        // Lista donde guardaremos los libros encontrados
        ArrayList<Libro> resultado = new ArrayList<Libro>();

        // Recorre todos los libros del catálogo
        for (Libro libro : libros) {

            // Si el autor del libro coincide con el autor buscado
            if (libro.getAutor().equals(autor)) {
                resultado.add(libro); // Lo agrega a la lista de resultados
            }
        }

        return resultado; // Regresa la lista con los libros encontrados
    }

    // Regresa una lista con los libros disponibles
    public ArrayList<Libro> listarDisponibles() {

        ArrayList<Libro> disponibles = new ArrayList<Libro>();

        for (Libro libro : libros) {

            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }

        return disponibles;
    }

    // Cuenta cuántos libros están disponibles
    public int contarDisponibles() {

        int contador = 0;

        for (Libro libro : libros) {

            if (libro.isDisponible()) {
                contador = contador + 1;
            }
        }

        return contador;
    }

    // Muestra un resumen del catálogo
    @Override
    public String toString() {
        return "Catalogo: " + libros.size() + " libros, " + contarDisponibles() + " disponibles";
    }
}