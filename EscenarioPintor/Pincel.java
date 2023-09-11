/**
 * El Pincel concreto, que se utilizará para ejercitar
 */
public class Pincel extends PincelBase {

    /**
     * Establece un algoritmo para pintar el lienzo. Cambiar el código o crear
     * un nuevo pincel siguiendo este ejemplo
     */
    @Override
    public void pintar() {
        int tamaño = obtenerTamañoDelLienzo();

        for (int i = 0; i < tamaño; i++) {
            pintar(i, i);
        }
    }
}
