/**
 * Класс Teacher представляет учителя и наследует функциональность от класса User.
 * Он содержит уникальный идентификатор для каждого учителя.
 * Применяется принцип SRP (Single Responsibility Principle) и DIP (Dependency Inversion Principle).
 */
public class Teacher extends User {

    private Long teacherId; // Уникальный идентификатор учителя


    /**
     * Конструктор для создания нового учителя с указанными ФИО.
     * Применяется принцип DIP (зависимость от абстракции).
     *
     * @param firstName  Имя учителя
     * @param lastName   Фамилия учителя
     * @param middleName Отчество учителя
     */
    public Teacher(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName); // Вызов конструктора родительского класса
        this.teacherId = teacherId;
    }

    // Геттеры и сеттеры...

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
