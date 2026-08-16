package tsp.demonicexpansion.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTaskTest {

    @Test
    void clampsUnsafeIntervals() {
        assertEquals(10L, EntityTask.normalizeInterval(-1L));
        assertEquals(10L, EntityTask.normalizeInterval(1L));
        assertEquals(10L, EntityTask.normalizeInterval(10L));
        assertEquals(20L, EntityTask.normalizeInterval(20L));
    }
}
