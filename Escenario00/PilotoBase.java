import greenfoot.*;

/**
 * Define el comportamiento base para todos los Pilotos de la Batalla Espacial
 */
public abstract class PilotoBase extends ActorBase {
	protected double ESCALA_X = 0.8;
	protected double ESCALA_Y = 0.8;

	/**
	 * La nave que pilotará
	 */
	protected NaveDeAtaque navePilotada;

	/**
	 * post: El Piloto se sube a la Nave
	 * 
	 * @param nave es la Nave a la que se subirá el piloto
	 */
	public void subirse(NaveDeAtaque nave) {
		navePilotada = nave;
		actualizarImagen();
	}

	/**
	 * post: El Piloto deja la Nave
	 */
	public void bajarse() {
		navePilotada = null;
		actualizarImagen();
	}

	/**
	 * Actualiza la imagen del Piloto, de acuerdo a su estado
	 */
	@Override
	protected void actualizarImagen() {
		int tamCelda = getWorld().getCellSize();
		GreenfootImage image;
		if (navePilotada != null) {
			image = new GreenfootImage("ghost.png");
		} else {
			image = new GreenfootImage("pilot.png");
		}
		image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
		setImage(image);
	}
}
