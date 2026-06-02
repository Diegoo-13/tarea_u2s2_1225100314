package utng.gtid2.dab.tarea_u2s2;

public class Libro {

    // ATRIBUTOS DEL LIBRO
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;

    // Por defecto el libro está disponible
    private boolean disponible = true;

    private int numPaginas;

    // Atributo estático para contar cuántos libros se han creado
    private static int totalLibros = 0;

    // CONSTRUCTOR COMPLETO
    // Se ejecuta cuando creamos un libro con todos sus datos
    public Libro(String isbn, String titulo, String autor, int anio, int numPaginas) {

        // Guarda el ISBN recibido en el atributo isbn del objeto
        this.isbn = isbn;

        // Guarda el título recibido
        this.titulo = titulo;

        // Guarda el autor recibido
        this.autor = autor;

        // Guarda el año solamente si pasa la validación
        setAnio(anio);

        // Guarda el número de páginas
        this.numPaginas = numPaginas;

        // Aumenta el contador de libros creados
        totalLibros = totalLibros + 1;
    }

    // CONSTRUCTOR SOBRECARGADO
    // Si solo proporcionan ISBN, título y autor
    public Libro(String isbn, String titulo, String autor) {

        // Llama al constructor completo
        // anio = 0 y numPaginas = 0
        this(isbn, titulo, autor, 0, 0);
    }

    // GETTERS
    // Sirven para consultar información del objeto

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    // Como es boolean se usa "is"
    public boolean isDisponible() {
        return disponible;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    // Devuelve el número total de libros creados
    public static int getTotalLibros() {
        return totalLibros;
    }

    // SETTER CON VALIDACIÓN
    // Solo permite años entre 1450 y 2025
    public void setAnio(int anio) {

        // Verifica si el año es válido
        if (anio == 0 || (anio >= 1450 && anio <= 2025)) {

            // Guarda el año en el atributo
            this.anio = anio;

        } else {

            // Muestra error si el año no es válido
            throw new IllegalArgumentException("El año debe estar entre 1450 y 2025.");
        }
    }

    // MÉTODO PARA PRESTAR EL LIBRO
    public void prestar() {

        // Si el libro NO está disponible
        if (!disponible) {

            // Genera un error
            throw new IllegalStateException("El libro ya está prestado.");
        }

        // Si está disponible, lo presta
        disponible = false;
    }

    // MÉTODO PARA DEVOLVER EL LIBRO
    public void devolver() {

        // El libro vuelve a estar disponible
        disponible = true;
    }

    // SOBRESCRITURA DEL MÉTODO toString()
    // Sirve para mostrar la información del libro de forma bonita
    @Override
    public String toString() {

        String estado;

        // Determina el texto que se mostrará
        if(disponible){estado = "disponible";}
        
        else{estado = "no disponible";}

        // Devuelve una cadena con toda la información del libro
        return "[" + isbn + "] " + titulo + " por " + autor + " (" + anio + ") - " + estado;
    }

}
