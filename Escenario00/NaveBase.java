import greenfoot.*;

public abstract class NaveBase extends ActorBase implements Dañable {
    protected double ESCALA_X = 1;
    protected double ESCALA_Y = 1;

    protected Direccion direccion;
    protected GreenfootImage baseImage;

    public NaveBase() {
        this(Direccion.NORTE);
    }

    public NaveBase(Direccion direccion) {
        setDireccion(direccion);
        baseImage = getImage();
    }

    protected void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        setRotation(this.direccion.rotacion);
    }

    @Override
    protected void addedToWorld(World world) {
        baseImage = getImage();
        super.addedToWorld(world);
    }

    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
        
        // todo esto se puede borrar?
        
        GreenfootImage canvas = new GreenfootImage(baseImage.getWidth(),
                baseImage.getHeight() + getWorld().getCellSize() / 3);

        canvas.setColor(Color.BLACK);
        canvas.fillRect(4, baseImage.getHeight() - 2, getWorld().getCellSize() - 6, 12);
        canvas.setColor(colorDeBarra());

        canvas.fillRect(6, baseImage.getHeight(),
                (int) ((getWorld().getCellSize() - 10) * obtenerProporcionDeIndicador()), 8);

        canvas.rotate(360 - direccion.rotacion);

        canvas.drawImage(baseImage, 0, getWorld().getCellSize() / 6);
        setImage(canvas);
        
    }

	protected Color colorDeBarra() {
		return Color.YELLOW;
	}

    protected abstract double obtenerProporcionDeIndicador();

	public boolean hayActorHacia(Class<? extends Actor> clazz, Direccion direccion) {
        return getOneObjectAtOffset(direccion.dx, direccion.dy, clazz) != null;
    }

    protected boolean moverHacia(Direccion direccion) {
        setDireccion(direccion);
        actualizarImagen();
        Greenfoot.delay(20);

        if (hayActorHacia(Asteroide.class, direccion) || hayActorHacia(NaveBase.class, direccion)) {
            return false;
        }

        move(1);
        return true;
    }
}
