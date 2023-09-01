public class Mundo02 extends MundoBase {

	public Mundo02() {
		super(9, 8);
	}

	@Override
	protected void generarNaves() {
		agregar(new NaveDeAtaque(), 4, 6);
		agregar(new NaveDeAtaque(), 3, 7);
		agregar(new NaveDeAtaque(), 5, 7);

		agregar(new NaveDeAtaqueEnemiga(Direccion.SUR), 5, 2);
		agregar(new NaveDeAtaqueEnemiga(Direccion.SUR), 3, 2);
		agregar(new NaveDeAtaqueEnemiga(Direccion.SUR), 4, 3);
		agregar(new NaveDeAtaqueEnemiga(Direccion.ESTE), 1, 7);

	}

	@Override
	protected void generarItems() {
		agregar(new Item(), 4, 2);
		agregar(new Item(), 4, 1);
		agregar(new Item(), 0, 7);
	}

	@Override
	protected void generarAsteroides() {
		boolean o = false, x = true;
		boolean[][] asteroides = { { o, o, o, o, o, o, o, o, o }, { o, x, x, o, o, o, o, o, o },
				{ o, o, x, o, o, o, x, o, o }, { o, o, o, o, o, o, o, x, x }, { o, o, x, o, o, o, o, o, o },
				{ o, o, o, o, o, o, o, o, o }, { x, o, o, o, o, o, x, o, o }, { o, o, o, o, o, o, o, o, o }, };
		poblarAsteroidesConMatriz(asteroides);
	}
}
