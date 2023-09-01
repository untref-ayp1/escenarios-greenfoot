
import greenfoot.*;

public class NaveDeAtaque extends NaveAliada implements Atacante {
	boolean motoresEncendidos = false;

	public NaveDeAtaque() {
		super();
	}

	public NaveDeAtaque(Direccion direccion, int combustible) {
		super();

		this.direccion = direccion;
		setRotation(direccion.rotacion);

		this.combustible = combustible;
	}

	void encenderMotores() {
		if (this.combustible > 0) {
			this.motoresEncendidos = true;
			int tamCelda = getWorld().getCellSize();
			baseImage = new GreenfootImage("weaponized-ship-on.png");
			baseImage.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
			actualizarImagen();
		}
	}

	void apagarMotores() {
		this.motoresEncendidos = false;
		int tamCelda = getWorld().getCellSize();
		baseImage = new GreenfootImage("weaponized-ship.png");
		baseImage.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
		actualizarImagen();
	}

	public boolean estaEnElBorde() {
		return isAtEdge();
	}

	public boolean hayVacioHacia(Direccion direccion) {
		int width = getWorld().getWidth() - 1;
		int height = getWorld().getHeight() - 1;
		int x = getX();
		int y = getY();

		switch (direccion) {
		case NORTE:
			return y == 0;
		case SUR:
			return y == height;
		case ESTE:
			return x == width;
		case OESTE:
			return x == 0;
		}
		return false;
	}

	@Override
	public int obtenerDaño() {
		return 35;
	}

	@Override
	int obtenerConsumoPorMovimiento() {
		return 7;
	}

	@Override
	int obtenerCombustibleMaximo() {
		return 150;
	}

	int obtenerConsumoPorAtaque() {
		return 10;
	}

	protected boolean puedeActuar() {
		return super.puedeActuar() && this.motoresEncendidos;
	}

	protected void consumirCombustible(int cantidad) {
		super.consumirCombustible(cantidad);
		if (combustible <= 0) {
			this.apagarMotores();
		}
	}

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
			objetivo.recibirDañoDe(this);
		}
	}

	public void avanzarHacia(Direccion direccion) {
		if (!puedeActuar()) {
			return;
		}
		super.moverHacia(direccion);
	}

	public int obtenerCombustible() {
		return super.obtenerCombustible();
	}

	public boolean hayAsteroideHacia(Direccion direccion) {
		return super.hayAsteroideHacia(direccion);
	}

	public boolean hayItemHacia(Direccion direccion) {
		return super.hayItemHacia(direccion);
	}

	public boolean hayNaveHacia(Direccion direccion) {
		return super.hayNaveHacia(direccion);
	}
}
