package library.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int numberOfPages;
    private int publicationYear;

    public Book(String title, String author, int numberOfPages, int publicationYear) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.numberOfPages, other.numberOfPages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", publicationYear=" + publicationYear +
                '}';
    }
}