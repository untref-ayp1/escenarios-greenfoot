public class Mineral extends Asteroide {
	private int vidaInicial = 0;

	public Mineral() {
		this(500);
	}

	public Mineral(int cantidad) {
		this.vida = cantidad;
		this.vidaInicial = cantidad;
	}

	int consultarMineralDisponible() {
		return this.vida;
	}

	int recolectar(int cantidad) {
		cantidad = Math.min(cantidad, this.vida);
		cantidad = Math.min(cantidad, 100);
		this.vida -= cantidad;

		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
		if (this.vida <= 0) {
			getWorld().removeObject(this);
		}

		return cantidad;
	}

	protected int obtenerTamañoMaximo() {
		return this.vidaInicial;
	}
}
