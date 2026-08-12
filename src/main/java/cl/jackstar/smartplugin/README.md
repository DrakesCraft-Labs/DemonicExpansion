# cl.jackstar.smartplugin

Reimplementacion minima de **SmartPlugin**, la libreria de utilidades de TheSilentPro contra la
que se escribio este addon.

## Por que existe

El addon dependia de `com.github.TheSilentPro:SmartPlugin:96fe3b0d59`, resuelto por jitpack.
Ese repositorio **ya no existe**: GitHub devuelve 404 y jitpack devuelve 401. No hay jar, no hay
fuente y no queda copia en ninguna cache. Sin esto el addon no compila, y no compilaba por algo
que no se puede arreglar esperando.

## Que es y que no es

Cubre **solo la superficie que este addon usa**: 8 utilidades estaticas y 7 tipos base. No es la
libreria original ni pretende serlo; los nombres de clase y de metodo se mantienen para no tener
que reescribir los 16 ficheros que la usaban, pero el interior esta escrito de cero contra la API
de Paper 1.21.11.

Va **dentro del addon**, no como jar aparte: es codigo de apoyo de este plugin y solo de este.

## Diferencias deliberadas con el original

- No hay autoactualizador. El original traia uno que se descargaba jars de un repo ajeno y se
  reemplazaba solo; en un servidor en produccion eso es una via de entrada, no una comodidad.
- Los mensajes que ve el jugador estan en español.
