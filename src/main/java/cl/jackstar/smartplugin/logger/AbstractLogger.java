package cl.jackstar.smartplugin.logger;

/**
 * Registro con niveles y color.
 *
 * El addon lo extiende para decidir por donde sale cada linea; aqui solo van los niveles y el
 * filtro de depuracion.
 */
public abstract class AbstractLogger {

    private final String nombre;
    private final boolean debug;

    protected AbstractLogger(String nombre, boolean debug) {
        this.nombre = nombre;
        this.debug = debug;
    }

    public String getName() {
        return nombre;
    }

    public boolean isDebug() {
        return debug;
    }

    /** Lo implementa quien extienda: decide el formato y el destino. */
    public abstract void log(LogLevel nivel, String mensaje);

    public void info(String mensaje) {
        log(LogLevel.INFO, mensaje);
    }

    public void warn(String mensaje) {
        log(LogLevel.WARN, mensaje);
    }

    public void error(String mensaje) {
        log(LogLevel.ERROR, mensaje);
    }

    /** DEBUG y TRACE solo salen con la depuracion encendida; si no, inundan la consola. */
    public void debug(String mensaje) {
        if (debug) {
            log(LogLevel.DEBUG, mensaje);
        }
    }

    public void trace(String mensaje) {
        if (debug) {
            log(LogLevel.TRACE, mensaje);
        }
    }

    /**
     * Los colores son codigos ANSI: esto va a la consola del servidor, no al chat.
     *
     * Llevan el escape incluido porque quien los usa los concatena tal cual y cierra la linea con
     * su propio reset.
     */
    public enum LogLevel {

        INFO("\u001B[32m"),
        WARN("\u001B[33m"),
        ERROR("\u001B[31m"),
        DEBUG("\u001B[36m"),
        TRACE("\u001B[35m");

        private final String color;

        LogLevel(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }
}
