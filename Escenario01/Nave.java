import greenfoot.*;

public class Nave extends NaveBase {
    public void act() {
        // Nada, por ahora
    }
    
    public void moverAlNorte() {
        moverHacia(Direccion.NORTE);
    }
    
    public void moverAlEste() {
        moverHacia(Direccion.ESTE);
    }
    
    public void moverAlOeste() {
        moverHacia(Direccion.OESTE);
    }
    
    public void moverAlSur() {
        moverHacia(Direccion.SUR);
    }
    
    public int obtenerCombustible() {
        return super.obtenerCombustible();
    }
    
    public boolean hayAsteroideHacia(Direccion direccion) {
        return super.hayAsteroideHacia(direccion);
    }
    
    public boolean hayItemHacia(Direccion direccion) {
        return super.hayItemHacia(direccion);
    }
    
    public boolean hayNaveHacia(Direccion direccion) {
        return super.hayNaveHacia(direccion);
    }
}
