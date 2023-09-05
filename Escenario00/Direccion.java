import java.util.Map;
import java.util.HashMap;

/**
 * Modela las direcciones que se utilizan en cada escenario
 */
public enum Direccion {
	NORTE(270, 0, -1), SUR(90, 0, 1), ESTE(0, 1, 0), OESTE(180, -1, 0);

	int rotacion;
	int dx;
	int dy;

	Direccion(int rotacion, int dx, int dy) {
		this.rotacion = rotacion;
		this.dx = dx;
		this.dy = dy;
	}

	/**
	 * @return la dirección opuesta a la dirección actual
	 */
	public Direccion opuesta() {
		Map<Direccion, Direccion> opuestas = new HashMap<Direccion, Direccion>();
		opuestas.put(NORTE, SUR);
		opuestas.put(SUR, NORTE);
		opuestas.put(ESTE, OESTE);
		opuestas.put(OESTE, ESTE);

		return opuestas.get(this);
	}

	/**
	 * Calcula la dirección hacia la que apunta el vector definido por los cuatro
	 * parámetros. <br>
	 * pre: el punto inicial y el punto final no deben ser coincidentes
	 * 
	 * @param x0 la x inicial
	 * @param y0 la y inicial
	 * @param x1 la x final
	 * @param y1 la y final
	 * @return la dirección en la que apunta dicho vector
	 */
	public static Direccion flecha(int x0, int y0, int x1, int y1) {
		int dx = x1 - x0;
		int dy = y1 - y0;

		if (Math.abs(dx) > Math.abs(dy)) {
			return dx > 0 ? ESTE : OESTE;
		} else {
			return dy > 0 ? SUR : NORTE;
		}
	}
}
