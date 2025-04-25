package module2;

import module2.model.Book;
import module2.model.Student;
import module2.data.StudentData;

import java.util.List;
import java.util.Optional; // Импортируем Optional


public class Main {
    public static void main(String[] args) {
        // Получаем список всех студентов из StudentData
        List<Student> students = StudentData.getAllStudents(); // Теперь студенты создаются в StudentData

        // Выполняем все операции со стримом без промежуточных переменных
        System.out.println("Список всех студентов:");
        students.stream()
                .forEach(System.out::println); // Выводим каждого студента

        System.out.println("\nРезультат потоковой обработки книг:");

        // Цепочка потоковых операций согласно заданию:
        Optional<Integer> publicationYearOptional = students.stream()
                .map(Student::getBooks) // Получаем для каждого студента список книг
                .flatMap(List::stream) // Получаем книги (Преобразуем поток списков книг в поток книг)
                .sorted() // Сортируем книги по количеству страниц (использует compareTo из Book)
                .distinct() // Оставляем только уникальные книги (использует equals и hashCode из Book)
                .filter(book -> book.getPublicationYear() > 2000) // Фильтруем книги, опубликованные после 2000 года
                .limit(3) // Ограничиваем стрим на 3 элементах
                .map(Book::getPublicationYear) // Получаем из книг годы выпуска
                .findFirst(); // При помощи методов короткого замыкания возвращаем Optional от года выпуска первой найденной книги

        // При помощи методов получения значения из Optional выводим результат
        publicationYearOptional.ifPresentOrElse(
                year -> System.out.println("Год публикации найденной книги (после всех фильтров и сортировки): " + year),
                () -> System.out.println("Книга, удовлетворяющая условиям, не найдена.")
        );


    }
}
