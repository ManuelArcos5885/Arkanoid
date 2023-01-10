package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {
	private int velocidadX = 1;
	private int velocidadY = 1;
	
	
	public Pelota() {
			
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
		g.setColor(Color.WHITE);
		g.fillOval(this.x,this.y,this.ancho,this.alto);
		
	}


	public void actua(){
		this.x = this.x + this.velocidadX;
		
		if (this.x >= 800 || this.x <= 0 ) {
			this.velocidadX = -this.velocidadX;
		}
		
		this.y = this.y + this.velocidadY;
		
		if (this.y >= 600 || this.x <= 0 ) {
			this.velocidadY = -this.velocidadY;
		}
	}
	
	

}
