package library.model;

import java.util.List;

// Класс, представляющий студента
public class Student {
    private String name; // Имя студента
    private List<Book> books; // Список книг у студента

    // Конструктор
    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    // Переопределение toString для удобного вывода информации о студенте
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{name='").append(name).append("', books=[");
        for (int i = 0; i < books.size(); i++) {
            // Выводим только названия книг для краткости в представлении студента
            sb.append(books.get(i).getTitle());
            if (i < books.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}