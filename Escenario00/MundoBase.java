import greenfoot.*;

public abstract class MundoBase extends World {

    public MundoBase(int ancho, int alto) {
        this(ancho, alto, 60);
    }
    
    public MundoBase(int ancho, int alto, int tamañoCelda) {
        super(ancho, alto, tamañoCelda);

        generarPOIs();
        generarGrilla();

        generarAsteroides();
        generarItems();

        generarNaves();
    }

    protected void generarPOIs() { }

    protected void generarGrilla() {
        int cell = getCellSize();

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                getBackground().setColor(Color.WHITE);
                getBackground().drawRect(x * cell, y * cell, cell, cell);
                if ((x + y) % 2 == 0)
                    marcarCelda(x, y, new Color(255, 255, 255, 40));
            }
        }

        for (int x = 0; x < getWidth(); x++) {
            String columnName = "" + (char) ('A' + x);
            GreenfootImage columnNameImage = new GreenfootImage(columnName, 15, Color.WHITE, null);
            getBackground().drawImage(columnNameImage, x * cell + cell / 2 - 4, 2);
        }

        for (int y = 0; y < getHeight(); y++) {
            String columnName = y + 1 + "";
            GreenfootImage columnNameImage = new GreenfootImage(columnName, 15, Color.WHITE, null);
            getBackground().drawImage(columnNameImage, 2, y * cell + cell / 2 - 4);
        }
    }

    protected void generarAsteroides() { }

    protected void generarItems() { }

    protected void generarNaves() { }

    protected void marcarCelda(int x, int y, Color color) {
        int cell = getCellSize();
        getBackground().setColor(color);
        getBackground().fillRect(x * cell, y * cell, cell, cell);
    }

    protected void agregar(Actor actor, int x, int y) {
        addObject(actor, x, y);
    }

    protected void poblarAsteroidesConMatriz(boolean[][] asteroides) {
        for (int i = 0; i < asteroides.length; i++) {
            for (int j = 0; j < asteroides[i].length; j++) {
                if (asteroides[i][j])
                    agregar(new Asteroide(), j, i);
            }
        }
    }
}
