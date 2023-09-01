import greenfoot.*;

public class Mundo09Aleatorio extends MundoBase {
    
    public Mundo09Aleatorio() {
        super(aleatorioEntre(10, 18), aleatorioEntre(8, 14));        
        generarTodo();
    }

    private static int aleatorioEntre(int desde, int hasta) {
        return desde + (int) (Math.random() * (hasta - desde));
    }
    
    @Override
    protected void generarPOIs() {
        int ancho = getWidth();
        int alto = getHeight();

        int xNaveAliada = ancho / 2;
        int yNaveAliada = 3 * alto / 5;
        
        marcarCelda(xNaveAliada, yNaveAliada, new Color(0, 0, 200, 150));
    }
    
    private void generarTodo() {
        int ancho = getWidth();
        int alto = getHeight();

        int xNaveAliada = ancho / 2;
        int yNaveAliada = 3 * alto / 5;
        
        agregar(new NaveDeAtaque(), xNaveAliada, yNaveAliada);
        
        int cantidadDeAsteroides = (ancho - 2 + aleatorioEntre(0, ancho)) / 2;
        int posicionPrimerAsteroide = (ancho - cantidadDeAsteroides) / 2;

        int posicionMayor = aleatorioEntre(0, cantidadDeAsteroides);
        int vidaMayor = 0;
        int yAsteroides = 2 * alto / 7;

        for (int j = 0; j < cantidadDeAsteroides; j++) {
            if (j != posicionMayor) {
                int vidaActual = 50 + aleatorioEntre(0, 40);
                agregar(new Asteroide(vidaActual), posicionPrimerAsteroide + j, yAsteroides);
                vidaMayor = Math.max(vidaActual, vidaMayor);
            }
        }
        int xAsteroide = posicionMayor + posicionPrimerAsteroide;
        agregar(new Asteroide(vidaMayor + aleatorioEntre(0, 20)), xAsteroide, yAsteroides);

        int yNaveEnemiga = 4 * alto / 5;
        agregar(new NaveDeAtaqueEnemiga(Direccion.NORTE), xAsteroide, yNaveEnemiga);

        agregar(new Item(), posicionPrimerAsteroide, yAsteroides + 1);
        agregar(new Item(), posicionPrimerAsteroide + cantidadDeAsteroides - 1, yAsteroides + 1);

        agregar(new Item(), xAsteroide, yNaveEnemiga - 1);
    }
}
