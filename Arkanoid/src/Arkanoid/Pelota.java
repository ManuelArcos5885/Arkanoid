package Arkanoid;


import java.awt.Graphics;
import java.awt.event.KeyEvent;

import org.rmrsoft.spaceInvaders.ImagesCache;


public class Pelota extends Actor {
	private int velocidadX = 0;
	private int velocidadY = 0;
	
	
	public Pelota() {
		super(20,20,400,300,cacheImagenes.getInstance().imprimirImagen(cacheImagenes.IMAGEN_PELOTA));	
	}
	

	

	public Pelota(int velocidadX, int velocidadY) {
		super();
		this.velocidadX = velocidadX;
		this.velocidadY = velocidadY;
	}
	
	
	



	public int getVelocidadX() {
		return velocidadX;
	}




	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}




	public int getVelocidadY() {
		return velocidadY;
	}




	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}




	
	
	
	@Override
	public String toString() {
		return "Pelota [velocidadX=" + velocidadX + ", velocidadY=" + velocidadY + "]";
	}

	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}


	public void actua(){
		this.x += this.velocidadX;
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
			this.velocidadX = -this.velocidadX;
		}
		
		this.y += this.velocidadY;
		if (this.y < 0 || (this.y + this.alto) > Arkanoid.getInstance().getCanvas().getHeight()) {
			this.velocidadY = -this.velocidadY;
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public void colisionaCon(Actor a) {
		this.velocidadY = -this.velocidadY;
		if (UtilsArray.obtenerNumeroAzar(0, 100) > 50) {
			this.velocidadX = -this.velocidadX;
		}
		else {
			this.velocidadX = this.velocidadX;
		}
	}
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			setVelocidadX(5);
			setVelocidadY(5);
		
	
		}
	}
	
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			setVelocidadX(5);
			setVelocidadY(5);
		}
	}
	
	

}
