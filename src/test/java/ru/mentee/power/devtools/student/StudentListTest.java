package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing class StudentList")
class StudentListTest {

  @Test
  @DisplayName("Должен корректно добавлять студента в список")
  void shouldAddStudentToList() {
    Student ivan = new Student("Иванов Иван", "Москва");
    StudentList students = new StudentList();

    students.addStudent(ivan);

    List<Student> studentFromMoscow = students.findStudentsByCity("Москва");
    assertThat(studentFromMoscow)
        .hasSize(1)
        .containsExactly(ivan);
  }

  @Test
  @DisplayName("Добавление name null and city null в коллекцию")
  void shouldAddStudentWithNullFields() {
    StudentList student = new StudentList();
    Student studentWithNulls = new Student(null, null);

    student.addStudent(studentWithNulls);

    assertNotNull(student, "Объект студента не должен быть null");
  }

  @Test
  @DisplayName("Добавление null в коллекцию")
  void shouldAddStudentWithNameNull() {

    StudentList students = new StudentList();

    students.addStudent(null);

    assertThat(students.findStudentsByCity("Любой город")).isEmpty();
  }

  @Test
  @DisplayName("Должен вернуть студента по имени")
  void shouldReturnStudentFromSpecificName() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Иван", "Москва"));
    students.addStudent(new Student("Мария", "Казань"));

    List<Student> found = students.findStudentByName("Мария");

    assertThat(found)
        .hasSize(1)
        .extracting(Student::name)
        .containsExactlyInAnyOrder("Мария");
  }

  @Test
  @DisplayName("Должен вернуть null если студента с указанным именем не существует")
  void shouldReturnsNullWhenStudentNameNotFound() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Иван", "Москва"));

    List<Student> notFound = students.findStudentByName("Несуществующий");

    assertThat(notFound).isNotNull();
  }

  @Test
  @DisplayName("Должен вернуть студента по городу")
  void shouldReturnStudentFromSpecificCity() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Иван", "Москва"));

    List<Student> found = students.findStudentsByCity("Москва");

    assertThat(found)
        .hasSize(1)
        .extracting(Student::city)
        .containsExactlyInAnyOrder("Москва");
  }

  @Test
  @DisplayName("Должен вернуть null если студента с указанным городом не существует")
  void shouldReturnsNullWhenStudentCityNotFound() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Иван", "Москва"));

    List<Student> notFound = students.findStudentsByCity("Несуществующий");

    assertThat(notFound).isNotNull();
  }

  @Test
  @DisplayName("Должен возвращать студентов только из указанного города")
  void shouldReturnStudentsFromSpecificCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Иван", "Москва"));
    list.addStudent(new Student("Иван", "Пермь"));
    list.addStudent(new Student("Дмитрий", "Москва"));

    List<Student> result = list.findStudentsByCity("Москва");

    assertThat(result)
        .hasSize(2)
        .extracting(Student::name)
        .containsExactlyInAnyOrder("Иван", "Дмитрий");
  }

  @Test
  @DisplayName("Добавить студента в список")
  void shouldAddStudentInList() {
    Student student = new Student("Иван", "Москва");
    List<Student> studentList = new ArrayList<>();
    studentList.add(student);

    assertEquals(1, studentList.size());
    assertTrue(studentList.contains(student));
    assertSame(student, studentList.getFirst());
  }
}