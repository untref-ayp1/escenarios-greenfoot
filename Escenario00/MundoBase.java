import greenfoot.*;

/**
 * Modela la base para los Mundos que se desarrollan en la Batalla Espacial
 */
public abstract class MundoBase extends World {

	/**
	 * {@value #TAMAÑO_DE_CELDA_POR_DEFECTO}
	 */
	private static final int TAMAÑO_DE_CELDA_POR_DEFECTO = 60;

	/**
	 * Inicializa un Mundo con un tamaño de celda de
	 * {@value #TAMAÑO_DE_CELDA_POR_DEFECTO}
	 * 
	 * @param ancho el ancho del mundo
	 * @param alto  el alto del mundo
	 */
	public MundoBase(int ancho, int alto) {
		this(ancho, alto, TAMAÑO_DE_CELDA_POR_DEFECTO);
	}

	/**
	 * Inicializa un Mundo con un tamaño de celda variable
	 * 
	 * @param ancho       el ancho del mundo
	 * @param alto        el alto del mundo
	 * @param tamañoCelda el tamaño de la celda definido
	 */
	public MundoBase(int ancho, int alto, int tamañoCelda) {
		super(ancho, alto, tamañoCelda);

		generarPOIs();
		generarGrilla();

		generarAsteroides();
		generarItems();

		generarNaves();
		agregar(new Brujula(), ancho, alto);
	}

	/**
	 * Punto de extensión para generar los Puntos de Interés (POI)
	 */
	protected void generarPOIs() {
	}

	/**
	 * Estandarización de la grilla visual y el sombreado de casillas intermedias
	 */
	protected void generarGrilla() {
		int cell = getCellSize();

		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				getBackground().setColor(Color.WHITE);
				getBackground().drawRect(x * cell, y * cell, cell, cell);
				if ((x + y) % 2 == 0)
					marcarCelda(x, y, new Color(255, 255, 255, 40));
			}
		}

		for (int x = 0; x < getWidth(); x++) {
			String columnName = "" + (char) ('A' + x);
			GreenfootImage columnNameImage = new GreenfootImage(columnName, 15, Color.WHITE, null);
			getBackground().drawImage(columnNameImage, x * cell + cell / 2 - 4, 2);
		}

		for (int y = 0; y < getHeight(); y++) {
			String columnName = y + 1 + "";
			GreenfootImage columnNameImage = new GreenfootImage(columnName, 15, Color.WHITE, null);
			getBackground().drawImage(columnNameImage, 2, y * cell + cell / 2 - 4);
		}
	}

	/**
	 * Punto de extensión para generar los Asteroides
	 */
	protected void generarAsteroides() {
	}

	/**
	 * Punto de extensión para generar los Items
	 */
	protected void generarItems() {
	}

	/**
	 * Punto de extensión para generar las Naves
	 */
	protected void generarNaves() {
	}

	/**
	 * Permite marcar una celda de un Color determinado
	 * 
	 * @param x     la posición de la celda en x
	 * @param y     la posición de la celda en y
	 * @param color el color con el que se marcará la celda
	 */
	protected void marcarCelda(int x, int y, Color color) {
		int cell = getCellSize();
		getBackground().setColor(color);
		getBackground().fillRect(x * cell, y * cell, cell, cell);
	}

	/**
	 * Permite agregar un Actor dentro del mundo, en una posición determinada <br>
	 * post: el Actor será agregado en la posición (x, y) del Mundo
	 * 
	 * @param actor el Actor a agregar
	 * @param x     la posición en x del Actor
	 * @param y     la posición en y del Actor
	 */
	protected void agregar(Actor actor, int x, int y) {
		addObject(actor, x, y);
	}

	/**
	 * Permite agregar una matriz de Asteroides. Sirve para facilitar la forma en la
	 * que se crean los mapas <br>
	 * post: Los Asteroides se crearán en las posiciones respectivas del mundo
	 * 
	 * @param asteroides una matriz con las posiciones en las que hay Asteroides
	 */
	protected void poblarAsteroidesConMatriz(boolean[][] asteroides) {
		for (int i = 0; i < asteroides.length; i++) {
			for (int j = 0; j < asteroides[i].length; j++) {
				if (asteroides[i][j])
					agregar(new Asteroide(), j, i);
			}
		}
	}
}
