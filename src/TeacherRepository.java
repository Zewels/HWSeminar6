import java.util.List;

/**
 * Интерфейс TeacherRepository абстрагирует работу с хранилищем учителей.
 */
public interface TeacherRepository {
    void save(Teacher teacher);
    Teacher findById(Long teacherId);
    List<Teacher> findAll();
}