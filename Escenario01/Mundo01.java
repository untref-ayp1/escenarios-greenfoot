import greenfoot.*;

public class Mundo01 extends MundoBase {

    public Mundo01() {
        super(10, 8);
    }

    @Override
    protected void generarNaves() {
        Nave centinela = new Nave();
        int posicionEnX = 2;
        int posicionEnY = 6;
        agregar(centinela, posicionEnX, posicionEnY);
        // agrega la nave en la posición 2, 6
    }

    @Override
    protected void generarPOIs() {
        int cell = getCellSize();

        marcarCelda(2, 6, new Color(200, 0, 0, 150));
        marcarCelda(7, 1, new Color(0, 200, 0, 150));
    }

    @Override
    protected void generarItems() {
        Item primerItem = new Item();
        Item segundoItem = new Item();

        agregar(primerItem, 2, 1);
        agregar(segundoItem, 7, 6);
    }

    @Override
    protected void generarAsteroides() {
        boolean f = false, t = true;
        boolean[][] asteroides = { { f, f, f, f, f, f, f, f, f, f }, { f, f, f, f, t, f, f, f, f, f },
                { f, f, f, f, f, f, f, f, f, t }, { f, f, t, f, f, t, f, f, f, f }, { f, t, f, t, f, f, f, f, t, f },
                { f, f, f, f, f, f, t, f, f, f }, { f, f, f, f, f, t, f, f, f, f }, { f, f, f, f, f, f, f, f, f, f }, };
        poblarAsteroidesConMatriz(asteroides);
    }
}
