package ru.mentee.power;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenteeProgressTest {

    @Test
    void shouldFormatSummary_whenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Alex", 1, 8);
        String result = progress.summary();
        Assertions.assertThat(result).isEqualTo("Sprint 1 -> Alex: planned 8 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Alex", 1, 4);
        Assertions.assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Alex", 1, 2);
        Assertions.assertThat(progress.readyForSprint()).isFalse();
    }
}
