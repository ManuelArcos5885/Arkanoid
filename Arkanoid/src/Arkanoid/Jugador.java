package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;



public class Jugador extends Actor {
	private boolean izquierda = false, derecha = false;
	private int velocidad = 5;
	
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
		
		if (derecha) this.x += velocidad;
		if (izquierda) this.x -= velocidad;
	
		asegurarJugadorAlCanvas(this.x, this.y);	
	}
	
	
	public void asegurarJugadorAlCanvas(int x, int y) {
		this.x = x;
		this.y = y;
		
		MiCanvas canvas = Arkanoid.getInstance().getCanvas(); 
		

		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}

		if (this.x < 0) {
			this.x = 0;
		}

		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}

		if (this.y < 0) {
			this.y = 0;
		}
	}
	
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = true; break;
		case KeyEvent.VK_RIGHT:
			derecha = true; break;
	
		}
	}
	
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = false; break;
		case KeyEvent.VK_RIGHT:
			derecha = false; break;
		}
	}
	
	@Override
	public String toString() {
		return "Jugador [getAncho()=" + getAncho() + ", getAlto()=" + getAlto() + ", getX()="
				+ getX() + ", getY()=" + getY();
	}

}
