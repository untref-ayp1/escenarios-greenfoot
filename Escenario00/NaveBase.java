import greenfoot.*;

/**
 * Define características y comportamientos comunes a todas las Naves de la
 * Batalla Espacial.
 */
public abstract class NaveBase extends ActorBase implements Dañable {
	protected double ESCALA_X = 1;
	protected double ESCALA_Y = 1;

	/**
	 * La dirección en la que apunta la Nave
	 */
	protected Direccion direccion;

	/**
	 * Inicializa una Nave apuntando hacia el {@link Direccion#NORTE}
	 */
	public NaveBase() {
		this(Direccion.NORTE);
	}

	/**
	 * Inicializa una Nave apuntando hacia la dirección solicitada
	 * 
	 * @param direccion es la dirección donde apuntará inicialmente la Nave
	 */
	public NaveBase(Direccion direccion) {
		setDireccion(direccion);
		imagenBase = getImage();
	}

	/**
	 * Establece la dirección de la Nave
	 * 
	 * @param direccion es la nueva dirección
	 */
	protected void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		setRotation(this.direccion.rotacion);
	}

	/**
	 * Permite actualizar la imagen de la Nave. Agrega la barra indicadora debajo.
	 */
	@Override
	protected void actualizarImagen() {
		int tamCelda = getWorld().getCellSize();
		GreenfootImage image = getImage();
		image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
		setImage(image);

		GreenfootImage canvas = new GreenfootImage(imagenBase.getWidth(),
				imagenBase.getHeight() + getWorld().getCellSize() / 3);

		canvas.setColor(Color.BLACK);
		canvas.fillRect(4, imagenBase.getHeight() - 2, getWorld().getCellSize() - 6, 12);
		canvas.setColor(obtenerColorDeBarraIndicadora());

		canvas.fillRect(6, imagenBase.getHeight(),
				(int) ((getWorld().getCellSize() - 10) * obtenerProporcionDeBarraIndicadora()), 8);

		canvas.rotate(360 - direccion.rotacion);

		canvas.drawImage(imagenBase, 0, getWorld().getCellSize() / 6);
		setImage(canvas);

	}

	/**
	 * Punto de extensión para la definición del color de la barra indicadora
	 * 
	 * @return el color de la barra indicadora
	 */
	protected abstract Color obtenerColorDeBarraIndicadora();

	/**
	 * Punto de extensión para la definición del nivel de la barra indicadora
	 * 
	 * @return la proporción en la que debe llenar la barra indicadora
	 */
	protected abstract double obtenerProporcionDeBarraIndicadora();

	/**
	 * Permite a una Nave conocer su entorno.
	 * 
	 * @param clazz     la clase de Actor que va a buscar en el entorno
	 * @param direccion la dirección hacia la que lo buscará
	 * @return si existe o no dicho tipo de actor en esa dirección
	 */
	protected boolean hayActorHacia(Class<? extends Actor> clazz, Direccion direccion) {
		return getOneObjectAtOffset(direccion.dx, direccion.dy, clazz) != null;
	}

	/**
	 * Punto de extensión para verificar si una Nave puede actuar
	 * 
	 * @return la posibilidad de actuar
	 */
	protected abstract boolean puedeActuar();

	/**
	 * Permite a la Nave moverse en alguna dirección. <br>
	 * pre: la Nave {@link #puedeActuar()} <br>
	 * post: la Nave se desplazará un casillero en la dirección especificada
	 * 
	 * @param direccion es la dirección hacia la que se moverá la Nave
	 * @return si ha sido posible moverse o no en esa dirección
	 */
	protected boolean moverHacia(Direccion direccion) {
		if (!puedeActuar()) {
			return false;
		}

		setDireccion(direccion);
		actualizarImagen();
		Greenfoot.delay(20);

		if (hayActorHacia(Asteroide.class, direccion) || hayActorHacia(NaveBase.class, direccion)) {
			return false;
		}

		move(1);
		return true;
	}
}
