import greenfoot.*;

public class Mundo09Aleatorio extends MundoBase {
	private int ancho;
	private int alto;
	private int xAsteroide;

	public Mundo09Aleatorio() {
		super(aleatorioEntre(10, 18), aleatorioEntre(8, 14));
		ancho = getWidth();
		alto = getHeight();
	}

	private static int aleatorioEntre(int desde, int hasta) {
		return desde + (int) (Math.random() * (hasta - desde));
	}

	protected void generarNave() {
		agregar(new NaveDeAtaque(), ancho / 2, 3 * alto / 5);
	}

	protected void generarPOIs() {
		marcarCelda(ancho / 2, 3 * alto / 5, new Color(0, 0, 200, 150));
	}

	protected void generarItems() {

	}

	protected void generarAsteroides() {
		int cantidadDeAsteroides = (ancho - 2 + aleatorioEntre(0, ancho)) / 2;
		int offset = (ancho - cantidadDeAsteroides) / 2;

		int posicionMayor = aleatorioEntre(0, cantidadDeAsteroides);
		for (int j = 0; j < cantidadDeAsteroides; j++) {
			if (j == posicionMayor)
				agregar(new Asteroide(100), offset + j, 2 * alto / 7);
			else
				agregar(new Asteroide(50 + aleatorioEntre(0, 40)), offset + j, 2 * alto / 7);
		}
		this.xAsteroide = posicionMayor + offset;

		agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), xAsteroide, 4 * alto / 5);

		agregar(new Item(), offset, 2 * alto / 7 + 1);
		agregar(new Item(), offset + cantidadDeAsteroides - 1, 2 * alto / 7 + 1);

		agregar(new Item(), xAsteroide, 4 * alto / 5 - 1);
	}
}
