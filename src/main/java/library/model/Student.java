package library.model;

import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{name='").append(name).append("', books=[");
        for (int i = 0; i < books.size(); i++) {
            sb.append(books.get(i).getTitle());
            if (i < books.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}