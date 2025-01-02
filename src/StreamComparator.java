import java.util.Comparator;

/**
 * Класс StreamComparator реализует интерфейс Comparator для сравнения количества учебных групп в потоках.
 * Соответствует принципам S.O.L.I.D., обеспечивая модульность и повторное использование.
 */
public class StreamComparator implements Comparator<Stream> {

    /**
     * Метод сравнения потоков по количеству учебных групп.
     * Соответствует принципу SRP (Single Responsibility Principle):
     * отвечает только за определение порядка потоков.
     * @param o1 первый поток
     * @param o2 второй поток
     * @return отрицательное число, если o1 меньше o2, положительное, если больше, и 0, если равны
     */
    @Override
    public int compare(Stream o1, Stream o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Streams to compare cannot be null"); // Принцип LSP (Liskov Substitution Principle): корректная обработка аргументов
        }
        return Integer.compare(o1.getGroupCount(), o2.getGroupCount()); // Сравниваем количество групп
    }
}
