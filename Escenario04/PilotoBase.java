import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class PilotoBase extends Actor {
    protected double ESCALA_X = 0.8;
    protected double ESCALA_Y = 0.8;
    
    @Override
    protected void addedToWorld(World world) {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
    }
}
