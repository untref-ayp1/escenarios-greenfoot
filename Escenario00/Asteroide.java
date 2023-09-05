import greenfoot.*;

/**
 * Un Asteroide es un obstáculo que puede ser destruido por una
 * {@link NaveDeAtaque}. Esto llevará una cierta cantidad de ataques
 */
public class Asteroide extends ActorBase implements Dañable {
	/**
	 * {@value #TAMAÑO_MINIMO_DE_ASTEROIDE}
	 */
	protected static final int TAMAÑO_MINIMO_DE_ASTEROIDE = 10;

	/**
	 * {@value #TAMAÑO_MAXIMO_DE_ASTEROIDE}
	 */
	protected static final int TAMAÑO_MAXIMO_DE_ASTEROIDE = 100;

	/**
	 * Es el tamaño actual del Asteroide, que tiene relación directa con la cantidad
	 * de ataques necesarios para eliminarlo
	 */
	protected int tamaño;

	/**
	 * Inicializa un Asteroide con tamaño aleatorio entre 51 y 100 puntos
	 */
	public Asteroide() {
		this(51 + (int) (Math.random() * 50));
	}

	/**
	 * Inicializa un Asteroiode con tamaño arbitrario, en el rango de 10 a
	 * {@value #TAMAÑO_MAXIMO_DE_ASTEROIDE} puntos
	 * 
	 * @param tamañoInicial
	 */
	public Asteroide(int tamañoInicial) {
		this.tamaño = Math.max(TAMAÑO_MINIMO_DE_ASTEROIDE, Math.min(TAMAÑO_MAXIMO_DE_ASTEROIDE, tamañoInicial));
	}

	/**
	 * post: el Asteroide reducirá su tamaño conforme la potencia del ataque. <br>
	 * post: el Asteroide será eliminado del tablero si su tamaño llega a 0. <br>
	 * 
	 * @see Dañable#recibirDañoDe(Atacante)
	 */
	public void recibirDañoDe(Atacante atacante) {
		int daño = atacante.obtenerDaño();
		this.tamaño -= daño;
		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
		if (this.tamaño <= 0) {
			getWorld().removeObject(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizarImagen() {
		int tamCelda = getWorld().getCellSize();
		int ancho = Math.max(30, (tamCelda * tamaño) / obtenerTamañoMaximo());
		GreenfootImage image = getImage();
		if (this.tamaño <= 0)
			image.setTransparency(0);
		image.scale(ancho, ancho);
		setImage(image);
		setRotation((int) (Math.random() * 360));
	}

	/**
	 * {@value #TAMAÑO_MAXIMO_DE_ASTEROIDE}
	 * 
	 * @return el tamaño máximo que puede tener un Asteroide
	 */
	protected int obtenerTamañoMaximo() {
		return TAMAÑO_MAXIMO_DE_ASTEROIDE;
	}

	/**
	 * {@link #tamaño}
	 * 
	 * @return el tamaño del Asteroide
	 */
	public int obtenerTamaño() {
		return this.tamaño;
	}
}
