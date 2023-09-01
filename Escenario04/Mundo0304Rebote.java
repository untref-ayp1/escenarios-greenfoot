import greenfoot.*;

public class Mundo0304Rebote extends MundoBase {

	public Mundo0304Rebote() {
		super(3, 9);
	}
	
	@Override
	protected void generarNaves() {
		agregar(new NaveDeAtaque(), 1, 8);
	}

	@Override
	protected void generarPOIs() {
		marcarCelda(1, 8, new Color(0, 0, 200, 150));
	}

	@Override
	protected void generarItems() {
		agregar(new Item(), 1, 4);
		agregar(new Item(), 1, 3);
		agregar(new Item(), 1, 2);
	}

	@Override
	protected void generarAsteroides() {
		boolean o = false, x = true;
		boolean[][] asteroides = {
				{ o, x, o },
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
		};
		poblarAsteroidesConMatriz(asteroides);
	}
}
