import greenfoot.*;

/**
 * Representa los colores para el EscenarioPintor
 */
public enum Tinta {
	NEGRO(new Color(0, 0, 0, 80)),
	LILA(new Color(190, 173, 250, 150));

	Color color;

	Tinta(Color color) {
		this.color = color;
	}
}
