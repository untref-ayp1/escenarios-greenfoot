import greenfoot.*;

public abstract class NaveAliada extends NaveBase {
    protected int combustible;

    public NaveAliada() {
        super();
        this.combustible = obtenerCombustibleMaximo();
    }

    abstract int obtenerCombustibleMaximo();
    abstract int obtenerConsumoPorMovimiento();
    
    public void recibirDañoDe(Atacante atacante) {
        int daño = atacante.obtenerDaño();
        this.combustible -= daño;
        updateImage();
        explotar();
        if (this.combustible <= 0) {
            getWorld().removeObject(this);
        }
    }

    private void explotar() {
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion, this.getX(), getY());
        explosion.animar();
        getWorld().removeObject(explosion);
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);

        baseImage = getImage();
        updateImage();
    }

    protected void consumirCombustible(int cantidad) {
        this.combustible -= cantidad;
        updateImage();
    }

    public void cargarCombustible(int combustible) {
        this.combustible = Math.min(obtenerCombustibleMaximo(), this.combustible + combustible);
        updateImage();
    }

    public int obtenerCombustible() {
        return this.combustible;
    }

    private double obtenerProporcionDeCombustible() {
        return 1.0 * combustible / obtenerCombustibleMaximo();
    }

    protected boolean moverHacia(Direccion direccion) {
        if (!super.moverHacia(direccion)) {
            return false;
        }
        consumirCombustible(obtenerConsumoPorMovimiento());

        Item item = (Item) getOneObjectAtOffset(0, 0, Item.class);
        if (item != null) {
            this.cargarCombustible(item.serRecogido());
        }
        return true;
    }

    protected void updateImage() {
        GreenfootImage canvas = new GreenfootImage(baseImage.getWidth(),
                baseImage.getHeight() + getWorld().getCellSize() / 3);

        canvas.setColor(Color.BLACK);
        canvas.fillRect(2, baseImage.getHeight() - 2, getWorld().getCellSize() - 4, getWorld().getCellSize() / 3 - 4);
        canvas.setColor(Color.YELLOW);

        canvas.fillRect(4, baseImage.getHeight(),
                (int) ((getWorld().getCellSize() - 6) * this.obtenerProporcionDeCombustible()) - 2, 8);

        canvas.rotate(360 - direccion.rotacion);

        canvas.drawImage(baseImage, 0, getWorld().getCellSize() / 6);
        setImage(canvas);
    }

    public boolean hayAsteroideHacia(Direccion direccion) {
        return super.hayActorHacia(Asteroide.class, direccion);
    }

    public boolean hayItemHacia(Direccion direccion) {
        return super.hayActorHacia(Item.class, direccion);
    }

    public boolean hayNaveHacia(Direccion direccion) {
        return super.hayActorHacia(NaveBase.class, direccion);
    }
}
