public enum Direccion {   
    NORTE(270, 0, -1),SUR(90, 0, 1),ESTE(0, 1, 0),OESTE(180, -1, 0);

    int rotacion, dx, dy;
    
    Direccion(int rotacion, int dx, int dy) {
        this.rotacion = rotacion;
        this.dx = dx;
        this.dy = dy;
    }
}
