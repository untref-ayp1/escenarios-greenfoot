import greenfoot.*;

public class NaveDeAtaque extends NaveAliada implements Atacante {

    @Override
    public int obtenerDaño() {
        return 35;
    }
    
    @Override
    int obtenerConsumoPorMovimiento() {
    	return 15;
    }

    @Override
    int obtenerCombustibleMaximo() {
        return 150;
    }
    
    int obtenerConsumoPorAtaque() {
    	return 10;
    }
    
    public void atacarHacia(Direccion direccion) {
        if (this.combustible <= 0) {
            return;
        }
        this.direccion = direccion;
        updateImage();
        setRotation(direccion.rotacion);
        Greenfoot.delay(20);

        Dañable objetivo = (Dañable) getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
        if (objetivo != null) {
            objetivo.recibirDañoDe(this);
        }

        consumirCombustible(obtenerConsumoPorAtaque());
    }

    public void avanzarHacia(Direccion direccion) {
        super.moverHacia(direccion);
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
