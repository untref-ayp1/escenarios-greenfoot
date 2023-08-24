import greenfoot.*;

public class Mundo03 extends MundoBase {

    public Mundo03() {
        super(9, 8);
    }

    protected void generarNave() {
        agregar(new NaveDeAtaque(), 4, 4);

        agregar(new NaveDeAtaqueEnemiga(Direccion.ESTE, 28), 1, 2);
        agregar(new NaveDeAtaqueEnemiga(Direccion.ESTE), 2, 3);
        agregar(new NaveDeAtaqueEnemiga(Direccion.SUR, 76), 5, 2);
        agregar(new NaveDeAtaqueEnemiga(Direccion.OESTE, 32), 7, 6);

    }

    protected void generarPOIs() {
        marcarCelda(4, 4, new Color(0, 0, 200, 150));
    }

    protected void generarItems() {
        agregar(new Item(), 1, 1);
        agregar(new Item(), 1, 5);
        agregar(new Item(), 8, 6);
    }

    protected void generarAsteroides() {
        boolean o = false, x = true;
        boolean[][] asteroides = {
                { o, o, o, o, o, o, o, o, o },
                { x, o, o, o, o, o, o, x, o },
                { o, o, o, o, o, o, x, o, o },
                { o, x, o, o, o, o, o, o, o },
                { o, o, o, o, o, o, x, x, x },
                { o, o, o, o, o, o, o, o, o },
                { o, o, o, x, o, o, o, o, o },
                { o, x, o, o, o, o, o, o, o },
            };
        poblarAsteroides(asteroides);
    }
}
