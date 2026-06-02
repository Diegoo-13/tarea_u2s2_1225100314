package utng.gtid2.dab.tarea_u2s2;

public class Main {
    public static void main(String[] args) {

        Libro l1 = new Libro("978-1", "Clean Code", "Robert C. Martin", 2008, 431);
        Libro l2 = new Libro("978-2", "Effective Java", "Joshua Bloch");

        l1.prestar();

        System.out.println(l1.isDisponible());
        System.out.println(Libro.getTotalLibros());
        System.out.println(l1);

        Catalogo cat = new Catalogo();

        cat.agregarLibro(l1);
        cat.agregarLibro(l2);

        System.out.println(cat.contarDisponibles());
        System.out.println(cat.buscarPorIsbn("978-2").getTitulo());
        System.out.println(cat);
    }
}
