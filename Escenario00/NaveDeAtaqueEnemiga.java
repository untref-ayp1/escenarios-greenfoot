import greenfoot.*;

/**
 * Define el comportamiento de las Naves de Ataque Enemigas
 */
public class NaveDeAtaqueEnemiga extends NaveEnemiga implements Atacante {

	/**
	 * {@inheritDoc}
	 */
	public NaveDeAtaqueEnemiga(Direccion direccion) {
		super(direccion);
	}

	/**
	 * post: incializa una NaveDeAtaqueEnemiga con la orientación deseada y la salud
	 * inicial definida
	 * 
	 * @param direccion es la dirección inicial
	 * @param salud     es la salud inicial definida
	 */
	public NaveDeAtaqueEnemiga(Direccion direccion, int salud) {
		super(direccion);
		this.salud = salud;
	}

	/**
	 * {@inheritDoc}
	 */
	public void recibirDañoDe(Atacante atacante) {
		super.recibirDañoDe(atacante);
		Actor actor = (Actor) atacante;
		if (this.salud > 0) {
			Direccion direccion = Direccion.flecha(this.getX(), this.getY(), actor.getX(), actor.getY());
			atacarHacia(direccion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int obtenerDaño() {
		return 15;
	}

	/**
	 * @see NaveEnemiga#salud
	 */
	public int obtenerSalud() {
		return this.salud;
	}

	/**
	 * Ataca a un objetivo. Debe utilizarse dentro de sus métodos, es un servicio
	 * interno <br>
	 * post: el objetivo recibe un ataque
	 * 
	 * @param objetivo es el objetivo del ataque
	 */
	private void atacar(Dañable objetivo) {
		objetivo.recibirDañoDe(this);
	}

	/**
	 * Ataca en una dirección determinada <br>
	 * post: El {@link Dañable} que haya en la dirección determinada recibirá un
	 * ataque
	 * 
	 * @param direccion es la dirección del ataque
	 */
	public void atacarHacia(Direccion direccion) {
		this.direccion = direccion;
		actualizarImagen();
		setRotation(direccion.rotacion);
		Greenfoot.delay(20);

		Dañable objetivo = (Dañable) getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
		if (objetivo != null) {
			atacar(objetivo);
		}
	}
}
