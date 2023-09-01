import greenfoot.*;

public class Asteroide extends Actor implements Dañable {
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
		explotar();
		if (this.vida <= 0) {
			getWorld().removeObject(this);
		}
	}

	protected void explotar() {
		Explosion x = new Explosion();
		getWorld().addObject(x, this.getX(), getY());
		x.animar();
		getWorld().removeObject(x);
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

	@Override
	protected void addedToWorld(World world) {
		actualizarImagen();
	}

	protected int obtenerTamañoMaximo() {
		return 100;
	}

	int obtenerVida() {
		return this.vida;
	}
}
