import greenfoot.*;

public class Asteroide extends Actor {
    public void act() {

    }

    @Override
    protected void addedToWorld(World world) {
        GreenfootImage image = getImage();
        setImage(image);
        setRotation((int) (Math.random() * 360));
    }
}
