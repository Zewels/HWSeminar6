import java.util.Comparator;

// Класс UserComparator реализует Comparator для сравнения объектов типа User (и его наследников).
public class UserComparator<T extends User> implements Comparator<T> {

    /**
     * Метод для сравнения двух объектов User (или его наследников) по имени, фамилии и отчеству.
     * Сравнение происходит по следующим правилам: сначала имя, затем фамилия, и в последнюю очередь отчество.
     *
     * @param o1 первый объект для сравнения
     * @param o2 второй объект для сравнения
     * @return отрицательное число, если o1 меньше o2, положительное число, если больше, и 0, если равны
     */
    @Override
    public int compare(T o1, T o2) {
        // Сначала сравниваем имена
        int resultOfComparing = o1.getFirstName().compareTo(o2.getFirstName());

        // Если имена одинаковые, сравниваем фамилии
        if (resultOfComparing == 0) {
            resultOfComparing = o1.getLastName().compareTo(o2.getLastName());

            // Если и фамилии одинаковые, сравниваем отчества
            if (resultOfComparing == 0) {
                return o1.getMiddleName().compareTo(o2.getMiddleName());
            } else {
                // Возвращаем результат сравнения фамилий
                return resultOfComparing;
            }
        } else {
            // Возвращаем результат сравнения имен
            return resultOfComparing;
        }
    }
}
