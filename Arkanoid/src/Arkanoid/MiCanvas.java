package Arkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;


public class MiCanvas  extends Canvas{
	private List<Actor> personajesPantalla;

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
	
	
	@Override
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		
		for (Actor a : this.personajesPantalla) {
			a.paint(g);
		}
	}
	
	
	
	
}

