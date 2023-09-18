import greenfoot.*;

/**
 * Modela la base para los Lienzos
 */
public abstract class LienzoBase extends World {

	/**
	 * {@value #TAMAÑO_DE_CELDA_POR_DEFECTO}
	 */
	private static final int TAMAÑO_DE_CELDA_POR_DEFECTO = 70;

	/**
	 * Inicializa un Mundo con un tamaño de celda de
	 * {@value #TAMAÑO_DE_CELDA_POR_DEFECTO}
	 * 
	 * @param ancho el ancho del mundo
	 * @param alto  el alto del mundo
	 */
	public LienzoBase(int ancho, int alto) {
		this(ancho, alto, TAMAÑO_DE_CELDA_POR_DEFECTO);
	}

	/**
	 * Inicializa un Mundo con un tamaño de celda variable
	 * 
	 * @param ancho       el ancho del mundo
	 * @param alto        el alto del mundo
	 * @param tamañoCelda el tamaño de la celda definido
	 */
	public LienzoBase(int ancho, int alto, int tamañoCelda) {
		super(ancho, alto, tamañoCelda);
		generarGrilla();
	}

	/**
	 * Estandarización de la grilla visual y el sombreado de casillas intermedias
	 */
	protected void generarGrilla() {
		int cell = getCellSize();

		// doble borde
		getBackground().setColor(Color.BLACK);
		getBackground().drawRect(0, 0, getWidth() * cell - 1, getHeight() * cell - 1);

		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				getBackground().setColor(Color.BLACK);
				getBackground().drawRect(x * cell, y * cell, cell, cell);
				if ((x + y) % 2 == 0)
					marcarCelda(x, y, new Color(255, 255, 255, 40));
			}
		}

		for (int x = 0; x < getWidth(); x++) {
			String columnName = "" + x;
			GreenfootImage columnNameImage = new GreenfootImage(columnName, 15, Color.BLACK, null);
			getBackground().drawImage(columnNameImage, x * cell + cell / 2 - 4, 2);
		}

		for (int y = 0; y < getHeight(); y++) {
			String columnName = "" + y;
			GreenfootImage columnNameImage = new GreenfootImage(columnName, 15, Color.BLACK, null);
			getBackground().drawImage(columnNameImage, 2, y * cell + cell / 2 - 4);
		}
	}

	/**
	 * Permite mostrar la coordenada de cada celda, para ayudar a pensar los
	 * algoritmos de pintado
	 */
	public void mostrarAyudas() {
		int cell = getCellSize();

		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				String cellName = "(" + i + ", " + j + ")";
				GreenfootImage columnNameImage = new GreenfootImage(cellName, 10, Color.BLACK, null);
				// Greenfoot usa x, y como coordenada, que para nosotros son j y i (en ese
				// orden)
				getBackground().drawImage(columnNameImage, j * cell + cell - 28, i * cell + cell - 12);
			}
		}
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
		getBackground().fillRect(x * cell + 1, y * cell + 1, cell - 1, cell - 1);
	}

}
