import java.util.List;

/**
 * Класс TeacherView реализует интерфейс UserView и отвечает за отображение информации об учителях на консоли.
 * Метод sendOnConsole выводит список учителей в консоль.
 */
public class TeacherView implements UserView<Teacher> {

    /**
     * Метод для вывода списка учителей на консоль.
     * Каждый учитель отображается с его уникальным идентификатором и ФИО.
     * @param list Список учителей для отображения
     */
    @Override
    public void sendOnConsole(List<Teacher> list) {
        // Проверка на пустой или null список
        if (list == null || list.isEmpty()) {
            System.out.println("Список учителей пуст или не инициализирован.");
            return;
        }

        // Иначе выводим информацию о каждом учителе
        System.out.println("Список учителей:");
        for (Teacher teacher : list) {
            if (teacher != null) {
                System.out.printf("ID: %d, Имя: %s %s %s%n",
                        teacher.getTeacherId(), // Уникальный идентификатор учителя
                        teacher.getFirstName(),  // Имя учителя
                        teacher.getLastName(),   // Фамилия учителя
                        teacher.getMiddleName()); // Отчество учителя
            } else {
                System.out.println("Некорректный объект Teacher в списке.");
            }
        }
    }
}
