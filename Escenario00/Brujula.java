import greenfoot.*;

/**
 * Representa una Brujula en pantalla. Sirve como ayuda visual al usuario.
 */
public class Brujula extends ActorBase {
    private double ESCALA_X = 0.9;
    private double ESCALA_Y = 0.9;

    /**
	 * Permite escalar la imagen de la Brujula.
	 */
    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);
    }
}
