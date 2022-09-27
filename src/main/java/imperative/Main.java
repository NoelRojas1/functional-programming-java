package imperative;

import java.util.ArrayList;
import java.util.List;
import static imperative.Main.Genre.*;

/**
 * In the imperative approach, which we all are used to,
 * we have to tell the program how to do stuff.
 * In other words we have to take care of the details of the
 * functionality of the program(s) we write.
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
         * If we want to know how many books are scifi or romance,
         * we have to loop through the list and check what each
         * book's genre is and keep a count
         */
        int count = 0;
        for(Book book : books) {
            if(book.getGenre() == SCIFI) {
                count++;
            }
        }
        System.out.println("The number of sci-fi books is: " + count);

        /**
         * If we want to separate the sci-fi books to their own array list,
         * we need to loop through the whole array, checking if each book's
         * genre is sci-fi and then adding to a new list that we also need to
         * create.
         */
        List<Book> scifi = new ArrayList<>();
        for(Book book : books) {
            if(SCIFI.equals(book.getGenre())) {
                scifi.add(book);
            }
        }

        for(Book scifiBook : scifi) {
            System.out.println(scifiBook);
        }

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
