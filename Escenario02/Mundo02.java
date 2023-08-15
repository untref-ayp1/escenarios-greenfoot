import greenfoot.*;

public class Mundo02 extends MundoBase {

	public Mundo02() {
		super(9, 8);
	}

	protected void generarNave() {
		agregar(new NaveDeAtaque(), 4, 6);
		agregar(new NaveDeAtaque(), 3, 7);
		agregar(new NaveDeAtaque(), 5, 7);

		agregar(new NaveDeAtaqueEnemiga(Direccion.SUR), 5, 2);
		agregar(new NaveDeAtaqueEnemiga(Direccion.SUR), 3, 2);
		agregar(new NaveDeAtaqueEnemiga(Direccion.SUR), 4, 3);
		agregar(new NaveDeAtaqueEnemiga(Direccion.ESTE), 1, 7);

	}

	protected void generarPOIs() { }

	protected void generarItems() {
		agregar(new Item(), 4, 2);
		agregar(new Item(), 4, 1);
		agregar(new Item(), 0, 7);
	}

	protected void generarAsteroides() {
		boolean o = false, x = true;
		boolean[][] asteroides = {
				{ o, o, o, o, o, o, o, o, o },
				{ o, x, x, o, o, o, o, o, o },
				{ o, o, x, o, o, o, x, o, o },
				{ o, o, o, o, o, o, o, x, x },
				{ o, o, x, o, o, o, o, o, o },
				{ o, o, o, o, o, o, o, o, o },
				{ x, o, o, o, o, o, x, o, o },
				{ o, o, o, o, o, o, o, o, o },
			};
		poblarAsteroides(asteroides);
	}
}
