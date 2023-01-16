package Arkanoid;

import java.awt.Color;
import java.awt.Graphics;



public class Ladrillo extends Actor {
	private String color;
	
	
	
	
	
	public Ladrillo(int i, int j, int x, int y, String string) {
		super(i,j,x,y);
		this.color=string;
		
	}





	public Ladrillo(String color) {
		super();
		this.color = color;
	}

	

	

	public String getColor() {
		return color;
	}





	public void setColor(String color) {
		this.color = color;
	}





	public void paint(Graphics g) {
		
		
		switch (this.color) {
		case "rojo":
			g.setColor(Color.RED);
			break;
		case "amarillo":
			g.setColor(Color.YELLOW);
			break;
		case "azul":
			g.setColor(Color.BLUE);
			break;
		case "verde":
			g.setColor(Color.GREEN);
			break;
		case "rosa":
			g.setColor(Color.PINK);
			break;
		case "naranja":
			g.setColor(Color.ORANGE);
			break;
		
		default:
			break;
		}
		g.fillRect(this.x, this.y, this.ancho, this.alto);
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
