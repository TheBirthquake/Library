import library.model.Book;
import library.model.Student;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем книги
        Book book1 = new Book("Преступление и наказание", "Фёдор Достоевский", 600, 1866);
        Book book2 = new Book("Война и мир", "Лев Толстой", 1225, 1869);
        Book book3 = new Book("Мастер и Маргарита", "Михаил Булгаков", 400, 1967);
        Book book4 = new Book("Евгений Онегин", "Александр Пушкин", 200, 1833);
        Book book5 = new Book("Герой нашего времени", "Михаил Лермонтов", 350, 1840);
        Book book6 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1178, 1954);
        Book book7 = new Book("Pride and Prejudice", "Jane Austen", 432, 1813);
        Book book8 = new Book("To Kill a Mockingbird", "Harper Lee", 281, 1960);
        Book book9 = new Book("1984", "George Orwell", 328, 1949);
        Book book10 = new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 432, 1997);
        Book book11 = new Book("Гарри Поттер и тайная комната", "Джоан Роулинг", 341, 1998);
        Book book12 = new Book("Анна Каренина", "Лев Толстой", 864, 1877);
        Book book13 = new Book("Собачье сердце", "Михаил Булгаков", 160, 1987);
        Book book14 = new Book("Три товарища", "Эрих Мария Ремарк", 480, 1936);
        Book book15 = new Book("Маленький принц", "Антуан де Сент-Экзюпери", 96, 1943);
        Book book16 = new Book("Шерлок Холмс", "Артур Конан Дойл", 688, 1892);
        Book book17 = new Book("The Hobbit", "J.R.R. Tolkien", 328, 1937);
        Book book18 = new Book("The Catcher in the Rye", "J.D. Salinger", 234, 1951);
        Book book19 = new Book("Божественная комедия", "Данте Алигьери", 600, 1472);
        Book book20 = new Book("Идиот", "Фёдор Достоевский", 650, 1869);
        Book book21 = new Book("Тихий Дон", "Михаил Шолохов", 800, 1928);
        Book book22 = new Book("Белая гвардия", "Михаил Булгаков", 320, 1925);
        Book book23 = new Book("Двенадцать стульев", "Илья Ильф и Евгений Петров", 400, 1928);
        Book book24 = new Book("Золотой теленок", "Илья Ильф и Евгений Петров", 480, 1931);
        Book book25 = new Book("Маленькая жизнь", "Ханья Янагихара", 832, 2015);
        Book book26 = new Book("Щегол", "Донна Тартт", 864, 2013);
        Book book27 = new Book("Норвежский лес", "Харуки Мураками", 384, 1987);
        Book book28 = new Book("Убить пересмешника", "Харпер Ли", 384, 2015);
        Book book29 = new Book("Хроники Нарнии: Лев, колдунья и платяной шкаф", "Клайв С. Льюис", 208, 1950);
        Book book30 = new Book("О дивный новый мир", "Олдос Хаксли", 311, 1932);

        // Создаем студентов и добавляем им книги
        Student student1 = new Student("Иван Иванов", Arrays.asList(book1, book2, book3, book4, book5));
        Student student2 = new Student("Петр Петров", Arrays.asList(book6, book7, book8, book9, book10));
        Student student3 = new Student("Елена Смирнова", Arrays.asList(book11, book12, book13, book14, book15));
        Student student4 = new Student("Анна Кузнецова", Arrays.asList(book16, book17, book18, book19, book20));
        Student student5 = new Student("Сергей Васильев", Arrays.asList(book21, book22, book23, book24, book25));
        Student student6 = new Student("Мария Попова", Arrays.asList(book26, book27, book28, book29, book30));
        Student student7 = new Student("Андрей Соколов", Arrays.asList(book3, book8, book13, book18, book23)); // Дубликаты книг

        // Заполняем коллекцию студентов
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);

        // Выполняем все операции со стримом без промежуточных переменных
        students.stream()
                .forEach(System.out::println); // Выводим каждого студента

        System.out.println("\nКниги, отсортированные по количеству страниц, уникальные, опубликованные после 2000, лимит 3:");
        students.stream()
                .map(Student::getBooks) // Получаем список книг каждого студента
                .flatMap(List::stream) // Преобразуем в поток книг
                .sorted() // Сортируем книги по количеству страниц
                .distinct() // Оставляем только уникальные книги
                .filter(book -> book.getPublicationYear() > 2000) // Фильтруем книги, опубликованные после 2000
                .limit(3) // Ограничиваем поток до 3 элементов
                .map(Book::getPublicationYear) // Получаем годы публикации книг
                .findFirst() // Возвращаем Optional с годом публикации первой найденной книги
                .ifPresentOrElse(
                        year -> System.out.println("Год публикации найденной книги: " + year),
                        () -> System.out.println("Книга, удовлетворяющая условиям, не найдена")
                );
    }
}