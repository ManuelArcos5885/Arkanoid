package Arkanoid;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class Arkanoid {
	private static Arkanoid instance = null;
	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> listActores = null;
	private MiCanvas canvas = null;
	private Jugador jugador = null;
	private Pelota pelota =null;
	

	public static Arkanoid getInstance(){
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	/**
	 * 
	 * 
	 * 
	 */
	public Arkanoid(){
		listActores = creaListaActores();
		
		
		canvas = new MiCanvas(listActores);
		
		ventana = new JFrame("Arkanoid");
		ventana.setBounds(0, 0, 800, 600);
		
		ventana.getContentPane().setLayout(new BorderLayout());
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		ventana.setIgnoreRepaint(true);
		ventana.setVisible(true);
		
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				apagar();
			}
		});
		
		//establece posicion del raton
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				jugador.asegurarJugadorAlCanvas(e.getX(), e.getY());
			}
		});
		
		
		// Desvío los eventos de teclado hasta el jugador
				canvas.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						super.keyPressed(e);
						jugador.keyPressed(e);
					}

					@Override
					public void keyReleased(KeyEvent e) {
						super.keyReleased(e);
						jugador.keyReleased(e);
					}
				});
	
	
			
	}
	/**
	 * 
	 * 
	 * @return
	 */
		
	
		public MiCanvas getCanvas() {
			return canvas;
		}
	
	/**
	 * 
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		
		Arkanoid.getInstance().juego();
		
		
		
	}
	/**
	 * 
	 * 
	 * @param canvas
	 * @param listActores
	 */
	
	public void apagar() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param canvas
	 * @param listActores
	 */
	public void juego() {
		int millisPorCadaFrame = (1000/FPS);
		do {
			System.out.println(Arkanoid.getInstance().getCanvas().getWidth());
			System.out.println(Arkanoid.getInstance().getCanvas().getHeight());
			long millisAntesDeProcesarEscena = new Date().getTime();
			
			
			canvas.repaint();
			
		
			for (Actor a : listActores) {
				a.actua();
				
			}
			
			comprobarColisionPelota();
			
			
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
	/***
	 * 
	 * 
	 * 
	 */
	
	public void comprobarColisionPelota() {
		for (int i = 0; i < listActores.size(); i++) {
			if (listActores.get(0).getX() >= listActores.get(i).getX() && 
					listActores.get(0).getX() <= listActores.get(i).getAncho() &&
					listActores.get(0).getY() >= listActores.get(i).getX() && 
					listActores.get(0).getX() <= listActores.get(i).getAlto()) {
				pelota.setVelocidadX(pelota.getVelocidadX() * -1);
				pelota.setVelocidadY(pelota.getVelocidadY() * -1);
			}
		}
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	
	public List<Actor> creaListaActores(){
		List<Actor> listActores = new ArrayList<Actor>();
		jugador = new Jugador(100,30,400,500);
		pelota = new Pelota();
		listActores.add(pelota);
		int x = 30;
		int y = 200;
		int contadorFila = 1;
		for (int i = 1; i <= 72; i++) {
			listActores.add(new Ladrillo(60,30,x,y,colorLadrillo(contadorFila)));
			
			x += 64;
			if(i % 12 == 0) {
				x = 30;
				y -= 32;
				contadorFila +=1; 
				
			}
		}
		
		listActores.add(jugador);
		
		return listActores;
	}
	
	/**
	 * 
	 * 
	 * @param contadorColor
	 * @return
	 */
	
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
