/**
 * Un AsteroideDeMineral es un tipo de {@link Asteroide} que además de funcionar
 * como obstáculo, puede ser recolectado por una {@link NaveRecolectora}
 * mediante {@link NaveRecolectora#recolectarDesde(Direccion)}. En la medida en
 * que se recolecte material, el AsteroideDeMineral se reducirá en tamaño hasta
 * desaparecer cuando sea consumido completamente.
 */
public class AsteroideDeMineral extends Asteroide {
	/**
	 * {@value #TAMAÑO_MINIMO_DE_ASTEROIDE_DE_MINERAL}
	 */
	protected static final int TAMAÑO_MINIMO_DE_ASTEROIDE_DE_MINERAL = 50;

	/**
	 * {@value #TAMAÑO_MAXIMO_DE_ASTEROIDE_DE_MINERAL}
	 */
	protected static final int TAMAÑO_MAXIMO_DE_ASTEROIDE_DE_MINERAL = 500;

	/**
	 * {@value #EXTRACCION_MAXIMA}
	 */
	private static final int EXTRACCION_MAXIMA = 100;

	/**
	 * Es el tamaño inicial con el que se creó el AsteroideDeMineral
	 */
	protected final int tamañoInicial;

	/**
	 * Inicializa un AsteroiodeDeMineral con tamaño aleatorio entre 251 y 500 puntos
	 */
	public AsteroideDeMineral() {
		this(251 + (int) (Math.random() * 250));
	}

	/**
	 * Inicializa un AsteroiodeDeMineral con tamaño arbitrario, en el rango de
	 * {@value #TAMAÑO_MINIMO_DE_ASTEROIDE_DE_MINERAL} a
	 * {@value #TAMAÑO_MAXIMO_DE_ASTEROIDE_DE_MINERAL} puntos
	 * 
	 * @param tamañoInicial
	 */
	public AsteroideDeMineral(int tamañoInicial) {
		super(Math.max(TAMAÑO_MINIMO_DE_ASTEROIDE_DE_MINERAL,
				Math.min(TAMAÑO_MAXIMO_DE_ASTEROIDE_DE_MINERAL, tamañoInicial)));
		this.tamañoInicial = this.tamaño;
	}

	/**
	 * @return la cantidad de mineral de la que dispone
	 */
	public int consultarMineralDisponible() {
		return this.tamaño;
	}

	/**
	 * post: Se reducirá el tamaño del AsteroideDeMineral conforme la cantidad
	 * solicitada, siguiendo las reglas de existencia y limitaciones del turno
	 * 
	 * @param cantidad es la cantidad de mineral a entregar
	 * @return la cantidad que pudo ser extraida, limitada por las existencias y por
	 *         {@link #EXTRACCION_MAXIMA}
	 */
	public int entregarMineral(int cantidad) {
		cantidad = Math.min(cantidad, this.tamaño);
		cantidad = Math.min(cantidad, EXTRACCION_MAXIMA);
		this.tamaño -= cantidad;

		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
		if (this.tamaño <= 0) {
			getWorld().removeObject(this);
		}

		return cantidad;
	}

	/**
	 * {@link AsteroideDeMineral#tamañoInicial}
	 * 
	 * @return el tamaño inicial del AsteroideDeMineral
	 */
	protected int obtenerTamañoMaximo() {
		return this.tamañoInicial;
	}
}
