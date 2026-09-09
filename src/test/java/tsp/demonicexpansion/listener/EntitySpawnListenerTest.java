package tsp.demonicexpansion.listener;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EntitySpawnListenerTest {

    @Test
    void onlyNaturalCreaturesCanBeReplaced() {
        assertTrue(EntitySpawnListener.isEligibleReplacementSpawn(CreatureSpawnEvent.SpawnReason.NATURAL));
        assertFalse(EntitySpawnListener.isEligibleReplacementSpawn(CreatureSpawnEvent.SpawnReason.CUSTOM));
        assertFalse(EntitySpawnListener.isEligibleReplacementSpawn(CreatureSpawnEvent.SpawnReason.SLIME_SPLIT));
        assertFalse(EntitySpawnListener.isEligibleReplacementSpawn(CreatureSpawnEvent.SpawnReason.TRIAL_SPAWNER));
    }

    @Test
    void legacyVulcanSignatureRequiresVisibleExactName() {
        assertTrue(EntitySpawnListener.isLegacyVulcanName("\u00a7cVulcan", true));
        assertTrue(EntitySpawnListener.isLegacyVulcanName("VULCAN", true));
        assertFalse(EntitySpawnListener.isLegacyVulcanName("Vulcan", false));
        assertFalse(EntitySpawnListener.isLegacyVulcanName("Vulcan II", true));
        assertFalse(EntitySpawnListener.isLegacyVulcanName(null, true));
    }

    @Test
    void excludedWorldNamesAreCaseInsensitive() {
        assertTrue(EntitySpawnListener.isExcludedWorldName("clasico_nether", "Clasico_Nether"));
        assertFalse(EntitySpawnListener.isExcludedWorldName("world_nether", "clasico_nether"));
    }
}
