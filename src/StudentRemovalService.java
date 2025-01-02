import java.util.Iterator;

public class StudentRemovalService {

    /**
     * Удаляет студента по имени из группы.
     * Этот сервис отвечает только за удаление, что соответствует принципу SRP.
     *
     * @param studentGroup группа студентов
     * @param firstName имя студента
     * @param lastName фамилия студента
     * @param middleName отчество студента
     */
    public void removeStudent(StudentGroup studentGroup, String firstName, String lastName, String middleName) {
        Iterator<Student> iterator = studentGroup.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName) &&
                    student.getMiddleName().equals(middleName)) {
                iterator.remove();
                return;
            }
        }
    }
}
