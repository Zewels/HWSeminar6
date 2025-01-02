import java.util.List;

/**
 * Класс StudentView реализует интерфейс UserView для отображения информации о студентах.
 * Этот класс отвечает за вывод списка студентов на консоль.
 * Применяется принцип OCP (открыто для расширения) и SRP (одна ответственность).
 */
public class StudentView implements UserView<Student> {

    private final OutputStrategy outputStrategy;

    /**
     * Конструктор StudentView.
     * @param outputStrategy стратегия вывода информации.
     */
    public StudentView(OutputStrategy outputStrategy) {
        if (outputStrategy == null) {
            throw new IllegalArgumentException("OutputStrategy cannot be null");
        }
        this.outputStrategy = outputStrategy;
    }

    /**
     * Метод для вывода списка студентов на консоль.
     * Этот метод теперь использует стратегию вывода, что позволяет расширять функциональность.
     *
     * @param list Список студентов, который нужно вывести.
     */
    @Override
    public void sendOnConsole(List<Student> list) {
        for (Student student : list) {
            outputStrategy.print(student); // Выводим студента с помощью выбранной стратегии
        }
    }
}
