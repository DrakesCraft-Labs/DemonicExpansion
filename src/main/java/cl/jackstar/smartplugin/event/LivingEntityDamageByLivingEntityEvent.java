package cl.jackstar.smartplugin.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Un ser vivo golpea a otro ser vivo.
 *
 * Bukkit da {@link EntityDamageByEntityEvent}, donde atacante y victima son {@code Entity} y
 * pueden ser una flecha o un bloque de TNT. Casi todo lo que hace este addon -- mirar el equipo
 * del atacante, leer su identificador de criatura demoniaca -- necesita seres vivos, y sin este
 * envoltorio cada listener repetia las mismas dos comprobaciones y los mismos dos casts.
 */
public class LivingEntityDamageByLivingEntityEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final LivingEntity atacante;
    private final LivingEntity victima;
    private final EntityDamageByEntityEvent original;
    private boolean cancelado;

    public LivingEntityDamageByLivingEntityEvent(LivingEntity atacante, LivingEntity victima,
                                                 EntityDamageByEntityEvent original) {
        this.atacante = atacante;
        this.victima = victima;
        this.original = original;
    }

    /** Quien pega. */
    public LivingEntity getDamager() {
        return atacante;
    }

    /** Quien recibe. */
    public LivingEntity getEntity() {
        return victima;
    }

    /** Lo mismo que {@link #getEntity()}; el addon usa los dos nombres indistintamente. */
    public LivingEntity getVictim() {
        return victima;
    }

    /** Por que se produjo el daño: golpe cuerpo a cuerpo, proyectil, explosion... */
    public EntityDamageEvent.DamageCause getCause() {
        return original.getCause();
    }

    public double getDamage() {
        return original.getDamage();
    }

    public void setDamage(double daño) {
        original.setDamage(daño);
    }

    /** El evento de Bukkit del que sale este, por si hace falta algo que aqui no se expone. */
    public EntityDamageByEntityEvent getOriginalEvent() {
        return original;
    }

    @Override
    public boolean isCancelled() {
        return cancelado;
    }

    /** Cancelar aqui cancela el golpe de verdad, no solo esta copia. */
    @Override
    public void setCancelled(boolean cancelado) {
        this.cancelado = cancelado;
        original.setCancelled(cancelado);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
