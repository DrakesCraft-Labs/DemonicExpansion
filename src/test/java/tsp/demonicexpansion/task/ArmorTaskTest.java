package tsp.demonicexpansion.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmorTaskTest {

    @Test
    void clampsUnsafeIntervals() {
        assertEquals(5L, ArmorTask.normalizeInterval(-1L));
        assertEquals(5L, ArmorTask.normalizeInterval(1L));
        assertEquals(5L, ArmorTask.normalizeInterval(5L));
        assertEquals(20L, ArmorTask.normalizeInterval(20L));
    }
}
