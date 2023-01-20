package Arkanoid;


import java.awt.image.BufferedImage;
import java.net.URL;

import java.util.HashMap;

import javax.imageio.ImageIO;


public class cacheImagenes {
	public static String IMAGEN_PELOTA = "pelota_Arkanoid.gif";
	public static String IMAGEN_LADRILLO = "ladrillo.gif";
	public static String IMAGEN_JUGADOR = "IMAGEN_JUGDOR.gif";
	
	private static cacheImagenes instance = null;
	//almacen de imagenes
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	
	
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
	
	public BufferedImage imprimirImagen(String nombreImagen) {
		BufferedImage imagen = sprites.get(nombreImagen);
		if (imagen == null) {

			imagen = introducirImagenesEnHashMap("imagenes/" + nombreImagen);

			sprites.put(nombreImagen,imagen);
		}
		
		return imagen;
	}
	
	
	

}
