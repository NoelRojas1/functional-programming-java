package declarative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static declarative.Main.Genre.*;

/**
 * In the declarative approach, we tell the program what we
 * want, and we do not worry about the details of the implementation
 * of the program(s).
 */

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("The Hunger Games", SCIFI),
                new Book("The Notebook", ROMANCE),
                new Book("Divergent", SCIFI),
                new Book("Maze Runner", SCIFI)
        );

        /**
         * If we want to know how many books are scifi or romance.
         * We tell the program what we want.
         */
        long count = books.stream()
                .filter(book -> book.getGenre() == SCIFI)
                .count();
        System.out.println("The number of sci-fi books is: " + count);

        /**
         * If we want to separate the sci-fi books to their own array list,
         * we tell the program exactly what we want. We do not worry about the
         * how.
         */
        List<Book> scifi = books.stream()
                .filter(book -> SCIFI.equals(book.getGenre()))
                .collect(Collectors.toList());
        scifi.forEach(book -> System.out.println(book));
    }

    /**
     * Book class
     */
    static class Book {
        private String title;
        private Genre genre;

        public Book(String title, Genre genre) {
            this.title = title;
            this.genre = genre;
        }

        public Genre getGenre() {
            return genre;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return String.format("Title: %s. Genre: %s", title, genre);
        }
    }

    /**
     * Genres
     */
    enum Genre {
        SCIFI, FICTION, HORROR, ROMANCE
    }
}