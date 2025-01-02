/**
 * Класс ConsoleOutputStrategy реализует стратегию вывода на консоль.
 * Применяется принцип DIP, так как мы используем абстракцию для вывода.
 */
public class ConsoleOutputStrategy implements OutputStrategy {

    /**
     * Метод для вывода информации о студенте на консоль.
     * Выводит уникальный идентификатор и ФИО студента.
     *
     * @param student студент, информацию о котором нужно вывести.
     */
    @Override
    public void print(Student student) {
        System.out.println("Student ID: " + student.getStudentId() +
                ", Name: " + student.getFirstName() + " " + student.getLastName() + " " + student.getMiddleName());
    }
}
