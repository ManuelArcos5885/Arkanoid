package Arkanoid;

import java.io.File;

public class cacheImagenes {
	
	private static cacheImagenes instance = null;
	
	
	
	
	public static cacheImagenes getInstance() {
		if(instance == null) {
			instance = new cacheImagenes();
		}
		return instance;
	}
	
	
	public void cargarImagenesEnMemoria() {
		File carpeta = new File();
	}
}
