package Arkanoid;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Explosion extends Actor{

	
	public Explosion(int x, int y) {
		this.x = x;
		this.y = y;
		
		List<BufferedImage> spritesExplosion = new ArrayList<BufferedImage>();
		
		spritesExplosion.add(cacheImagenes.getInstance().getImagen("sprite-explosion1.png"));
		spritesExplosion.add(cacheImagenes.getInstance().getImagen("sprite-explosion2.png"));
		spritesExplosion.add(cacheImagenes.getInstance().getImagen("sprite-explosion3-real.png"));
		spritesExplosion.add(cacheImagenes.getInstance().getImagen("sprite-explosion4.png"));
		spritesExplosion.add(cacheImagenes.getInstance().getImagen("sprite-explosion5.png"));
		this.setSpritesDeAnimacion(spritesExplosion);
		
		this.spriteActual = this.getSpritesDeAnimacion().get(0);
		
		this.velocidadCambioSprite = 5;
	}
	
	public void actua() {
		super.actua();
		if(spriteActual == spritesAnimacion.get(spritesAnimacion.size()-1)) {
			Arkanoid.getInstance().eliminarActor(this);
		}
	}
	

}
