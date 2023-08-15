import greenfoot.*;

public class Item extends Actor {
    private double ESCALA_X = 0.9;
    private double ESCALA_Y = 0.9;
       
    @Override
    protected void addedToWorld(World world) {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
    }

    public void act() {
        // Nada
    }
    
    public int serRecogido() {
        getWorld().removeObject(this);
        Greenfoot.delay(20);
        return 100;
    }
}
