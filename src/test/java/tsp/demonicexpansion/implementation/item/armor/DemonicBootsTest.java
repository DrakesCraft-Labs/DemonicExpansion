package tsp.demonicexpansion.implementation.item.armor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemonicBootsTest {

    @Test
    void clampsUnsafeRadii() {
        assertEquals(1, DemonicBoots.normalizeRadius(-1));
        assertEquals(1, DemonicBoots.normalizeRadius(1));
        assertEquals(2, DemonicBoots.normalizeRadius(2));
        assertEquals(8, DemonicBoots.normalizeRadius(8));
        assertEquals(8, DemonicBoots.normalizeRadius(100));
    }
}
