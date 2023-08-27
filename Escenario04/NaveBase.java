import greenfoot.*;

public abstract class NaveBase extends Actor implements Dañable {
	protected double ESCALA_X = 1;
	protected double ESCALA_Y = 1;

	protected Direccion direccion;
	protected GreenfootImage baseImage;

	public NaveBase() {
		this(Direccion.NORTE);
	}

	public NaveBase(Direccion direccion) {
		this.direccion = direccion;
		setRotation(this.direccion.rotacion);
	}

	@Override
	protected void addedToWorld(World world) {
		int tamCelda = getWorld().getCellSize();
		GreenfootImage image = getImage();
		image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
		setImage(image);
	}

	public boolean hayActorHacia(Class<? extends Actor> clazz, Direccion direccion) {
		return getOneObjectAtOffset(direccion.dx, direccion.dy, clazz) != null;
	}

	protected boolean moverHacia(Direccion direccion) {
		this.direccion = direccion;
		updateImage();
		setRotation(direccion.rotacion);
		Greenfoot.delay(20);

		if (hayActorHacia(Asteroide.class, direccion) || hayActorHacia(NaveBase.class, direccion)) {
			return false;
		}

		move(1);
		return true;
	}

	protected void updateImage() {
	}
}
