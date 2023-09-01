
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

	private double obtenerProporcionDeSalud() {
		return 1.0 * this.salud / 100;
	}

	@Override
	public void recibirDañoDe(Atacante atacante) {
		int daño = atacante.obtenerDaño();
		this.salud -= daño;
		actualizarImagen();
		explotar();
		if (this.salud <= 0) {
			getWorld().removeObject(this);
		}
	}

	private void explotar() {
		Explosion explosion = new Explosion();
		getWorld().addObject(explosion, this.getX(), getY());
		explosion.animar();
		getWorld().removeObject(explosion);
	}

	protected void actualizarImagen() {
		super.actualizarImagen();
		GreenfootImage txtImg = new GreenfootImage(toString(), 20, Color.BLACK, null, null);

		GreenfootImage canvas = new GreenfootImage(baseImage.getWidth(),
				baseImage.getHeight() + getWorld().getCellSize() / 3);

		canvas.setColor(Color.BLACK);
		canvas.fillRect(2, baseImage.getHeight() - 2, getWorld().getCellSize() - 4, getWorld().getCellSize() / 3 - 4);
		canvas.setColor(Color.RED);

		canvas.fillRect(4, baseImage.getHeight(),
				(int) ((getWorld().getCellSize() - 6) * this.obtenerProporcionDeSalud()) - 2, 8);

		canvas.rotate(360 - direccion.rotacion);

		canvas.drawImage(baseImage, 0, getWorld().getCellSize() / 6);
		setImage(canvas);
	}
}
