import greenfoot.*;

public class Mundo05ZigZag extends MundoBase {

	public Mundo05ZigZag() {
		super(9, 8);
	}

	@Override
	protected void generarNaves() {
		agregar(new NaveDeAtaque(), 4, 7);
	}

	@Override
	protected void generarPOIs() {
		marcarCelda(4, 7, new Color(0, 0, 200, 150));
		marcarCelda(1, 1, new Color(200, 200, 0, 150));
	}

	@Override
	protected void generarItems() {
		agregar(new Item(), 7, 1);
	}
}
