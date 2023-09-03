public abstract class NaveAliada extends NaveBase {
    protected int combustible;

    public NaveAliada() {
        super();
        this.combustible = obtenerCombustibleMaximo();
    }

    abstract int obtenerCombustibleMaximo();

    abstract int obtenerConsumoPorMovimiento();

    public void recibirCombustible(int cantidad) {
        this.combustible = Math.min(this.combustible + cantidad, obtenerCombustibleMaximo());
        actualizarImagen();
    }

    public void recibirDañoDe(Atacante atacante) {
        int daño = atacante.obtenerDaño();
        this.combustible -= daño;
        actualizarImagen();
        Explosion.en(getWorld(), this.getX(), this.getY());
        if (this.combustible <= 0) {
            getWorld().removeObject(this);
        }
    }

    protected void consumirCombustible(int cantidad) {
        this.combustible -= cantidad;
        actualizarImagen();
    }

    public void cargarCombustible(int combustible) {
        this.combustible = Math.min(obtenerCombustibleMaximo(), this.combustible + combustible);
        actualizarImagen();
    }

    public int obtenerCombustible() {
        return this.combustible;
    }

    protected double obtenerProporcionDeIndicador() {
        return 1.0 * combustible / obtenerCombustibleMaximo();
    }

    protected boolean puedeActuar() {
        return this.combustible > 0;
    }

    protected boolean moverHacia(Direccion direccion) {
        if (!puedeActuar() || this.combustible < obtenerConsumoPorMovimiento()) {
            return false;
        }
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
