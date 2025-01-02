import java.util.Objects;

public class User {

    // Имя пользователя
    private String firstName;

    // Фамилия пользователя
    private String lastName;

    // Отчество пользователя
    private String middleName;

    /**
     * Конструктор класса User для создания объекта с ФИО.
     * @param firstName Имя пользователя
     * @param lastName Фамилия пользователя
     * @param middleName Отчество пользователя
     */
    public User(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    // Геттеры и сеттеры для всех полей
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Переопределение метода toString для удобного вывода информации об объекте.
     * Используется для вывода данных о пользователе в логах, консоли и т.д.
     * @return строковое представление объекта User
     */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

    /**
     * Переопределение метода equals для сравнения объектов User по их значению (ФИО).
     * Это позволяет сравнивать объекты User по содержимому их полей, а не по ссылке.
     * @param o объект для сравнения
     * @return true, если объекты равны по содержимому, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверяем, являются ли объекты идентичными
        if (o == null || getClass() != o.getClass()) return false; // Проверка типа объекта
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(middleName, user.middleName);
    }

    /**
     * Переопределение метода hashCode для корректного использования объекта User в коллекциях,
     * таких как HashSet или HashMap, которые используют хеширование.
     * @return хеш-код объекта User
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName); // Генерация хеш-кода на основе значений полей
    }
}