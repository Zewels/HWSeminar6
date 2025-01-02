import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Класс StreamService предоставляет методы для работы с потоками студентов.
 */
public class StreamService {

    private final Comparator<Stream> comparator;

    /**
     * Конструктор StreamService, принимающий компаратор для сортировки.
     * Соответствует принципу DIP (Dependency Inversion Principle): зависит от абстракции (интерфейса Comparator), а не конкретной реализации.
     * @param comparator компаратор для сравнения потоков
     */
    public StreamService(Comparator<Stream> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null"); // Принцип LSP (корректная проверка аргументов)
        }
        this.comparator = comparator;
    }

    /**
     * Метод для сортировки списка потоков с использованием переданного компаратора.
     * Соответствует принципам OCP (открыт для расширения) и SRP (выполняет одну задачу).
     * @param streams список потоков для сортировки
     */
    public void sortStreams(List<Stream> streams) {
        if (streams == null) {
            throw new IllegalArgumentException("Streams list cannot be null");
        }
        Collections.sort(streams, comparator); // Сортировка потоков по предоставленному компаратору
    }
}
