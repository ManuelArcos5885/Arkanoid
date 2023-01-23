package Arkanoid;

import java.awt.image.BufferedImage;

public class Vidas extends Actor{
	private int cantidadVidas=3;
	
	
	
	
	public Vidas() {
		super();
	}




	public Vidas(int cantidadVidas) {
		super(630,500);
		setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_3VIDAS));
		this.cantidadVidas = cantidadVidas;
	}
	/**
	 * @return 
	 * 
	 * 
	 * 
	 */
	public boolean sigueLaPartida(Vidas contVidas) {
		switch (contVidas.getCantidadVidas()) {
		case 3:
			contVidas.setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_3VIDAS));
			return true;
		case 2:
			contVidas.setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_2VIDAS));
			return true;
		case 1:
			contVidas.setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_1VIDAS));
			return true;
		case 0:
			contVidas.setSpriteActual(cacheImagenes.getInstance().getImagen(cacheImagenes.IMAGEN_0VIDAS));
			return true;

		default:
			break;
		}
		
		return false;
		
	}


	@Override
	public String toString() {
		return "contadorVidas [cantidadVidas=" + cantidadVidas + "]";
	}




	public int getCantidadVidas() {
		return cantidadVidas;
	}




	public void setCantidadVidas(int cantidadVidas) {
		this.cantidadVidas = cantidadVidas;
	}




	public void actua() {
		
		
	}
	
}
