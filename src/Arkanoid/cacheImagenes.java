package Arkanoid;


import java.awt.image.BufferedImage;
import java.net.URL;

import java.util.HashMap;

import javax.imageio.ImageIO;


public class cacheImagenes {
	public static String IMAGEN_PELOTA = "pelota_Arkanoid.png";
	public static String IMAGEN_LADRILLOAMARILLO = "ladrillo_amarillo.png";
	public static String IMAGEN_LADRILLONARANJA = "ladrillo_naranja.png";
	public static String IMAGEN_LADRILLOAZUL = "ladrillo_azul.png";
	public static String IMAGEN_LADRILLOCELESTE = "ladrillo_celeste.png";
	public static String IMAGEN_LADRILLOROJO = "ladrillo_rojo.png";
	public static String IMAGEN_LADRILLOMORADO = "ladrillo_morado.png";
	public static String IMAGEN_JUGADOR = "IMAGEN_JUGADOR.png";
	
	public static String IMAGEN_3VIDAS = "3vidas.png";
	public static String IMAGEN_2VIDAS = "2vidas.png";
	public static String IMAGEN_1VIDAS = "1vida.png";
	public static String IMAGEN_0VIDAS = "0vidas.png";
	
	public  static String IMAGEN_METRALLETA = "metralleta.png";
	public  static String IMAGEN_DISPARO = "disparo.png";	
	
	private static cacheImagenes instance = null;
	//almacen de imagenes
	private HashMap<String, Object> sprites = new HashMap<String, Object>();
	
	
	public static cacheImagenes getInstance() {
		if(instance == null) {
			instance = new cacheImagenes();
		}
		return instance;
	}
	
	
	
	
	
	private BufferedImage introducirImagenesEnHashMap(String nombreImagen) {
		URL url = null;
		//adjuntamos la direccion de la imagen a su url
		
		try {
			url = getClass().getResource(nombreImagen);
			return ImageIO.read(url);
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	
	public BufferedImage getImagen(String nombreImagen) {
		BufferedImage imagen = (BufferedImage) sprites.get(nombreImagen);
		if (imagen == null) {

			imagen = introducirImagenesEnHashMap("imagenes/" + nombreImagen);

			sprites.put(nombreImagen,imagen);
		}
		
		return imagen;
	}
	
	
	

}
