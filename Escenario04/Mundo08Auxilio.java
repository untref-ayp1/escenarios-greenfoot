import greenfoot.*;

public class Mundo08Auxilio extends MundoBase {

    public Mundo08Auxilio() {
        super(3, 9);
    }

    protected void generarNave() {
        agregar(new NaveRecolectora(), 1, 6);
        
        agregar(new NaveDeAtaque(Direccion.SUR, 0), 0, 8);
        agregar(new NaveDeAtaque(Direccion.SUR, 0), 1, 8);
        agregar(new NaveDeAtaque(Direccion.SUR, 0), 2, 8);
    }

    protected void generarPOIs() {
        marcarCelda(1, 8, new Color(0, 0, 200, 150));
    }

    protected void generarItems() {
    }

    protected void generarAsteroides() {
        agregar(new Mineral(500), 2, 0);
        agregar(new Mineral(100), 0, 6);
    }
}
