package Arkanoid;



import java.awt.BorderLayout;
import java.awt.Rectangle;
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
	private List<Actor> listActores = new ArrayList<Actor>();
	private MiCanvas canvas = null;
	private Jugador jugador = null;
	private Pelota pelota =null;
	private List<Actor> listaActoresAñadir = new ArrayList<Actor>();
	private List<Actor> listaActoresEliminar = new ArrayList<Actor>();
	private int ladrillosDestruidos = 1;

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
				jugador.mover(e.getX());
			}
		});
		
		
		// Desvío los eventos de teclado hasta el jugador
				canvas.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						super.keyPressed(e);
						jugador.keyPressed(e);
						pelota.keyPressed(e);
					}

					@Override
					public void keyReleased(KeyEvent e) {
						super.keyReleased(e);
						jugador.keyReleased(e);
						pelota.keyReleased(e);
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
	
	public boolean laPelotaEStaQuieta() {
		if (pelota.getVelocidadX() == 0) {
			return true;

		}
		return false;
	
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	public void juego() {
		int millisPorCadaFrame = (1000/FPS);
		
		do {
			//establece el canvas como foco si este es distinto de canvas o es nulo
			
			if (ventana.getFocusOwner() != null && !ventana.getFocusOwner().equals(canvas)) {
				canvas.requestFocus();
			}
			
			
			
			
			long millisAntesDeProcesarEscena = new Date().getTime();
			
			
			canvas.paint();
			
		
			for (Actor a : listActores) {
				a.actua();
				
			}
			
			comprobarColisionPelota();
			
			actualizaActores();
			
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			
			
			//para ir a 60fps
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
		
		//crear "hitboxis" del tamaño de los actores
		Rectangle rect1 = new Rectangle(pelota.getX(), pelota.getY(), pelota.getAncho(), pelota.getAlto());
		
		for (Actor actor2 : this.listActores) {
			// Evito comparar un actor consigo mismo, ya que eso siempre provocaría una colisión y no tiene sentido
			if (!pelota.equals(actor2)) {
				// Formo el rectángulo del actor 2
				Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getAncho(), actor2.getAlto());
				// Si los dos rectángulos tienen alguna intersección, notifico una colisión en los dos actores
				if (rect1.intersects(rect2)) {
					pelota.colisionaCon(actor2); // El actor 1 colisiona con el actor 2
					actor2.colisionaCon(pelota); // El actor 2 colisiona con el actor 1
				}
			}
		}
		reiniciarPartida();
		
			
	}
	/**
	 * 
	 * 
	 */
	public void reiniciarPartida() {
		if(pelota.getY() >= canvas.getHeight() - pelota.getAlto()) {
			Arkanoid.getInstance().eliminarActor(pelota);	
			String [] opciones ={"Aceptar","Salir"};
			int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea empezar una nueva parrtida?","GAME OVER",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
			if (eleccion == JOptionPane.NO_OPTION) {
				System.exit(0);;
			}
			else {
				
				listActores.clear();
				listActores = creaListaActores();
				canvas.setPersonajesPantalla(listActores);
			}
			
			
		}
	}

	
	/**
	 * 
	 * 
	 */
	public void actualizaActores() {
		
		for (Actor actorAñadir : this.listaActoresAñadir) {
			this.listActores.add(actorAñadir);
		}
		listaActoresAñadir.clear();
		
		
		for (Actor actorEliminar : this.listaActoresEliminar) {
			this.listActores.remove(actorEliminar);
			ladrillosDestruidos += 1;
		}
		listaActoresEliminar.clear();
		
		if (ladrillosDestruidos % 15 == 0) {
			aumentaVelocidadPelota();
		}
		
	}
	/**
	 * 
	 * 
	 */
	public void eliminarActor(Actor actorParaEliminar) {
		//para evitar problemas de intentar imprimir un actor ya eliminado
		listaActoresEliminar.add(actorParaEliminar);
	}
	
	/**
	 * 
	 * 
	 */
	public void añadirActor(Actor actorAñadir) {
		//para evitar problemas de intentar imprimir un actor ya eliminado
		listaActoresAñadir.add(actorAñadir);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public void aumentaVelocidadPelota(){
		if (pelota.getVelocidadX() > 0) {
			pelota.setVelocidadX(pelota.getVelocidadX() + 1);
		}
		else {
			pelota.setVelocidadX(pelota.getVelocidadX() - 1);
		}
		if (pelota.getVelocidadY() > 0) {
			pelota.setVelocidadY(pelota.getVelocidadY() + 1);
		}
		else {
			pelota.setVelocidadY(pelota.getVelocidadY() - 1);
		}
		ladrillosDestruidos = 1;

		
	}
	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	
	public List<Actor> creaListaActores(){
		List<Actor> listActores = new ArrayList<Actor>();
		jugador = new Jugador();
		pelota = new Pelota();
		listActores.add(pelota);
		int x = 30;
		int y = 200;
		int contadorFila = 1;
		for (int i = 1; i <= 66; i++) {
			listActores.add(new Ladrillo(x,y,colorLadrillo(contadorFila)));
			
			x += 66;
			if(i % 11 == 0) {
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
