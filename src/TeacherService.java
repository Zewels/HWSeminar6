import java.util.ArrayList;
import java.util.List;

/**
 * Класс TeacherService предоставляет логику для работы с учителями.
 * Сюда входят методы для добавления, редактирования и получения списка учителей.
 */
public class TeacherService {

    private List<Teacher> teacherList = new ArrayList<>(); // Список учителей

    /**
     * Метод для добавления нового учителя в список.
     * @param firstName Имя нового учителя
     * @param lastName Фамилия нового учителя
     * @param middleName Отчество нового учителя
     */
    public void createTeacher(String firstName, String lastName, String middleName) {
        // Убедитесь, что вызываемый конструктор Teacher правильно определен
        Teacher teacher = new Teacher(firstName, lastName, middleName); // 3 параметра для конструктора Teacher
        teacher.setTeacherId((long) (teacherList.size() + 1)); // Устанавливаем уникальный ID
        teacherList.add(teacher); // Добавляем учителя в список
    }

    /**
     * Метод для редактирования информации о существующем учителе по его ID.
     * @param teacherId Идентификатор учителя
     * @param firstName Новое имя учителя
     * @param lastName Новая фамилия учителя
     * @param middleName Новое отчество учителя
     */
    public void editTeacher(Long teacherId, String firstName, String lastName, String middleName) {
        // Ищем учителя по ID
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId().equals(teacherId)) {
                // Если учитель найден, обновляем его данные
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setMiddleName(middleName);
                return; // Завершаем метод после обновления
            }
        }
    }

    /**
     * Метод для получения списка всех учителей.
     * @return Список учителей
     */
    public List<Teacher> getAllTeachers() {
        return teacherList; // Возвращаем список учителей
    }
}
