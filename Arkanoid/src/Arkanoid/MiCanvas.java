package Arkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.List;


public class MiCanvas  extends Canvas{
	private List<Actor> personajesPantalla;
	private BufferStrategy strategy = null;
	
	
	public MiCanvas() {
		super();
	}

	public MiCanvas(List<Actor> personajesPantalla) {
		super();
		this.personajesPantalla = personajesPantalla;
	}

	public List<Actor> getPersonajesPantalla() {
		return personajesPantalla;
	}

	public void setPersonajesPantalla(List<Actor> personajesPantalla) {
		this.personajesPantalla = personajesPantalla;
	}

	@Override
	public String toString() {
		return "Canvas [personajesPantalla=" + personajesPantalla + "]";
	}
	
	
	public void paint() {
		//se crea el doble buffer por primera vez
		if (this.strategy == null) {
			this.createBufferStrategy(2);
			
		
			//se inicializa el atributo estrategia con unos de los buffers
			strategy = getBufferStrategy();
		
			//resuelve problema de sincronizacion en linux
			Toolkit.getDefaultToolkit().sync();	
		}
		//se consigue objeto grafico del buffer de strategy para poder pintar en el
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		
		//sirve para "limpiar" el buffer de todos los actores
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Actor a : this.personajesPantalla) {
			a.paint(g);
		}
		
		if(Arkanoid.getInstance().laPelotaEStaQuieta()) {
			g.setColor(Color.WHITE);

			g.drawString ("Pulsa Espacio para comenzar juego", 300, 380);
		}

		//se muestra el buffer
		strategy.show();
	}
	
	
	
	
}

