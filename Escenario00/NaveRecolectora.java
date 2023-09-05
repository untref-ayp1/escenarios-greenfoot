import greenfoot.*;

public class NaveRecolectora extends NaveAliada {
	/**
	 * post: Inicializa una NaveRecolectora, con suficiente carga para moverse. No
	 * se inicia con {@link #obtenerCombustibleMaximo()}
	 */
	public NaveRecolectora() {
		super();
		this.combustible = 150;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	int obtenerConsumoPorMovimiento() {
		return 10;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	int obtenerCombustibleMaximo() {
		return 500;
	}

	/**
	 * @see NaveAliada#moverHacia(Direccion)
	 */
	public void avanzarHacia(Direccion direccion) {
		super.moverHacia(direccion);
	}

	/**
	 * post: el {@link NaveAliada#combustible} se incrementará en la mayor cantidad
	 * que pueda extraer <br>
	 * post: consumirá {@link #obtenerConsumoPorMovimiento()} al realizar la
	 * extracción
	 * 
	 * @param direccion es la dirección desde la cual intentará recolectar
	 */
	public void recolectarDesde(Direccion direccion) {
		recolectarDesde(direccion, Integer.MAX_VALUE);
	}

	/**
	 * pre: la nave debe tener {@link NaveAliada#combustible} disponible para operar
	 * el sistema de recolección <br>
	 * post: el {@link NaveAliada#combustible} se incrementará en la mayor cantidad
	 * que pueda extraer <br>
	 * post: consumirá {@link #obtenerConsumoPorMovimiento()} al realizar la
	 * extracción
	 * 
	 * @param direccion es la dirección desde la cual intentará recolectar
	 * @param cantidad  es la cantidad a recolectar. Se limitará automáticamente
	 *                  según el orígen de recolección y la capacidad total de carga
	 */
	public void recolectarDesde(Direccion direccion, int cantidad) {
		if (this.combustible <= 0) {
			return;
		}

		setDireccion(direccion);
		actualizarImagen();
		Greenfoot.delay(20);
		consumirCombustible(obtenerConsumoPorMovimiento());

		Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
		if (!(actor instanceof AsteroideDeMineral)) {
			return;
		}

		AsteroideDeMineral objetivo = (AsteroideDeMineral) actor;
		if (objetivo != null) {
			cantidad = objetivo.entregarMineral(cantidad);
			this.combustible = Math.min(this.combustible + cantidad, obtenerCombustibleMaximo());
		}
	}

	/**
	 * pre: la nave debe tener {@link NaveAliada#combustible} disponible para operar
	 * el sistema de transferencia <br>
	 * post: el {@link NaveAliada#combustible} se decrementará de acuerdo a las
	 * existencias y la cantidad solicitada <br>
	 * post: la cantidad de combustible disponible disminuirá de acuerdo a la
	 * cantidad que transfiera
	 * 
	 * @param direccion es la dirección hacia la cual transferir el combustible
	 * @param cantidad  es la cantidad que se desea transferir. Se verá limitada
	 *                  automáticamente por las existencias y la capacidad de carga
	 *                  de la NaveAliada destino
	 */
	void transferirCombustibleHacia(Direccion direccion, int cantidad) {
		if (this.combustible <= 0) {
			return;
		}

		setDireccion(direccion);
		actualizarImagen();
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
}
