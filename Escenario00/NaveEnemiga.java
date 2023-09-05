import greenfoot.*;

/**
 * Define las características y comportamiento base de una NaveEnemiga. Las
 * Naves de esta facción no funcionan con combustible, sino con gravitrones. Es
 * por ello que no tienen tanque sino un estado de salud
 */
public abstract class NaveEnemiga extends NaveBase {
	/**
	 * {@value #SALUD_INICIAL}
	 */
	private static final int SALUD_INICIAL = 100;

	/**
	 * Es la salud de la NaveEnemiga
	 */
	protected int salud = SALUD_INICIAL;

	/**
	 * post: se inicia una NaveEnemiga en la dirección deseada
	 * 
	 * @param direccion la dirección en la que apuntará la NaveEnemiga
	 */
	public NaveEnemiga(Direccion direccion) {
		super(direccion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected double obtenerProporcionDeBarraIndicadora() {
		return 1.0 * this.salud / 100;
	}

	/**
	 * post: la NaveEnemiga reducirá su {@link #salud} conforme la potencia del
	 * ataque. <br>
	 * post: la NaveEnemiga será eliminada del tablero si su {@link #salud} llega a
	 * 0. <br>
	 * 
	 * @see Dañable#recibirDañoDe(Atacante)
	 */
	@Override
	public void recibirDañoDe(Atacante atacante) {
		int daño = atacante.obtenerDaño();
		this.salud -= daño;
		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
		if (this.salud <= 0) {
			getWorld().removeObject(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Color obtenerColorDeBarraIndicadora() {
		return Color.RED;
	}

	/**
	 * Una NaveEnemiga no tiene restricciones de combustible, por lo que puede
	 * actuar siempre
	 * 
	 * @return {@code true}
	 */
	@Override
	protected boolean puedeActuar() {
		return true;
	}
}
