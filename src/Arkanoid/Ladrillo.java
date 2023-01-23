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
		super(x,y);
		eleccionColor(string);
		
		this.color=string;
		
	}



	public BufferedImage eleccionColor(String color) {
		
		switch (color) {
		case "naranja":
			setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLONARANJA));
			break;
		case "rojo":
			
			setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOROJO));
			break;
		case "azul":
					
			setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOAZUL));
			break;
		case "celeste":
			
			setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOCELESTE));
			break;
		case "amarillo":
			
			setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOAMARILLO));
			break;
		case "morado":
			
			setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_LADRILLOMORADO));
			break;
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
		Arkanoid.getInstance().añadirActor(new Explosion(a.getX(),a.getY()));
		Arkanoid.getInstance().eliminarActor(this);
		
		
	}
	
	

}
