import java.util.Map;
import java.util.HashMap;

public enum Direccion {
	NORTE(270, 0, -1), SUR(90, 0, 1), ESTE(0, 1, 0), OESTE(180, -1, 0);

	int rotacion, dx, dy;

	Direccion(int rotacion, int dx, int dy) {
		this.rotacion = rotacion;
		this.dx = dx;
		this.dy = dy;
	}

	public Direccion opuesta() {
		Map<Direccion, Direccion> opuestas = new HashMap<Direccion, Direccion>();
		opuestas.put(NORTE, SUR);
		opuestas.put(SUR, NORTE);
		opuestas.put(ESTE, OESTE);
		opuestas.put(OESTE, ESTE);

		return opuestas.get(this);
	}

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
