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

	protected void actualizarImagen() {
	}
}
