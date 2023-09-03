
import greenfoot.*;

public abstract class NaveEnemiga extends NaveBase {
	protected int salud = 100;

	public NaveEnemiga(Direccion direccion) {
		super(direccion);
	}

	@Override
	protected void addedToWorld(World world) {
		baseImage = getImage();
		super.addedToWorld(world);
	}

	protected double obtenerProporcionDeIndicador() {
		return 1.0 * this.salud / 100;
	}

	@Override
	public void recibirDañoDe(Atacante atacante) {
		int daño = atacante.obtenerDaño();
		this.salud -= daño;
		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
		if (this.salud <= 0) {
			getWorld().removeObject(this);
		}
	}

	@Override
	protected Color colorDeBarra() {
		return Color.RED;
	}
}
