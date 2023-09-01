import greenfoot.*;

public abstract class ActorBase extends Actor {
	@Override
	protected void addedToWorld(World world) {
		actualizarImagen();
	}

	protected abstract void actualizarImagen();
}
