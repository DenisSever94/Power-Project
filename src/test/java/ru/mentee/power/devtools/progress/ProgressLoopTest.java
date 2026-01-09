package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing ProgressTracking")
class ProgressLoopTest {

  @Test
  @DisplayName("Должен корректно вычислять суммарный прогресс когда передан массив mentee")
  void shouldCalculateTotalProgressWhenMultiplaneMentee() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);
    assertThat(result).contains("Суммарно пройдено: 25 из 36").contains("Осталось: 11");
  }

  @Test
  @DisplayName("Должен корректно обработать массив когда все mentee завершили курс")
  void shouldCalculateProgressWhenAllMenteesCompleted() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 12, 12),
        new Mentee("Мария", "СПб", "Fullstack", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);
    assertThat(result).contains("Суммарно пройдено: 24 из 24").contains("Осталось: 0");
  }

  @Test
  @DisplayName("Должен корректно обработать массив когда все mentee не завершили курс")
  void shouldHandleIncompleteCourseProgress() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 0, 12),
        new Mentee("Мария", "СПб", "Fullstack", 0, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);
    assertThat(result).contains("Суммарно пройдено: 0 из 24").contains("Осталось: 24");
  }

  @Test
  @DisplayName("Должен выбрасывать исключение при null")
  void shouldThrowExceptionOnNull() {
    ProgressTracker tracker = new ProgressTracker();

    assertThatThrownBy(() -> tracker.calculateTotalProgress(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Массив не должен быть null или = 0");
  }

  @Test
  @DisplayName("Должен выбросить исключение при пустом массиве")
  void shouldThrowExceptionOnEmptyArray() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] emptyMentees = {};

    assertThatThrownBy(() -> tracker.calculateTotalProgress(emptyMentees))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Массив не должен быть null или = 0");
  }
}
