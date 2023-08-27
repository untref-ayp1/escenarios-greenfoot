import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piloto extends Actor {
    protected double ESCALA_X = 0.8;
    protected double ESCALA_Y = 0.8;
    
    @Override
    protected void addedToWorld(World world) {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
    }
    
    NaveDeAtaque navePilotada;
    
    void subirse(NaveDeAtaque nave) {
        navePilotada = nave;
    }
    void despegar() {
        navePilotada.avanzarHacia(Direccion.NORTE);
    }
}
