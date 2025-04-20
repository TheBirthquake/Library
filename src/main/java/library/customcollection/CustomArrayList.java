package library.customcollection;

import java.util.Arrays;
import java.util.Collection;

public class CustomArrayList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Увеличивает емкость списка, если необходимо.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Добавляет элемент в конец списка.
     * @param element Элемент для добавления.
     */
    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * Возвращает элемент по указанному индексу.
     * @param index Индекс элемента.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * @param index Индекс элемента для удаления.
     * @return Удаленный элемент.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона.
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Для сборки мусора
        return removedElement;
    }

    /**
     * Добавляет все элементы из указанной коллекции в конец списка.
     * @param c Коллекция, содержащая элементы для добавления.
     */
    public void addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}