package Arkanoid.imagenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;






public abstract class Actor {
	protected int ancho = 60;
	protected int alto = 30;
	protected int x;
	protected int y;
	protected BufferedImage img;
	
	
	
	
	public Actor() {
		super();
	}


	


	public Actor(int x, int y,BufferedImage img) {
		this.x = x;
		this.y = y;
		this.setImg(img);
	}


	public void colisionaCon(Actor a) {
	}


	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}
	
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



	

	public BufferedImage getImg() {
		return img;
	}





	public void setImg(BufferedImage img) {
		this.img = img;
		this.ancho = this.img.getWidth();
		this.alto = this.img.getHeight();
		
	}





	@Override
	public String toString() {
		
		return "Actor [ancho=" + ancho + ", alto=" + alto + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
