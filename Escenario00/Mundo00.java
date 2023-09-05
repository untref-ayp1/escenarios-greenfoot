import greenfoot.*;

public class Mundo00 extends MundoBase {

    public Mundo00() {
        super(6, 5, 100);
    }

    protected void generarNaves() {
        agregar(new NaveExploradora(), 1, 0);
        agregar(new NaveDeAtaque(), 2, 1);
        agregar(new NaveRecolectora(), 3, 2);

        agregar(new NaveExploradoraEnemiga(Direccion.NORTE), 4, 0);
        agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), 5, 1);

        agregar(new PilotoDeEjemplo(), 0, 4);
    }

    protected void generarPOIs() {
        marcarCelda(0, 0, new Color(0, 0, 200, 150));
    }

    protected void generarItems() {
        agregar(new Item(), 0, 1);
    }

    protected void generarAsteroides() {
        agregar(new Asteroide(), 0, 2);
        agregar(new AsteroideDeMineral(), 0, 3);
    }
}
