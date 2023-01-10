package Arkanoid;

import java.awt.Graphics;





public abstract class Actor {
	protected int ancho = 60;
	protected int alto = 30;
	protected int x = UtilsArray.obtenerNumeroAzar(0, 200);
	protected int y = UtilsArray.obtenerNumeroAzar(0, 200);
	
	
	
	
	
	public Actor() {
		super();
	}


	


	public Actor(int ancho, int alto, int x, int y) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.x = x;
		this.y = y;
	}


	


	public abstract void paint(Graphics g);
	
	public abstract void actua();





	public int getAncho() {
		return ancho;
	}





	public void setAncho(int ancho) {
		this.ancho = ancho;
	}





	public int getAlto() {
		return alto;
	}





	public void setAlto(int alto) {
		this.alto = alto;
	}





	public int getX() {
		return x;
	}





	public void setX(int x) {
		this.x = x;
	}





	public int getY() {
		return y;
	}





	public void setY(int y) {
		this.y = y;
	}





	@Override
	public String toString() {
		
		return "Actor [ancho=" + ancho + ", alto=" + alto + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
