import greenfoot.*;

public class NaveDeAtaque extends NaveAliada implements Atacante {

    public void act() {
        String key = Greenfoot.getKey();
        if (key != null) {
            boolean check = false;
            switch (key) {
                case "w":
                case "up":
                    moverHacia(Direccion.NORTE);
                    break;
                case "a":
                case "left":
                    moverHacia(Direccion.OESTE);
                    break;
                case "s":
                case "down":
                    moverHacia(Direccion.SUR);
                    break;
                case "d":
                case "right":
                    moverHacia(Direccion.ESTE);
                    break;
            }
        }

    }

    public boolean estaEnElBorde() {
        return isAtEdge();
    }

    public boolean hayVacioHacia(Direccion direccion) {
        int width = getWorld().getWidth() - 1;
        int height = getWorld().getHeight() - 1;
        int x = getX();
        int y = getY(); 

        switch (direccion) {
            case NORTE:
                return y == 0;
            case SUR:
                return y == height;
            case ESTE:
                return x == width;
            case OESTE:
                return x == 0;
        }
        return false;
    }

    @Override
    public int obtenerDaño() {
        return 35;
    }

    @Override
    int obtenerConsumoPorMovimiento() {
        return 7;
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
        Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
        if (!(actor instanceof Dañable)) {
            return;
        }
        Dañable objetivo = (Dañable) actor;
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
