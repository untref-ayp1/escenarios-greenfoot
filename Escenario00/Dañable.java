/**
 * Define cómo se efectuarán los daños en la Batalla
 */
public interface Dañable {
	/**
	 * post: el Dañable recibe una cierta cantidad de daño de un {@link Atacante},
	 * definida por {@link Atacante#obtenerDaño()}
	 * 
	 * @param atacante es quien efectuará el daño que se recibirá
	 */
	public void recibirDañoDe(Atacante atacante);
}
