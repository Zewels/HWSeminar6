import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSortingService {

    /**
     * Сортировка студентов по их идентификатору.
     * Применяется принцип SRP, так как метод занимается только сортировкой по ID.
     *
     * @param studentGroup группа студентов
     * @return отсортированный список студентов
     */
    public List<Student> sortById(StudentGroup studentGroup) {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        Collections.sort(studentList);
        return studentList;
    }

    /**
     * Сортировка студентов по их полному имени (ФИО).
     * Применяется принцип SRP, так как метод занимается только сортировкой по ФИО.
     *
     * @param studentGroup группа студентов
     * @return отсортированный список студентов
     */
    public List<Student> sortByFIO(StudentGroup studentGroup) {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        studentList.sort(new UserComparator<>());
        return studentList;
    }
}
