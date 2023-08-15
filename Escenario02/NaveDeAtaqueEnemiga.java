import greenfoot.*;

public class NaveDeAtaqueEnemiga extends NaveEnemiga implements Atacante {
	public NaveDeAtaqueEnemiga(Direccion direccion) {
		super(direccion);
	}

	public void recibirDañoDe(Atacante atacante) {
		super.recibirDañoDe(atacante);
		Actor actor = (Actor) atacante;
		if (this.salud > 0) {
			Direccion direccion = Direccion.flecha(this.getX(), this.getY(), actor.getX(), actor.getY());
			atacarHacia(direccion);
		}
	}

	@Override
	public int obtenerDaño() {
		return 15;
	}

	private void atacar(Dañable objetivo) {
		objetivo.recibirDañoDe(this);
	}

	public void atacarHacia(Direccion direccion) {
		this.direccion = direccion;
		updateImage();
		setRotation(direccion.rotacion);
		Greenfoot.delay(20);

		Dañable objetivo = (Dañable) getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
		if (objetivo != null) {
			atacar(objetivo);
		}
	}
}
