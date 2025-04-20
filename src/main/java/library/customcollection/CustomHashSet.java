package library.customcollection;

import java.util.ArrayList;
import java.util.List;

public class CustomHashSet<T> {
    private List<T> elements;

    public CustomHashSet() {
        this.elements = new ArrayList<>();
    }

    /**
     * Вставляет элемент в множество, если он еще не существует.
     * @param element Элемент для вставки.
     */
    public void insert(T element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    /**
     * Удаляет элемент из множества, если он существует.
     * @param element Элемент для удаления.
     */
    public void delete(T element) {
        elements.remove(element);
    }

    @Override
    public String toString() {
        return "CustomHashSet{" +
                "elements=" + elements +
                '}';
    }
}