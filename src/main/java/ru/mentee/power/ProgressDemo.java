package ru.mentee.power;

import ru.mentee.power.devtools.progress.Mentee;
import ru.mentee.power.devtools.progress.ProgressTracker;

public class ProgressDemo {

    static void main() {

        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String progress = tracker.calculateTotalProgress(mentees);
        System.out.println(progress);

    }
}
