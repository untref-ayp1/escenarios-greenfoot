import greenfoot.*;

public class Mundo09Aleatorio extends MundoBase {
	private int ancho;
	private int alto;
	private int xAsteroide;

	public Mundo09Aleatorio() {
		super(aleatorioEntre(10, 18), aleatorioEntre(8, 14));
		this.ancho = getWidth();
		this.alto = getHeight();
	}

	private static int aleatorioEntre(int desde, int hasta) {
		return desde + (int) (Math.random() * (hasta - desde));
	}

	protected void generarNave() {
		this.ancho = getWidth();
		this.alto = getHeight();
		agregar(new NaveDeAtaque(), ancho / 2, 3 * alto / 5);
	}

	protected void generarPOIs() {
		this.ancho = getWidth();
		this.alto = getHeight();
		marcarCelda(ancho / 2, 3 * alto / 5, new Color(0, 0, 200, 150));
	}

	protected void generarItems() {

	}

	protected void generarAsteroides() {
		this.ancho = getWidth();
		this.alto = getHeight();
		int cantidadDeAsteroides = (ancho - 2 + aleatorioEntre(0, ancho)) / 2;
		int offset = (ancho - cantidadDeAsteroides) / 2;

		int posicionMayor = aleatorioEntre(0, cantidadDeAsteroides);
		int mayorVida = 0;
		for (int j = 0; j < cantidadDeAsteroides; j++) {
			if (j != posicionMayor) {
				int vidaActual = 50 + aleatorioEntre(0, 40);
				agregar(new Asteroide(vidaActual), offset + j, 2 * alto / 7);
				if (vidaActual > mayorVida)
					mayorVida = vidaActual;

			}
		}
		agregar(new Asteroide(mayorVida + aleatorioEntre(0, 20)), offset + posicionMayor, 2 * alto / 7);

		this.xAsteroide = posicionMayor + offset;

		agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), xAsteroide, 4 * alto / 5);

		agregar(new Item(), offset, 2 * alto / 7 + 1);
		agregar(new Item(), offset + cantidadDeAsteroides - 1, 2 * alto / 7 + 1);

		agregar(new Item(), xAsteroide, 4 * alto / 5 - 1);
	}
}
