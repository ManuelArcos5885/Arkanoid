package Arkanoid;


import java.awt.Graphics;
import java.awt.event.KeyEvent;





public class Pelota extends Actor {
	private int velocidadX = 0;
	private int velocidadY = 0;
	
	
	public Pelota() {
		
	}
	

	

	public Pelota(int velocidadX, int velocidadY) {
		super(400,300);
		setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_PELOTA));
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
		
		if (a instanceof Ladrillo || a instanceof Jugador) {
			this.velocidadY = -this.velocidadY;
			if (UtilsArray.obtenerNumeroAzar(0, 100) > 50) {
				this.velocidadX = -this.velocidadX;
			}
			else {
				this.velocidadX = this.velocidadX;
			}
		}
	}

	
	public void keyReleased (KeyEvent e) {
		if(velocidadX == 0 && velocidadY == 0) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				setVelocidadX(5);
				setVelocidadY(5);
			}
		}
	}




	public void keyPressed(KeyEvent e) {
		if(velocidadX == 0 && velocidadY == 0) {
			switch (e.getKeyCode()) {
			
				case KeyEvent.VK_SPACE:
					setVelocidadX(5);
					setVelocidadY(5);
			}
			
		
			}
		
	}
	
	

}
