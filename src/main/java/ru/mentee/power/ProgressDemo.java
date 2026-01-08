package ru.mentee.power;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mentee.power.devtools.progress.Mentee;
import ru.mentee.power.devtools.progress.ProgressTracker;

public class ProgressDemo {
  private static final Logger LOG = LoggerFactory.getLogger(ProgressDemo.class);

  public static void main(String[] args) {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Дмитрий", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String progress = tracker.calculateTotalProgress(mentees);
    LOG.info(progress);
  }
}
