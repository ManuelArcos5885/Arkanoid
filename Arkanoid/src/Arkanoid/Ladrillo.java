package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;




public class Ladrillo extends Actor {
	private String color;
	
	
	
	
	
	public Ladrillo(int x, int y, String string) {
		super(x,y,cacheImagenes.getInstance().imprimirImagen(cacheImagenes.IMAGEN_LADRILLO));
		
		this.color=string;
		
	}





	public Ladrillo() {
		super();
		
	}

	

	

	public String getColor() {
		return color;
	}





	public void setColor(String color) {
		this.color = color;
	}





	
	
	public void actua(){
	}





	@Override
	public String toString() {
		return "Ladrillo [color=" + color + ", getAncho()=" + getAncho() + ", getAlto()=" + getAlto() + ", getX()="
				+ getX() + ", getY()=" + getY() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public void colisionaCon(Actor a) {
		Arkanoid.getInstance().eliminarActor(this);
		
	}
	
	

}
