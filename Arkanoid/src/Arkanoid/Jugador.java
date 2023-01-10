package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Jugador extends Actor {
	
	
	
	public Jugador() {
			
	}
	

	public Jugador(int i, int j, int k, int l) {
		super(i,j,k,l);
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(this.x, this.y, this.ancho, this.alto);
		g.setColor(Color.MAGENTA);
		
	}
	
	public void actua() {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public String toString() {
		return "Jugador [getAncho()=" + getAncho() + ", getAlto()=" + getAlto() + ", getX()="
				+ getX() + ", getY()=" + getY();
	}

}
