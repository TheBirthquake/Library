package library.data;

import library.model.Book;
import library.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Класс для предоставления данных о студентах
public class StudentData {

    /**
     * Создает и возвращает список предопределенных объектов Student.
     * Использует данные из BookData для назначения книг студентам.
     * @return Список объектов Student.
     */
    public static List<Student> getAllStudents() {
        // Получаем список всех доступных книг из BookData
        List<Book> allBooks = BookData.getAllBooks();

        // Создаем студентов и назначаем им книги из списка allBooks
        // Убедимся, что каждый студент получает как минимум 5 книг
        // и что книги могут повторяться у разных студентов (один и тот же экземпляр Book),
        // но список allBooks содержит уникальные экземпляры.
        Student student1 = new Student("Иван Иванов", new ArrayList<>(allBooks.subList(0, 5)));
        Student student2 = new Student("Петр Петров", new ArrayList<>(allBooks.subList(5, 10)));
        Student student3 = new Student("Елена Смирнова", new ArrayList<>(allBooks.subList(10, 15)));
        Student student4 = new Student("Анна Кузнецова", new ArrayList<>(allBooks.subList(15, 20)));
        Student student5 = new Student("Сергей Васильев", new ArrayList<>(allBooks.subList(20, 25)));
        Student student6 = new Student("Мария Попова", new ArrayList<>(allBooks.subList(25, 30)));
        // Студент с некоторыми повторяющимися книгами (экземплярами из allBooks) для демонстрации distinct()
        Student student7 = new Student("Андрей Соколов", Arrays.asList(allBooks.get(2), allBooks.get(7), allBooks.get(12), allBooks.get(17), allBooks.get(22), allBooks.get(2))); // Добавлена повторяющаяся книга

        // Возвращаем список всех студентов
        return Arrays.asList(student1, student2, student3, student4, student5, student6, student7);
    }
}
