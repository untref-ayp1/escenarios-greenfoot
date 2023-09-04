import greenfoot.*;

/**
 * Clase base abstracta, para estandarizar los comportamientos de los actores de
 * la Batalla Espacial.
 */
public abstract class ActorBase extends Actor {
	protected GreenfootImage baseImage;

	/**
	 * Punto de extensión para definir cómo debe actualizarse la imagen del Actor
	 */
	protected abstract void actualizarImagen();

	/**
	 * Captura las características del Actor al ser agregado al Mundo
	 */
	@Override
	protected void addedToWorld(World world) {
		baseImage = getImage();
		actualizarImagen();
	}
}
