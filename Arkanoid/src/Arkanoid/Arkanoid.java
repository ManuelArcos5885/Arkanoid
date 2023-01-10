package Arkanoid;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;




public class Arkanoid {
	private static int FPS = 60;
	
	public static void main(String[] args) {
		List<Actor> listActores = creaListaActores();
		
		MiCanvas canvas = new MiCanvas(listActores);
		
		JFrame ventana = new JFrame("Arkanoid");
		ventana.setBounds(0, 0, 800, 600);
		
		ventana.getContentPane().setLayout(new BorderLayout());
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		ventana.setIgnoreRepaint(true);
		ventana.setVisible(true);
		int millisPorCadaFrame = (1000/FPS);
		do {
			
			long millisAntesDeProcesarEscena = new Date().getTime();
			
			
			canvas.repaint();
			
		
			for (Actor a : listActores) {
				a.actua();
			}
			
			
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
		
	}
	
	
	
	
	public static List<Actor> creaListaActores(){
		List<Actor> listActores = new ArrayList<>();
		Jugador jugador = new Jugador(100,30,400,500);
		Pelota pelota = new Pelota();
		
		int x = 30;
		int y = 200;
		int contadorFila = 1;
		for (int i = 0; i < 72; i++) {
			listActores.add(new Ladrillo(60,30,x,y,colorLadrillo(contadorFila)));
			
			x +=62;
			if (x== 774) {
				x = 30;
				y -= 32;
				contadorFila +=1;
			}
		}
		
		listActores.add(jugador);
		listActores.add(pelota);
		return listActores;
	}
	
	public static String colorLadrillo(int contadorColor) {
		switch (contadorColor) {
		case 1:
			
			return "naranja";
		case 2:
			
			return "verde";
		case 3:
			
			return "azul";
		case 4:
			
			return "rosa";
		case 5:
			
			return "amarillo";
		case 6:
			
			return "rojo";

		default:
			break;
		}
		
		return null;
		
	}
	
	
	
	
}
