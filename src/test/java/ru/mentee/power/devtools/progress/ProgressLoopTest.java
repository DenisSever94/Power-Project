package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Testing ProgressTracking")
public class ProgressLoopTest {

    @Test
    @DisplayName("Должен корректно вычислять суммарный прогресс когда передан массив mentee")
    void shouldCalculateTotalProgress_whenMultiplaneMentee() {
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
    @DisplayName("Должен корректно обработать массик когда все mentee завершили курс")
    void shouldCalculateProgress_whenAllMenteesCompleted() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 12, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);
        assertThat(result).contains("Суммарно пройдено: 24 из 24").contains("Осталось: 0");

    }
}
