import greenfoot.*;

public abstract class PilotoBase extends ActorBase {
    protected double ESCALA_X = 0.8;
    protected double ESCALA_Y = 0.8;

    protected NaveDeAtaque navePilotada;

    public void subirse(NaveDeAtaque nave) {
        navePilotada = nave;
        actualizarImagen();
    }
    
    public void bajarse() {
        navePilotada = null;
        actualizarImagen();
    }
    
    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image;
        if (navePilotada != null) {
            image = new GreenfootImage("ghost.png");
        } else {
            image = new GreenfootImage("pilot.png");
        }
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
    }
}
