import greenfoot.*;

public class Mundo05ZigZag extends MundoBase {

	public Mundo05ZigZag() {
		super(9, 8);
	}

	protected void generarNave() {
		agregar(new NaveDeAtaque(), 4, 7);
	}

	protected void generarPOIs() {
		marcarCelda(4, 7, new Color(0, 0, 200, 150));
		marcarCelda(1, 1, new Color(200, 200, 0, 150));
	}

	protected void generarItems() {
		agregar(new Item(), 7, 1);
	}

	protected void generarAsteroides() {
		boolean[][] asteroides = {};
		poblarAsteroides(asteroides);
	}
}
