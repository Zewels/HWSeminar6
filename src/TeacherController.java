import java.util.List;

/**
 * Класс TeacherController управляет взаимодействием с учителями.
 * Он вызывает методы сервиса для добавления, редактирования и получения учителей,
 * а также передает данные представлению для отображения.
 * Применены принципы SRP, OCP и DIP.
 */
public class TeacherController implements UserController<Teacher> {

    private final TeacherService teacherService; // Сервис для работы с учителями
    private final TeacherView teacherView; // Представление для вывода информации об учителях

    /**
     * Конструктор для внедрения зависимостей.
     * @param teacherService сервис для работы с учителями
     * @param teacherView представление для отображения учителей
     */
    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        if (teacherService == null || teacherView == null) {
            throw new IllegalArgumentException("Dependencies cannot be null");
        }
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    /**
     * Метод для создания нового учителя.
     * @param firstName Имя нового учителя
     * @param lastName Фамилия нового учителя
     * @param middleName Отчество нового учителя
     */
    @Override
    public void create(String firstName, String lastName, String middleName) {
        teacherService.createTeacher(firstName, lastName, middleName); // Делегируем создание учителя сервису
    }

    /**
     * Метод для редактирования данных учителя по его ID.
     * @param teacherId Идентификатор учителя, данные которого нужно редактировать
     * @param firstName Новое имя учителя
     * @param lastName Новая фамилия учителя
     * @param middleName Новое отчество учителя
     */
    public void editTeacher(Long teacherId, String firstName, String lastName, String middleName) {
        teacherService.editTeacher(teacherId, firstName, lastName, middleName); // Делегируем редактирование данных сервису
    }

    /**
     * Метод для отображения всех учителей в системе.
     */
    public void showAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers(); // Получаем список учителей через сервис
        teacherView.sendOnConsole(teachers); // Отправляем список в представление для отображения
    }
}
