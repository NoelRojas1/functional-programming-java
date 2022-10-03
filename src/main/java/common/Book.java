package common;

public class Book {
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
