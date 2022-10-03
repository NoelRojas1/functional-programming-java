package streams;

import common.Book;
import common.Genre;

import static common.Genre.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Streams are a sequence of elements supporting sequential and parallel aggregate operations.
 *
 * The Stream API https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 * counts with a variety of functional methods that allow us to operate in a much easier way
 * over collections.
 *
 * Some of the most useful methods of this API are:
 * allMatch, anyMatch, collect, filter, map, flatMap, findFirst, findAny, forEach, peek, sorted, reduce.
 *
 * Most of these methods return a Stream (except terminal operations), so that means we can chain them together to perform different operations
 * on the same collection.
 */
public class _Stream {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("The Hunger Games", FICTION),
                new Book("Catching Fire", FICTION),
                new Book("Mockingjay", FICTION),
                new Book("The Notebook", ROMANCE),
                new Book("The Thing We Cannot Say", ROMANCE),
                new Book("The Love Hypothesis", ROMANCE),
                new Book("Dracula", HORROR),
                new Book("It", HORROR)
        );

        // Find all the FICTION books and print them to the console
        System.out.println("Fiction books: ");
        books.stream()
                .filter(book -> book.getGenre() == FICTION) // filter accepts a Predicate (a function that returns a boolean)
                .forEach(System.out::println); // forEach accepts a Consumer (a function that does not return any value)

        // Find the number of books that starts with the letter D
        System.out.println("\nNumber of books that start with 'D': " +
                books.stream()
                    .filter(book -> book.getTitle().startsWith("D")) // filter accepts a Predicate (a function that returns a boolean)
                    .count() // count returns the number of items that are left in the stream after applying the filter (long)
        );

        // Print the Titles of the books only
        System.out.println("\nOnly titles:");
        books.stream()
                .map(book -> book.getTitle()) // map accepts a Function and returns an object transformed to what is specified in the Function
                .forEach(title -> System.out.println(title));

        // Print only the titles of romance books
        System.out.println("\nRomance books titles only:");
        books.stream()
                .filter(book -> book.getGenre() == ROMANCE)
                .map(book -> book.getTitle())
                .forEach(System.out::println);

        // Collect in an array the romance books only
        System.out.println("\nRomance books only to array list:");
        List<Book> romanceBooks = books.stream()
                .filter(book -> book.getGenre() == ROMANCE)
                .collect(Collectors.toList());
        System.out.println(romanceBooks);

        // Find out how many book genres there are
        Set<Genre> genres = books.stream()
                .map(book -> book.getGenre())
                .collect(Collectors.toSet());
        System.out.println("\nThere are " + genres.size() + " genres.");
        System.out.println("Genres: " + genres);

        // Print the length of the book titles:
        System.out.println("\nLength of book titles (approach 1):");
        books.stream()
                .map(book -> book.getTitle())
                .map(title -> title.length())
                .forEach(System.out::println);

        System.out.println("\nLength of book titles: (approach 2)");
        books.stream()
                .map(book -> book.getTitle())
                .mapToInt(String::length)
                .forEach(System.out::println);

        // Accumulate the length of the titles and print it
        System.out.println("\nLength of all titles put together: " +
                books.stream()
                        .map(book -> book.getTitle().length())
                        .reduce((base, accumulator) -> base + accumulator)
                        .get()
        );

        // Are all the books FICTION
        System.out.println("\nAre all the books FICTION?:");
        boolean onlyFiction = books.stream()
                .allMatch(book -> book.getGenre() == FICTION);
        System.out.println(onlyFiction);

        // Is any book FICTION
        System.out.println("\nIs any book FICTION?:");
        boolean anyFiction = books.stream()
                .anyMatch(book -> book.getGenre() == FICTION);
        System.out.println(anyFiction);

        // Make sure there are no SCIFI books
        System.out.println("\nAre there no SCIFI books?:");
        boolean noSciFi = books.stream()
                .noneMatch(book -> SCIFI.equals(book.getGenre()));
        System.out.println(noSciFi);
    }
}
