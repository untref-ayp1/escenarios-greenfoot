
import greenfoot.*;

public class NaveDeAtaque extends NaveAliada implements Atacante {

	/**
	 * Representa el estado de los motores de la {@link NaveDeAtaque}.
	 */
	protected boolean motoresEncendidos = false;

	/**
	 * Inicializa una nueva NaveDeAtaque con los motores apagados
	 */
	public NaveDeAtaque() {
		super();
	}

	/**
	 * Inicializa una nueva NaveDeAtaque con los motores apagados. Este constructor
	 * es empleado mayormente para la creación de escenarios.
	 * 
	 * @param direccion es la orientación con la que se creará la NaveDeAtaque
	 * @param carga     es la carga de combustible inicial de la NaveDeAtaque
	 */
	public NaveDeAtaque(Direccion direccion, int carga) {
		super();
		setDireccion(direccion);
		this.combustible = carga;
	}

	/**
	 * pre: posee combustible {@link NaveAliada#combustible} y los motores se
	 * encuentran apagados {@link NaveDeAtaque#motoresEncendidos} <br/>
	 * post: encenderá sus motores
	 */
	public void encenderMotores() {
		if (this.combustible > 0 && !this.motoresEncendidos) {
			this.motoresEncendidos = true;
			Greenfoot.playSound("engine-on.wav");
			int tamCelda = getWorld().getCellSize();
			baseImage = new GreenfootImage("weaponized-ship-on.png");
			baseImage.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
			actualizarImagen();
		}
	}

	/**
	 * pre: los motores se encuentran encendidos
	 * {@link NaveDeAtaque#motoresEncendidos} <br/>
	 * post: apagará sus motores
	 */
	public void apagarMotores() {
		if (this.motoresEncendidos) {
			this.motoresEncendidos = false;
			Greenfoot.playSound("engine-off.wav");
			int tamCelda = getWorld().getCellSize();
			baseImage = new GreenfootImage("weaponized-ship.png");
			baseImage.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
			actualizarImagen();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean puedeActuar() {
		return super.puedeActuar() && this.motoresEncendidos;
	}

	/**
	 * {@inheritDoc} <br>
	 * post: si se agota el {@link NaveAliada#combustible}, se apagarán los motores
	 */
	protected void consumirCombustible(int cantidad) {
		super.consumirCombustible(cantidad);
		if (combustible <= 0) {
			this.apagarMotores();
		}
	}

	/**
	 * pre: La NaveDeAtaque {@link #puedeActuar()} <br>
	 * post: El {@link NaveAliada#combustible} se reducirá en
	 * {@link #obtenerConsumoPorAtaque()}. Si en la dirección deseada hay un
	 * {@link Dañable}, éste recibirá {@link #obtenerDaño()}.
	 * 
	 * @param direccion
	 */
	public void atacarHacia(Direccion direccion) {
		if (!puedeActuar()) {
			return;
		}
		this.direccion = direccion;
		actualizarImagen();
		setRotation(direccion.rotacion);
		Greenfoot.delay(20);
		consumirCombustible(obtenerConsumoPorAtaque());

		Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
		if (!(actor instanceof Dañable)) {
			return;
		}
		Dañable objetivo = (Dañable) actor;
		if (objetivo != null) {
			Greenfoot.playSound("laser-shot.wav");
			objetivo.recibirDañoDe(this);
		}
	}

	/**
	 * {@see NaveAliada#moverHacia(Direccion)}
	 */
	public void avanzarHacia(Direccion direccion) {
		super.moverHacia(direccion);
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
		return 150;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int obtenerDaño() {
		return 35;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	int obtenerConsumoPorMovimiento() {
		return 7;
	}

	/**
	 * @return la cantidad de combustible que consume realizar un ataque
	 */
	int obtenerConsumoPorAtaque() {
		return 10;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean estaEnElBorde() {
		return super.estaEnElBorde();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hayVacioHacia(Direccion direccion) {
		return super.hayVacioHacia(direccion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hayAsteroideHacia(Direccion direccion) {
		return super.hayAsteroideHacia(direccion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hayItemHacia(Direccion direccion) {
		return super.hayItemHacia(direccion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hayNaveHacia(Direccion direccion) {
		return super.hayNaveHacia(direccion);
	}
}
