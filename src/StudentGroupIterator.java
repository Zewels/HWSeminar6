import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Класс StudentGroupIterator реализует интерфейс Iterator для итерации по списку студентов.
public class StudentGroupIterator implements Iterator<Student> {

    private int count; // Текущий индекс в списке
    private final List<Student> studentList; // Список студентов для итерации

    /**
     * Конструктор, принимающий объект StudentGroup.
     * Соответствует принципу SRP (Single Responsibility Principle), так как конструктор только инициализирует итератор.
     * @param studentGroup группа студентов, по которой будем итерироваться
     */
    public StudentGroupIterator(StudentGroup studentGroup) {
        this.studentList = studentGroup.getStudentList();
        this.count = 0; // Начальный индекс
    }

    /**
     * Проверяет, есть ли следующий элемент в списке студентов.
     * Соответствует принципу SRP, так как метод выполняет только одну задачу — проверку на наличие следующего элемента.
     * @return true, если есть следующий элемент, иначе false
     */
    @Override
    public boolean hasNext() {
        return count < studentList.size(); // Проверяем, есть ли ещё студенты в списке
    }

    /**
     * Возвращает следующий элемент в списке студентов.
     * Соответствует принципу SRP: метод решает только одну задачу — возвращение следующего элемента.
     * @return следующий объект Student
     * @throws NoSuchElementException если больше нет элементов
     */
    @Override
    public Student next() {
        if (!hasNext()) { // Проверяем, есть ли следующий элемент
            throw new NoSuchElementException("No more students in the list."); // Бросаем исключение, если элементов больше нет
        }
        return studentList.get(count++); // Возвращаем текущий элемент и увеличиваем индекс
    }

    /**
     * Удаляет текущего студента из списка.
     * Соответствует принципу LSP (Liskov Substitution Principle), так как корректно работает с любыми итераторами для списков студентов.
     * @throws IllegalStateException если remove вызывается до next
     */
    @Override
    public void remove() {
        if (count <= 0) {
            throw new IllegalStateException("Cannot remove student before calling next."); // Обрабатываем исключение для некорректных вызовов
        }
        studentList.remove(--count); // Уменьшаем индекс перед удалением
    }
}
