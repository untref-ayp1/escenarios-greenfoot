import greenfoot.Color;

/**
 * Define características y comportamientos comunes a todas las Naves Aliadas de
 * la Batalla Espacial. Entre ellas, su uso de combustible.
 */
public abstract class NaveAliada extends NaveBase {
	/**
	 * El combustible de la NaveAliada. Toda acción insume combustible
	 */
	protected int combustible;

	/**
	 * Inicializa una NaveAliada con el {@link #obtenerCombustibleMaximo()}
	 */
	public NaveAliada() {
		super();
		this.combustible = obtenerCombustibleMaximo();
	}

	/**
	 * Punto de extensión para obtener el combustible máximo para un tipo de
	 * NaveAliada
	 * 
	 * @return la cantidad de combustible máximo que carga la NaveAliada
	 */
	abstract int obtenerCombustibleMaximo();

	/**
	 * Punto de extensión para obtener el combustible consumido por moverse
	 * 
	 * @return la cantidad de combustible que consume realizar un movimiento
	 */
	abstract int obtenerConsumoPorMovimiento();

	/**
	 * Permite a una NaveAliada recibir combustible. <br>
	 * post: La NaveAliada recibe la cantidad de combustible deseado, limitado a la
	 * carga máxima de la que puede disponer
	 * 
	 * @param cantidad es la cantidad de combustible que intenta recibir
	 */
	public void recibirCombustible(int cantidad) {
		this.combustible = Math.min(this.combustible + cantidad, obtenerCombustibleMaximo());
		actualizarImagen();
	}

	/**
	 * Recibe un daño de un {@link Atacante} <br>
	 * post: La NaveAliada obtendrá el impacto que el atacante le genere, y se
	 * reflejará en forma de {@link #combustible} perdido.
	 * @see Dañable#recibirDañoDe(Atacante)
	 * 
	 * @param atacante es quien realizó el ataque
	 */
	public void recibirDañoDe(Atacante atacante) {
		int daño = atacante.obtenerDaño();
		this.combustible -= daño;
		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
	}

	/**
	 * post: la cantidad de {@link #combustible} se reduce en la cantidad
	 * solicitada, o llega a cero si no alcanzase
	 * 
	 * @param cantidad es la cantidad de combustible que se consumirá
	 */
	protected void consumirCombustible(int cantidad) {
		this.combustible -= Math.min(cantidad, this.combustible);
		actualizarImagen();
	}

	/**
	 * post: carga la cantidad de {@link #combustible} solicitado, o llega a
	 * {@link #obtenerCombustibleMaximo()} si éste se excediera del que puede llevar
	 * 
	 * @param combustible es la cantidad de combustible a cargar
	 */
	public void cargarCombustible(int combustible) {
		this.combustible = Math.min(obtenerCombustibleMaximo(), this.combustible + combustible);
		actualizarImagen();
	}

	/**
	 * {@link #combustible}
	 * 
	 * @return la cantidad de combustible actual
	 */
	public int obtenerCombustible() {
		return this.combustible;
	}

	/**
	 * Calcula la proporción de la barra indicadora en función al
	 * {@link #combustible} y a {@link #obtenerCombustibleMaximo()}
	 * 
	 * @return la proporción de la barra indicadora a mostrar
	 */
	protected double obtenerProporcionDeBarraIndicadora() {
		return 1.0 * combustible / obtenerCombustibleMaximo();
	}

	/**
	 * @return el color de la barra indicadora de la {@link NaveAliada}
	 */
	@Override
	protected Color obtenerColorDeBarraIndicadora() {
		return Color.YELLOW;
	}

	/**
	 * @return si la nave está en condiciones de actuar
	 */
	@Override
	protected boolean puedeActuar() {
		return this.combustible > 0;
	}

	/**
	 * Permite desplazar un NaveAliada según lo establecido en
	 * {@link NaveBase#moverHacia(Direccion)} <br>
	 * pre: la NaveAliada debe tener {@link #combustible} suficiente, y la celda
	 * destino debe estar disponible <br>
	 * post: la NaveAliada consumirá tanto {@link #combustible} como lo defina
	 * {@link #obtenerConsumoPorMovimiento()}, recogerá cualquier {@link Item} que
	 * se encuentre en el camino, y se desplazará un casillero en la dirección
	 * solicitada.
	 * 
	 * @param direccion es la dirección hacia la que se desea mover
	 * @return si se ha movido acorde a lo solicitado
	 */
	@Override
	protected boolean moverHacia(Direccion direccion) {
		if (!puedeActuar() || this.combustible < obtenerConsumoPorMovimiento()) {
			return false;
		}
		if (!super.moverHacia(direccion)) {
			return false;
		}
		consumirCombustible(obtenerConsumoPorMovimiento());

		Item item = (Item) getOneObjectAtOffset(0, 0, Item.class);
		if (item != null) {
			this.cargarCombustible(item.serRecogido());
		}
		return true;
	}

	/**
	 * Define una forma de inspeccionar el entorno
	 * 
	 * @param direccion es la dirección que desea inspeccionar
	 * @return si hay un {@link Asteroide} a una casilla de distancia, en la
	 *         dirección deseada
	 */
	public boolean hayAsteroideHacia(Direccion direccion) {
		return super.hayActorHacia(Asteroide.class, direccion);
	}

	/**
	 * Define una forma de inspeccionar el entorno
	 * 
	 * @param direccion es la dirección que desea inspeccionar
	 * @return si hay un {@link Item} a una casilla de distancia, en la dirección
	 *         deseada
	 */
	public boolean hayItemHacia(Direccion direccion) {
		return super.hayActorHacia(Item.class, direccion);
	}

	/**
	 * Define una forma de inspeccionar el entorno
	 * 
	 * @param direccion es la dirección que desea inspeccionar
	 * @return si hay una {@link NaveBase} a una casilla de distancia, en la
	 *         dirección deseada
	 */
	public boolean hayNaveHacia(Direccion direccion) {
		return super.hayActorHacia(NaveBase.class, direccion);
	}

	/**
	 * Define una forma de inspeccionar el entorno
	 * 
	 * @param direccion es la dirección que desea inspeccionar
	 * @return si el mundo se acaba a una casilla de distancia, en la dirección
	 *         deseada
	 */
	public boolean hayVacioHacia(Direccion direccion) {
		int width = getWorld().getWidth() - 1;
		int height = getWorld().getHeight() - 1;
		int x = getX();
		int y = getY();

		switch (direccion) {
		case NORTE:
			return y == 0;
		case SUR:
			return y == height;
		case ESTE:
			return x == width;
		case OESTE:
			return x == 0;
		}
		return false;
	}

	/**
	 * Verifica si la nave está en alguno de los bordes del Mundo
	 * 
	 * @return {@code true} si está en el borde
	 */
	public boolean estaEnElBorde() {
		return isAtEdge();
	}
}
