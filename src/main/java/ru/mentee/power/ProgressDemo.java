package ru.mentee.power;

public class ProgressDemo {

    static void main() {
        System.out.println("Текущая ветка: 'master'");
        MenteeProgress progress = new MenteeProgress
                ("Denis Sever", 2, 5);

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}
