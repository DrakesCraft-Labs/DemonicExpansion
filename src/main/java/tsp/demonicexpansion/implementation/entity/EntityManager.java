package tsp.demonicexpansion.implementation.entity;

import org.bukkit.NamespacedKey;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class EntityManager {

    private final Map<NamespacedKey, DemonicEntity> entities = new ConcurrentHashMap<>();

    public void register(NamespacedKey key, DemonicEntity entity) {
        entities.put(key, entity);
    }

    public Optional<DemonicEntity> getEntity(NamespacedKey key) {
        return Optional.ofNullable(entities.get(key));
    }

}
