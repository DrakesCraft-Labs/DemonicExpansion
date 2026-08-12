package tsp.demonicexpansion.implementation.entity;

public class Entities {

    public static final Necromancer NECROMANCER = new Necromancer();
    public static final Reaper REAPER = new Reaper();
    public static final Vulcan VULCAN = new Vulcan();
    public static final Hellhound HELLHOUND = new Hellhound();

    public static void registerAll(EntityManager manager) {
        NECROMANCER.register(manager);
        REAPER.register(manager);
        VULCAN.register(manager);
        HELLHOUND.register(manager);
    }

}
