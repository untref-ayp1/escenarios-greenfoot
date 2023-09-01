import greenfoot.*;

public class Mundo00Diapositiva extends MundoBase {

	public Mundo00Diapositiva() {
		super(3, 11);
	}

	@Override
	protected void generarNaves() {
		agregar(new NaveDeAtaque(), 1, 9);
	}

	@Override
	protected void generarPOIs() {
		marcarCelda(1, 9, new Color(0, 0, 200, 150));
		marcarCelda(1, 1, new Color(200, 200, 0, 150));
	}

	@Override
	protected void generarItems() {
		agregar(new Item(), 1, 4);
	}

	@Override
	protected void generarAsteroides() {
		boolean o = false, x = true;
		boolean[][] asteroides = {
				{ o, o, o },
				{ o, o, o },
				{ o, o, o },
				{ o, x, o },
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
