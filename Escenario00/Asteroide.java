import greenfoot.*;

public class Asteroide extends ActorBase implements Dañable {
	protected int vida;

	public Asteroide() {
		this.vida = 51 + (int) (Math.random() * 50);
	}

	public Asteroide(int vida) {
		this.vida = vida;
	}

	public void recibirDañoDe(Atacante atacante) {
		int daño = atacante.obtenerDaño();
		this.vida -= daño;
		actualizarImagen();
		Explosion.en(getWorld(), this.getX(), this.getY());
		if (this.vida <= 0) {
			getWorld().removeObject(this);
		}
	}

	public void actualizarImagen() {
		int tamCelda = getWorld().getCellSize();
		int ancho = Math.max(30, (tamCelda * vida) / obtenerTamañoMaximo());
		GreenfootImage image = getImage();
		if (this.vida <= 0)
			image.setTransparency(0);
		image.scale(ancho, ancho);
		setImage(image);
		setRotation((int) (Math.random() * 360));
	}

	protected int obtenerTamañoMaximo() {
		return 100;
	}

	int obtenerVida() {
		return this.vida;
	}
}
