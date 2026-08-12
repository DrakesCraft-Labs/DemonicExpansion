package cl.jackstar.smartplugin.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

import cl.jackstar.smartplugin.handler.Handler;

/**
 * Convierte el golpe de Bukkit en {@link LivingEntityDamageByLivingEntityEvent}.
 */
public class EntityDamageByEntityListener extends Handler {

    /**
     * Se escucha en prioridad normal y sin ignorar los cancelados: quien escuche el evento
     * derivado espera poder cancelar el golpe, y para eso tiene que llegarle antes de que se
     * apliquen los MONITOR.
     */
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof LivingEntity victima)) {
            return;
        }

        LivingEntity atacante = resolverAtacante(event);
        if (atacante == null) {
            return;
        }

        Bukkit.getPluginManager().callEvent(
                new LivingEntityDamageByLivingEntityEvent(atacante, victima, event));
    }

    /**
     * Quien es el responsable del golpe.
     *
     * Si el daño viene de un proyectil, el atacante para Bukkit es la flecha. Lo que interesa es
     * quien la disparo: de otro modo un arco demoniaco no cuenta como golpe del jugador y todos
     * los efectos del addon se pierden a distancia.
     */
    private LivingEntity resolverAtacante(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LivingEntity vivo) {
            return vivo;
        }
        if (event.getDamager() instanceof Projectile proyectil) {
            ProjectileSource origen = proyectil.getShooter();
            if (origen instanceof LivingEntity tirador) {
                return tirador;
            }
        }
        return null;
    }
}
