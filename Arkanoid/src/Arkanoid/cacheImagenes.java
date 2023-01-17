package Arkanoid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.HashMap;

import javax.imageio.ImageIO;


public class cacheImagenes {
	private String ubicacionCarpetaImagenes = "./Arkanoid/src/Arkanoid/Imagenes/";
	private String ubicacionImagenes = "Imagenes/";
	private static cacheImagenes instance = null;
	//almacen de imagenes
	private HashMap<String, Object> hmRecursos = new HashMap<String, Object>();
	
	
	public static cacheImagenes getInstance() {
		if(instance == null) {
			instance = new cacheImagenes();
		}
		return instance;
	}
	
	
	public void cargarImagenesEnMemoria() {
		File carpeta = new File(ubicacionCarpetaImagenes);
		
		for(File fichero : carpeta.listFiles()) {
			if (fichero.isFile()) {
				introducirImagenesEnHashMap(fichero.getName());
			}
		}
	
	}
	
	
	public void introducirImagenesEnHashMap(String nombreImagen) {
		java.net.URL url = null;
		//adjuntamos la direccion de la imagen a su url
		url = getClass().getResource(ubicacionImagenes + nombreImagen);
		try {
			if (nombreImagen.endsWith(".wav") || nombreImagen.endsWith(".mp3")) {
				this.hmRecursos.put(nombreImagen, Applet.newAudioClip(url));
			} 
			else { // Si no es un sonido entiendo que se trata de una imagen
				this.hmRecursos.put(nombreImagen, ImageIO.read(url));
			}
		
		}
		catch (Exception ex) {
			System.out.println("No se pudo cargar el recurso " + nombreImagen);
			ex.printStackTrace();
		}
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	
	public BufferedImage imprimirImagen(String nombreImagen) {
		return (BufferedImage) hmRecursos.get(nombreImagen);
	}
	
	
	public void playSonido(String nombreArchivo) {
		((AudioClip)hmRecursos.get(nombreArchivo)).play();
	}

}
