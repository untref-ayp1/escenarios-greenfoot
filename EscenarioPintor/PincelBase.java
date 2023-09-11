import greenfoot.*;

/**
 * Representación de los pinceles en el EscenarioPintor
 */
public abstract class PincelBase extends Actor {
    private Lienzo lienzo;
    private Tinta tinta;
    
    /**
     * Construye un Pincel por defecto, color Tinta.LILA
     */
    public PincelBase() {
        this(Tinta.LILA);
    }
    
    /**
     * Permite construir un Pincel con tinta de algún color
     */
    public PincelBase(Tinta tinta) {
        this.tinta = tinta;
    }
    
    /**
     * Dibuja el pincel, en escala con el escenario
     */
    public void addedToWorld(World world) {
        this.lienzo = (Lienzo) world;
        
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale(tamCelda, tamCelda);
        setImage(image);
        
    }
    
    /**
     * Punto de extensión para escribir el algoritmo de pintado
     */
    public abstract void pintar();
    
    /**
     * Pinta una celda. Es el método que hay que utilizar desde
     * el Pincel concreto que se cree.
     * <br>
     * post: La celda (i, j) recibirá una capa de pintura
     */
    protected final void pintar(int i, int j) {
        GreenfootSound sound = new GreenfootSound("brush.wav");
        sound.play();

        this.setLocation(i, j);
        lienzo.marcarCelda(i, j, tinta.color);

        Greenfoot.delay(40);
        sound.stop();
        
    }
    
    /**
     * @return el tamaño del lienzo
     */
    protected int obtenerTamañoDelLienzo() {
        return this.lienzo.getWidth();
    }
}
