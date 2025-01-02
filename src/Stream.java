import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс Stream представляет поток студентов и соответствует принципам S.O.L.I.D.
 */
public class Stream implements Iterable<StudentGroup> {

    // Список учебных групп в потоке (принцип инкапсуляции для SRP)
    private final List<StudentGroup> studentGroups;

    /**
     * Конструктор инициализирует список учебных групп.
     * Соответствует принципу SRP (Single Responsibility Principle), так как отвечает только за создание объекта.
     */
    public Stream() {
        this.studentGroups = new ArrayList<>();
    }

    /**
     * Метод для получения списка учебных групп (открытие доступа через интерфейс вместо прямого доступа).
     * Соответствует принципу OCP (Open/Closed Principle), так как добавление новых операций не изменяет внутреннюю структуру.
     * @return неизменяемый список учебных групп
     */
    public List<StudentGroup> getStudentGroups() {
        return new ArrayList<>(studentGroups);
    }

    /**
     * Метод для добавления учебной группы в поток.
     * Соответствует принципу SRP, так как выполняет одну задачу.
     * @param studentGroup учебная группа для добавления
     */
    public void addStudentGroup(StudentGroup studentGroup) {
        if (studentGroup == null) {
            throw new IllegalArgumentException("Student group cannot be null"); // Принцип LSP (Liskov Substitution Principle): корректная проверка аргументов
        }
        this.studentGroups.add(studentGroup);
    }

    /**
     * Реализация итератора из интерфейса Iterable.
     * Соответствует принципу ISP (Interface Segregation Principle), так как реализует интерфейс с конкретной обязанностью.
     * @return итератор для списка учебных групп
     */
    @Override
    public Iterator<StudentGroup> iterator() {
        return studentGroups.iterator();
    }

    /**
     * Метод для получения количества учебных групп в потоке.
     * @return количество учебных групп
     */
    public int getGroupCount() {
        return studentGroups.size();
    }
}
