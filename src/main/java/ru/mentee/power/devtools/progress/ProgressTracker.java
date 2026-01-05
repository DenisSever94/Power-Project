package ru.mentee.power.devtools.progress;

public class ProgressTracker {

    /**
     * Вычисляет суммарный прогресс группы
     *
     * @param mentees array mentee
     * @return Строка о суммарном прогрессе (пройдено/осталось уроков)
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        if (mentees == null || mentees.length == 0) {
            throw new ArithmeticException("Array not must be null or = 0");
        }

        int totalCompleted = 0;
        int totalTotal = 0;
        int index = 0;
        int totalRemaining = 0;
        while (index < mentees.length) {
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
            totalRemaining = totalTotal - totalCompleted;

        }
        return "Суммарно пройдено: " + totalCompleted + " из " + totalTotal +
                " Осталось: " + totalRemaining;
    }
}
