import java.util.List;

/**
 * Контроллер StudentController отвечает за взаимодействие между внешним интерфейсом и логикой приложения.
 */
public class StudentController implements UserController<Student> {

    private final StudentGroupService studentGroupService;
    private final StreamService streamService;
    private final StudentView studentView;

    /**
     * Конструктор StudentController.
     * Соответствует принципу DIP (Dependency Inversion Principle): зависит от абстракций, а не от конкретных реализаций.
     * @param studentGroupService сервис для работы с группами студентов
     * @param streamService сервис для работы с потоками
     * @param studentView представление для отображения информации о студентах
     */
    public StudentController(StudentGroupService studentGroupService, StreamService streamService, StudentView studentView) {
        if (studentGroupService == null || streamService == null || studentView == null) {
            throw new IllegalArgumentException("Dependencies cannot be null");
        }
        this.studentGroupService = studentGroupService;
        this.streamService = streamService;
        this.studentView = studentView;
    }

    /**
     * Удаляет студента из группы по его полному имени.
     * @param firstName Имя студента
     * @param lastName Фамилия студента
     * @param middleName Отчество студента
     */
    public void removeStudentByFIO(String firstName, String lastName, String middleName) {
        studentGroupService.removeStudentByFIO(firstName, lastName, middleName);
    }

    /**
     * Получает список студентов, отсортированный по определённым критериям.
     * Список выводится в консоль через объект studentView.
     * @return отсортированный список студентов
     */
    public List<Student> getSortedStudentList() {
        List<Student> studentList = studentGroupService.getSortedStudentList();
        studentView.sendOnConsole(studentList);
        return studentList;
    }

    /**
     * Получает список студентов, отсортированный по их полному имени (ФИО).
     * @return список студентов, отсортированный по ФИО
     */
    public List<Student> getSortedStudentByFIO() {
        List<Student> studentList = studentGroupService.getSortedStudentByFIO();
        studentView.sendOnConsole(studentList);
        return studentList;
    }

    /**
     * Метод для сортировки списка потоков.
     * @param streams список потоков, который нужно отсортировать
     */
    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }

    /**
     * Создаёт нового студента с указанным именем, фамилией и отчеством.
     * @param firstName Имя студента
     * @param lastName Фамилия студента
     * @param middleName Отчество студента
     */
    @Override
    public void create(String firstName, String lastName, String middleName) {
        studentGroupService.createStudent(firstName, lastName, middleName);
    }
}
