package Arkanoid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;






public abstract class Actor {
	protected int ancho = 60;
	protected int alto = 30;
	protected int x;
	protected int y;
	
	
	protected List<BufferedImage> spritesAnimacion;
	
	protected BufferedImage spriteActual;
	protected int velocidadCambioSprite;
	
	protected int cantidadFramesOcurridos = 0;
	
	
	
	
	
	
	public Actor() {
		super();
	}


	


	public Actor(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	/**
	 * 
	 * 
	 * 
	 * @param a
	 */
	
	public void setSpriteActual(BufferedImage spriteActual) {
		this.spriteActual = spriteActual;
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
	}

	public void colisionaCon(Actor a) {
	}


	public void paint(Graphics g) {
		g.drawImage(this.spriteActual, this.x, this.y, null);
	}
	
	public void actua() {
		if(spritesAnimacion != null && spritesAnimacion.size() > 0) {
			cantidadFramesOcurridos++;
			if(cantidadFramesOcurridos % velocidadCambioSprite == 0) {
				int indiceSpriteActual = spritesAnimacion.indexOf(spriteActual);
				int indiceSpriteSiguiente = (indiceSpriteActual + 1) % spritesAnimacion.size();
				spriteActual = spritesAnimacion.get(indiceSpriteSiguiente);
			}
		}
	}





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
	
	/**
	 * 
	 * 
	 */
	
	public void setSpritesDeAnimacion(List<BufferedImage> listaAnimacion) {
		this.spritesAnimacion = listaAnimacion;
	}
	
	
	public List<BufferedImage> getSpritesDeAnimacion() {
		return spritesAnimacion;
		
	}
	
	
	
	
}
