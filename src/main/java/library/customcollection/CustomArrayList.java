package library.customcollection;

import java.util.Arrays;
import java.util.Collection;

// Аналог ArrayList с базовыми методами add, get, remove, addAll
public class CustomArrayList<T> {
    // Внутренний массив для хранения элементов
    private Object[] elements;
    // Текущее количество элементов в списке
    private int size;
    // Начальная емкость массива по умолчанию
    private static final int DEFAULT_CAPACITY = 10;

    // Конструктор по умолчанию
    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Увеличивает емкость внутреннего массива, если текущая емкость недостаточна.
     * @param minCapacity Минимальная требуемая емкость.
     */
    private void ensureCapacity(int minCapacity) {
        // Если требуемая емкость больше текущей
        if (minCapacity > elements.length) {
            // Рассчитываем новую емкость (обычно удваиваем текущую, но не меньше требуемой)
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            // Копируем элементы в новый массив с увеличенной емкостью
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Добавляет элемент в конец списка.
     * При необходимости увеличивает емкость массива.
     * @param element Элемент для добавления.
     */
    public void add(T element) {
        // Убеждаемся, что есть место для нового элемента
        ensureCapacity(size + 1);
        // Добавляем элемент и увеличиваем размер
        elements[size++] = element;
    }

    /**
     * Возвращает элемент по указанному индексу.
     * @param index Индекс элемента.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона (меньше 0 или больше или равен size).
     */
    @SuppressWarnings("unchecked") // Подавление предупреждения о небезопасном приведении типов
    public T get(int index) {
        // Проверяем, что индекс находится в допустимом диапазоне
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        // Возвращаем элемент по индексу, приводя его к типу T
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Элементы, следующие за удаленным, сдвигаются влево.
     * @param index Индекс элемента для удаления.
     * @return Удаленный элемент.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона.
     */
    @SuppressWarnings("unchecked") // Подавление предупреждения о небезопасном приведении типов
    public T remove(int index) {
        // Проверяем, что индекс находится в допустимом диапазоне
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        // Сохраняем удаляемый элемент для возврата
        T removedElement = (T) elements[index];
        // Вычисляем количество элементов для сдвига
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Сдвигаем элементы влево
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        // Уменьшаем размер и обнуляем последний элемент для сборки мусора
        elements[--size] = null;
        // Возвращаем удаленный элемент
        return removedElement;
    }

    /**
     * Добавляет все элементы из указанной коллекции в конец списка.
     * @param c Коллекция, содержащая элементы для добавления.
     */
    public void addAll(Collection<? extends T> c) {
        // Преобразуем коллекцию в массив
        Object[] a = c.toArray();
        // Количество добавляемых элементов
        int numNew = a.length;
        // Убеждаемся, что есть место для всех новых элементов
        ensureCapacity(size + numNew);
        // Копируем элементы из массива коллекции в конец нашего внутреннего массива
        System.arraycopy(a, 0, elements, size, numNew);
        // Увеличиваем размер списка
        size += numNew;
    }

    // Метод для получения текущего размера списка
    public int size() {
        return size;
    }

    // Переопределение toString для удобного вывода
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