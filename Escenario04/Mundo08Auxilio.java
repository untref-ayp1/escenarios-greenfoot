import greenfoot.*;

public class Mundo08Auxilio extends MundoBase {

	public Mundo08Auxilio() {
		super(3, 12);
	}

	@Override
	protected void generarNaves() {
		agregar(new NaveRecolectora(), 1, 6);

		agregar(new NaveDeAtaque(Direccion.SUR, 0), 0, 7);
		agregar(new NaveDeAtaque(Direccion.SUR, 0), 1, 8);
		agregar(new NaveDeAtaque(Direccion.SUR, 0), 2, 7);

		agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), 0, 11);
		agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), 1, 10);
		agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), 2, 11);
	}

	@Override
	protected void generarPOIs() {
		marcarCelda(1, 6, new Color(0, 0, 200, 150));
	}

	@Override
	protected void generarAsteroides() {
		agregar(new AsteroideDeMineral(500), 2, 0);
		agregar(new AsteroideDeMineral(100), 0, 6);
	}
}
