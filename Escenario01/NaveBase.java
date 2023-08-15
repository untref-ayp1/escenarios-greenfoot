import greenfoot.*;

public abstract class NaveBase extends Actor {
    private double ESCALA_X = 1;
    private double ESCALA_Y = 1;
    
    private int combustible;
    private final int MAX_COMBUSTIBLE = 100;
    private GreenfootImage baseImage;
    
    private Direccion direccion;
    
    public NaveBase() {
        this.combustible = MAX_COMBUSTIBLE;
        this.direccion = Direccion.NORTE;
        setRotation(this.direccion.rotacion);
    }
       
    @Override
    protected void addedToWorld(World world) {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
        
        baseImage = getImage();
        updateFuelImage();
    }
    
    private void consumirCombustible() {
        this.combustible-=10;
    }
    
    public void cargarCombustible(int combustible) {
        this.combustible = Math.min(MAX_COMBUSTIBLE, this.combustible + combustible);
        updateFuelImage();
    }
    
    public int obtenerCombustible() {
        return this.combustible;
    }
    
    private double obtenerProporcionDeCombustible() {
        return 1.0 * combustible / MAX_COMBUSTIBLE;
    }
    
    public boolean hayAsteroideHacia(Direccion direccion) {
        return getOneObjectAtOffset(direccion.dx, direccion.dy, Asteroide.class) != null;
    }
    
    public boolean hayItemHacia(Direccion direccion) {
        return getOneObjectAtOffset(direccion.dx, direccion.dy, Item.class) != null;
    }
    
    public boolean hayNaveHacia(Direccion direccion) {
        return getOneObjectAtOffset(direccion.dx, direccion.dy, Nave.class) != null;
    }
    
    protected void moverHacia(Direccion direccion) {
        if (this.combustible <= 0) {
            return;
        }
        
        int x = getX();
        int y = getY();
        
        this.direccion = direccion;
        updateFuelImage();
        setRotation(direccion.rotacion);
        Greenfoot.delay(20);
        
        if (hayAsteroideHacia(direccion) || hayNaveHacia(direccion)) {
            return;
        }
        
        move(1);
        consumirCombustible();
        
        updateFuelImage();
        
        Item item = (Item) getOneObjectAtOffset(0, 0, Item.class);
        if (item != null) {
            this.cargarCombustible(item.serRecogido());
        }
    }
    
    private void updateFuelImage() {
        GreenfootImage txtImg = new GreenfootImage(toString(), 20, Color.BLACK, null, null);
        
        GreenfootImage canvas = new GreenfootImage(baseImage.getWidth(), baseImage.getHeight() + getWorld().getCellSize() / 3);

        canvas.setColor(Color.BLACK);
        canvas.fillRect(2, baseImage.getHeight() - 2, getWorld().getCellSize()-4, getWorld().getCellSize() / 3-4);
        canvas.setColor(Color.YELLOW);

        canvas.fillRect(4, baseImage.getHeight(), (int)((getWorld().getCellSize()-6) * this.obtenerProporcionDeCombustible()) - 2, 8);
        
        canvas.rotate(360 - direccion.rotacion);
        
        canvas.drawImage(baseImage, 0, getWorld().getCellSize()/6);
        setImage(canvas);
    }
}
