/**
 * Define el tipo de Nave más elemental de la Batalla Espacial. Sólo puede
 * explorar mediante ordenes simples, y no tiene conocimiento del entorno
 */
public class NaveExploradora extends NaveAliada {
	/**
	 * pre: el casillero hacia {@link Direccion#NORTE} está disponible para ser
	 * ocupado <br>
	 * post: La NaveExploradora se mueve en {@link Direccion#NORTE}
	 */
	public void moverAlNorte() {
		moverHacia(Direccion.NORTE);
	}

	/**
	 * pre: el casillero hacia {@link Direccion#ESTE} está disponible para ser
	 * ocupado <br>
	 * post: La NaveExploradora se mueve en {@link Direccion#ESTE}
	 */
	public void moverAlEste() {
		moverHacia(Direccion.ESTE);
	}

	/**
	 * pre: el casillero hacia {@link Direccion#OESTE} está disponible para ser
	 * ocupado <br>
	 * post: La NaveExploradora se mueve en {@link Direccion#OESTE}
	 */
	public void moverAlOeste() {
		moverHacia(Direccion.OESTE);
	}

	/**
	 * pre: el casillero hacia {@link Direccion#SUR} está disponible para ser
	 * ocupado <br>
	 * post: La NaveExploradora se mueve en {@link Direccion#SUR}
	 */
	public void moverAlSur() {
		moverHacia(Direccion.SUR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int obtenerCombustible() {
		return super.obtenerCombustible();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	int obtenerCombustibleMaximo() {
		return 100;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	int obtenerConsumoPorMovimiento() {
		return 5;
	}
}
