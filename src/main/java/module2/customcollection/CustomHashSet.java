package module2.customcollection;

import java.util.ArrayList;
import java.util.List;

// Аналог HashSet с базовыми методами insert и delete
public class CustomHashSet<T> {
    // Используем ArrayList для хранения элементов.
    // Для обеспечения уникальности будем проверять наличие перед добавлением.
    private List<T> elements;

    public CustomHashSet() {
        this.elements = new ArrayList<>();
    }

    /**
     * Вставляет элемент в множество.
     * Если элемент уже существует, он не добавляется (обеспечение уникальности).
     * @param element Элемент для вставки.
     */
    public void insert(T element) {
        // Проверяем, содержится ли элемент уже в списке.
        // Метод contains использует equals() объекта T.
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    /**
     * Удаляет элемент из множества.
     * Если элемент существует, он удаляется.
     * @param element Элемент для удаления.
     */
    public void delete(T element) {
        // Удаляем элемент из списка.
        // Метод remove использует equals() объекта T для поиска.
        elements.remove(element);
    }

    // Метод для получения размера множества (опционально, но полезно)
    public int size() {
        return elements.size();
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "CustomHashSet{" +
                "elements=" + elements +
                '}';
    }
}