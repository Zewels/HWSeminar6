import java.util.ArrayList;
import java.util.List;

/**
 * Реализация TeacherRepository для хранения учителей в памяти.
 */
public class InMemoryTeacherRepository implements TeacherRepository {

    private List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void save(Teacher teacher) {
        teacherList.add(teacher); // Добавляем учителя в список
    }

    @Override
    public Teacher findById(Long teacherId) {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId().equals(teacherId)) {
                return teacher; // Возвращаем учителя, если найден
            }
        }
        return null; // Если не найден, возвращаем null
    }

    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teacherList); // Возвращаем копию списка всех учителей
    }
}