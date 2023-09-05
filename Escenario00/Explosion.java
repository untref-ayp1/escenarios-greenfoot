import greenfoot.*;

/**
 * Define el comportamiento de una Explosion
 */
public class Explosion extends ActorBase {
	GifImage gif = new GifImage("explo.gif");

	/**
	 * Ejecuta la animación completa
	 */
	public void animar() {
		for (int i = 0; i < 35; i++) {
			actualizarImagen();
			Greenfoot.delay(1);
		}
	}

	/**
	 * post: Genera una explosión en unas coordenadas del mundo
	 * 
	 * @param mundo es el mundo donde aparecerá la explosión
	 * @param x     la coordenada x de la explosión
	 * @param y     la coordenada y de la explosión
	 */
	public static void en(World mundo, int x, int y) {
		Explosion explosion = new Explosion();
		mundo.addObject(explosion, x, y);
		Greenfoot.playSound("explosion.wav");
		explosion.animar();
		mundo.removeObject(explosion);
	}

	/**
	 * Avanza un fotograma en la animación del a explosión
	 */
	protected void actualizarImagen() {
		setImage(gif.getCurrentImage());
	}
}
