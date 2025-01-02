import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Класс StudentGroupService отвечает за работу с группой студентов.
 * Применяются принципы S.O.L.I.D. для улучшения структуры.
 */
public class StudentGroupService {

    private final StudentGroup studentGroup; // Группа студентов
    private final StudentRemovalService studentRemovalService; // Сервис для удаления студентов
    private final StudentSortingService studentSortingService; // Сервис для сортировки студентов

    /**
     * Конструктор, принимающий сервисы для удаления и сортировки студентов.
     * Это позволяет использовать зависимость от абстракции (DIP).
     *
     * @param studentGroup группа студентов
     * @param studentRemovalService сервис для удаления студентов
     * @param studentSortingService сервис для сортировки студентов
     */
    public StudentGroupService(StudentGroup studentGroup,
                               StudentRemovalService studentRemovalService,
                               StudentSortingService studentSortingService) {
        this.studentGroup = studentGroup;
        this.studentRemovalService = studentRemovalService;
        this.studentSortingService = studentSortingService;
    }

    /**
     * Метод для удаления студента из группы по полному имени.
     * Применяет принцип SRP, так как удаление студентов вынесено в отдельный сервис.
     *
     * @param firstName Имя студента
     * @param lastName Фамилия студента
     * @param middleName Отчество студента
     */
    public void removeStudentByFIO(String firstName, String lastName, String middleName) {
        studentRemovalService.removeStudent(studentGroup, firstName, lastName, middleName);
    }

    /**
     * Метод для получения отсортированного списка студентов по идентификатору.
     * Сортировка теперь происходит через отдельный сервис, что соответствует принципу SRP и OCP.
     *
     * @return отсортированный список студентов по идентификатору
     */
    public List<Student> getSortedStudentList() {
        return studentSortingService.sortById(studentGroup);
    }

    /**
     * Метод для получения отсортированного списка студентов по ФИО.
     * Этот метод теперь использует отдельный сервис для сортировки по ФИО.
     *
     * @return отсортированный список студентов по ФИО
     */
    public List<Student> getSortedStudentByFIO() {
        return studentSortingService.sortByFIO(studentGroup);
    }

    /**
     * Метод для создания нового студента и добавления его в группу.
     *
     * @param firstName Имя студента
     * @param lastName Фамилия студента
     * @param middleName Отчество студента
     */
    public void createStudent(String firstName, String lastName, String middleName) {
        studentGroup.createStudent(firstName, lastName, middleName);
    }
}
