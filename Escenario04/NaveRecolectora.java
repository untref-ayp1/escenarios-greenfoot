import greenfoot.*;

public class NaveRecolectora extends NaveAliada {
	public NaveRecolectora() {
		super();
		this.combustible = 150;
	}

	int obtenerConsumoPorMovimiento() {
		return 10;
	}

	int obtenerCombustibleMaximo() {
		return 500;
	}

	void avanzarHacia(Direccion direccion) {
		super.moverHacia(direccion);
	}

	void recolectarDesde(Direccion direccion) {
		recolectarDesde(direccion, Integer.MAX_VALUE);
	}

	void transferirCombustibleHacia(Direccion direccion, int cantidad) {
		if (this.combustible <= 0) {
			return;
		}

		this.direccion = direccion;
		updateImage();
		setRotation(direccion.rotacion);
		Greenfoot.delay(20);

		Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
		if (!(actor instanceof NaveAliada)) {
			return;
		}
		NaveAliada objetivo = (NaveAliada) actor;
		cantidad = Math.min(cantidad, this.combustible);
		if (objetivo != null) {
			objetivo.recibirCombustible(cantidad);
		}

		// si nadie lo recibe, lo pierdo en el vacío...
		consumirCombustible(cantidad);
	}

	void recolectarDesde(Direccion direccion, int cantidad) {
		if (this.combustible <= 0) {
			return;
		}

		this.direccion = direccion;
		updateImage();
		setRotation(direccion.rotacion);
		Greenfoot.delay(20);
		consumirCombustible(obtenerConsumoPorMovimiento());

		Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
		if (!(actor instanceof Mineral)) {
			return;
		}

		Mineral objetivo = (Mineral) actor;
		if (objetivo != null) {
			cantidad = objetivo.recolectar(cantidad);
			this.combustible = Math.min(this.combustible + cantidad, obtenerCombustibleMaximo());
		}
	}
}
