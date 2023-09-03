import greenfoot.*;

public class Explosion extends ActorBase {
    GifImage gif = new GifImage("explo.gif");

    public void act() {
        setImage(gif.getCurrentImage());
    }

    public void animar() {
        for (int i = 0; i < 35; i++) {
            act();
            Greenfoot.delay(1);
        }
    }

    public static void en(World world, int x, int y) {
        Explosion explosion = new Explosion();
        world.addObject(explosion, x, y);
        Greenfoot.playSound("explosion.wav");
        explosion.animar();
        world.removeObject(explosion);
    }
    
    protected void actualizarImagen() { }
}
