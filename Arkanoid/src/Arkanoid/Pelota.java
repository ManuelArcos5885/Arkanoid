package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;


public class Pelota extends Actor {
	private int velocidadX = 5;
	private int velocidadY = 5;
	
	
	public Pelota() {
		super(30,30,400,400);	
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
		this.x += this.velocidadX;
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
			this.velocidadX = -this.velocidadX;
		}
		
		this.y += this.velocidadY;
		if (this.y < 0 || (this.y + this.alto) > Arkanoid.getInstance().getCanvas().getHeight()) {
			this.velocidadY = -this.velocidadY;
		}
	}
	
	

}
