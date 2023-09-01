import greenfoot.*;

public class Mundo0607Espiral extends MundoBase {

	public Mundo0607Espiral() {
		super(13, 14);
	}

	@Override
	protected void generarNaves() {
		agregar(new NaveDeAtaque(), 6, 7);
	}

	@Override
	protected void generarPOIs() {
		marcarCelda(6, 7, new Color(0, 0, 200, 150));
		marcarCelda(6, 3, new Color(200, 200, 0, 150));
		marcarCelda(6, 1, new Color(250, 250, 0, 150));
	}

	@Override
	protected void generarItems() {
		agregar(new Item(), 4, 8);
		agregar(new Item(), 9, 9);
		agregar(new Item(), 3, 3);

		agregar(new Item(), 1, 1);
		agregar(new Item(), 2, 2);
		agregar(new Item(), 10, 3);
		agregar(new Item(), 11, 2);
		agregar(new Item(), 2, 11);
		agregar(new Item(), 1, 12);
		agregar(new Item(), 10, 11);
		agregar(new Item(), 11, 12);
	}
}
