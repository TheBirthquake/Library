package library.model;

import java.util.Objects;

// Класс, представляющий книгу
public class Book implements Comparable<Book> {
    private String title; // Название книги
    private String author; // Автор книги
    private int numberOfPages; // Количество страниц
    private int publicationYear; // Год публикации

    // Конструктор
    public Book(String title, String author, int numberOfPages, int publicationYear) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publicationYear = publicationYear;
    }

    // Геттеры
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

    // Реализация compareTo для сортировки по количеству страниц
    @Override
    public int compareTo(Book other) {
        // Сравниваем количество страниц текущей книги с другой книгой
        return Integer.compare(this.numberOfPages, other.numberOfPages);
    }

    // Переопределение equals и hashCode для корректной работы distinct()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        // Книги считаются равными, если совпадают название и автор
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    // Переопределение toString для удобного вывода в консоль
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