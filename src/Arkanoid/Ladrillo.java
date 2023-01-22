package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;




public class Ladrillo extends Actor {
	private String color;
	
	
	public Ladrillo() {
		super();
		
	}
	
	
	public Ladrillo(int x, int y, String string) {
		super(x,y,eleccionColor(string));
		
		this.color=string;
		
	}



	public static BufferedImage eleccionColor(String color) {
		
		switch (color) {
		case "naranja":
			
			return cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLONARANJA);
		case "rojo":
			
			return cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOROJO);
		case "azul":
					
			return cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOAZUL);
		case "celeste":
			
			return cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOCELESTE);
		case "amarillo":
			
			return cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOAMARILLO);
		case "morado":
			
			return cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOMORADO);

		default:
			break;
		}
		
		return null;
		
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
