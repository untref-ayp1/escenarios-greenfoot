import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piloto05 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piloto05 extends PilotoBase {

	NaveDeAtaque nave;

	void subirse(NaveDeAtaque nave) {
		this.nave = nave;
	}

	void avanzarPorHacia(int casilleros, Direccion direccion) {
		for (int pasos = 0; pasos < casilleros; pasos++) {
			nave.avanzarHacia(direccion);
		}
	}

	void maniobrar() {

		nave.encenderMotores();

		int movimientos = 1;
		for (int i = 0; i < 3; i++) {
			nave.avanzarHacia(Direccion.NORTE);
			avanzarPorHacia(movimientos, Direccion.ESTE);
			movimientos++;
			nave.avanzarHacia(Direccion.NORTE);
			avanzarPorHacia(movimientos, Direccion.OESTE);
			movimientos++;
		}

		/*
		 * nave.avanzarHacia(Direccion.NORTE); avanzarPorHacia(1, Direccion.ESTE);
		 * 
		 * nave.avanzarHacia(Direccion.NORTE); avanzarPorHacia(2, Direccion.OESTE);
		 * 
		 * nave.avanzarHacia(Direccion.NORTE); avanzarPorHacia(3, Direccion.ESTE);
		 * 
		 * nave.avanzarHacia(Direccion.NORTE); avanzarPorHacia(4, Direccion.OESTE);
		 * 
		 * nave.avanzarHacia(Direccion.NORTE); avanzarPorHacia(5, Direccion.ESTE);
		 * 
		 * nave.avanzarHacia(Direccion.NORTE); avanzarPorHacia(6, Direccion.OESTE);
		 */
	}
}
