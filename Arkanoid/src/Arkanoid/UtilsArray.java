package Arkanoid;



public class UtilsArray {
	
	public static void mostrarArray (int[] array) {
	System.out.println("Contenido del array");
	for (int i = 0; i < array.length; i++) {
	System.out.print(array[i] + " ");
	}
	System.out.println("\n");
	}

	public static int obtenerNumeroAzar (int min, int max) {
		return (int) Math.round(Math.random() * (max - min)) + min;
/*
 *
 *
 */
	}

	public static int[] creaArrayNumerosAzar (int longitud, int limInf, int limSup) {
		int array[] = new int[longitud];
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAzar(limInf, limSup);
			}
			return array;
	}
	/*
	 *
	 *
	 */

	public static float[] creaArrayNumerosAzarDecimales (int longitud, int limInf, int limSup) {
		float array[] = new float[longitud];
		float decimal;
		int cont= 0;
		for (int i = 0; i < array.length; i++) {
			;
			decimal = (float) Math.random();
			
			if (decimal <= 0.49) 
				cont += 1;
			
			array[i] = obtenerNumeroAzar(limInf, limSup) + decimal;
		}
			System.out.println("Hay "+ cont + " decimales comprendidos entre 0 y 0.49 ");
			return array;
	}
	
	/*
	*
	*
	*/
	public static void mostrarArrayDecimales (float[] array) {
		System.out.println("Contenido del array");
		for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		}
	/*
	*
	*
	*/

	public static int[][] creaInicializaMatriz(int filas,int colums,int valorInicial){
		int m[][] = new int[filas][colums];
	
		for (int i = 0; i < m.length;i++) {
			for(int j = 0; j < m[i].length;j++) {
				m[i][j] = 0;
			}
		}
				return m;
	}

	/**
	*
	*
	*/
	public static void mostrarMatriz(int m[][]){
		for (int i = 0; i < m.length;i++) {
			System.out.println();
			for(int j = 0; j < m[i].length;j++) {
				System.out.print(m[i][j] + " ");
			}
		}
	}

	/**
	 * @return 
	*
	*
	*/
	public static boolean verificarGanador(int m[][], int n){
		

		if (m[0][0]== n && m[0][1] == n && m[0][2] == n) {
			return true;
		}
		if (m[1][0]== n && m[1][1] == n && m[1][2] == n) {
			return true;
		}
		if (m[2][0]== n && m[2][1] == n && m[2][2] == n) {
			return true;
		}
		if (m[0][0]== n && m[1][1] == n && m[2][2] == n) {
			return true;
		}
		if (m[0][2]== n && m[1][1] == n && m[2][0] == n) {
			return true;
		}
		if (m[0][0]== n && m[1][0] == n && m[2][0] == n) {
			return true;
		}
		if (m[0][1]== n && m[1][1] == n && m[2][1] == n) {
			return true;
		}
		if (m[0][2]== n && m[1][2] == n && m[2][2] == n) {
			return true;
		}
		
		return false;
		
		
		
		

		
	}
	/*
	 *
	 *
	 */
	
	public static int[][] creaMatrizNumerosAzarSinRepetidos (int m[][]) {
		int valor = 0;
		for (int i = 0; i < m.length; i++) {
			for(int j = 0; j<m[i].length;j++) {
				do {
				valor = m[i][j] = obtenerNumeroAzar(0, 1000);
				
				}while(valorEstaMatriz(valor, m) == true);
				m[i][j] = valor;
			}
		}
		return m;
		
			
	}
	
	/*
	 *
	 *
	 */
	
	public static int[][] creaMatrizNumerosAzar (int m[][]) {
		int valor = 0;
		for (int i = 0; i < m.length; i++) {
			for(int j = 0; j<m[i].length;j++) {
				valor = m[i][j] = obtenerNumeroAzar(0, 1000);
				m[i][j] = valor;
			}
		}
		return m;
		
			
	}
	
	
	/*
	 *
	 *
	 */
	
	public static int[][] creaMatrizValoresAzar (int m[][]) {
		int valor = 0;
		for (int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length;j++) {
				valor = m[i][j] = obtenerNumeroAzar(-1000, 1000);	

			}
		}
		return m;
		
			
	}
	
	
	/*
	 *
	 *
	 */
	public static boolean valorEstaMatriz (int valor, int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for(int j = 0; j<m[i].length;j++) {
				if (valor == m[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	/*
	 *
	 *
	 */
	
	public static int getMiddleItem (int m[]) {
		if (m.length % 2 == 0) 
			return -1;
		
		else
			return m[m.length / 2];
	}
	/*
	 *
	 *
	 */
	public static void matrizPositiva (int m[][]) {
		boolean pos = true;
		// Comprueba que todos los elementos sean mayores que cero
		for (int i = 0; i < m.length && pos == true; i++) {
			for(int j = 0; j<m[i].length;j++) {
				if (m[i][j] < 0) {
					// si hay un numero negativo la matriz no es positiva, acaba el bucle
					pos = false;
					break;
				}		
			}
		}	
		// imprime resultado
		if (pos == true)
			System.out.println("La matriz es positiva");
		else
			System.out.println("La matriz es negativa");
		
	}
	/*
	 *
	 *
	 */
	public static void MatrizDiagonal (int m[][]) {
		boolean esdiagonal = true;
		for (int i = 0; i < m.length && esdiagonal == true; i++) {
			for(int j = 0; j<m[i].length;j++) {
				if (i != j && m[i][j] != 0) {
					esdiagonal = false;
					System.out.println("La matriz no es diagonal");
					break;
				}	
			}
		}	
		if (esdiagonal)
			System.out.println("La matriz es diagonal");	
	}
	/*
	 *
	 *
	 */
	public static void MatrizTriangularSuperior (int m[][]) {
		boolean estriangularSuperior = true;
		for (int i = 0; i < m.length && estriangularSuperior == true; i++) {
			for(int j = 0; j <m[i].length;j++) {
				if (i > j && m[i][j] != 0) {
					estriangularSuperior = false;
					System.out.println("La matriz no es triangular superior");
					break;
				}	
			}
		}	
		if (estriangularSuperior == true)
			System.out.println("La matriz es triangular superior");	
	}
	/**
	*
	*
	*/
	public static void matrizOpuesta(int m[][]){
		for (int i = 0; i < m.length;i++) {
			System.out.println();
			for(int j = 0; j < m[i].length;j++) {
				System.out.print(m[i][j] * -1 + " ");
			}
		}
	}
	
	/**
	*
	*
	*/
	public static void comprobarMatrizDispersa(int m[][]){
		boolean esDispersa = true;
		// Compruebo que hay ceros en todas las filas
		for (int i = 0; i < m.length && esDispersa == true;i++) {
			esDispersa = false;
			for(int j = 0; j < m[i].length;j++) {
				// Si no hay ceros el proprama termina porque no es dispersa
				if (m[i][j] == 0) {
					esDispersa = true;
					break;
				}
			}
		}
		// Compruebo que hay ceros en todas las columnas
		for (int j = 0; j < m.length && esDispersa == true;j++) {
			esDispersa = false;
			for(int i = 0; i < m.length;i++) {
				if (m[i][j] == 0) {
					esDispersa = true;
					break;
				}
			}
		}
		
		// Imprime solución en funcion del valor de la booleana "esDispersa"
		if (!esDispersa)
			System.out.println("La matriz no es dispersa");
		else
			System.out.println("La matriz es dispersa");
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public static int[] ConvertirMatrizEnArray(int m[][]) {
		int n[] = UtilsArray.creaArrayNumerosAzar(m.length * 5, 0, 0);
		int cont = 0;
		
		
		for (int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++ ,cont++) {
				n[cont] = m[i][j];
				
			}	
		}
		
		
		
		return(n);
	}
	
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public static Void comprobarSimetriaMatriz (int m[][]) {
		boolean esSimetrica = true;
		for (int i = 0; i < m.length && esSimetrica == true; i++) {
			for(int j = 0; j < m[i].length; j++) {
				if (i > j && m[i][j] > m[j][i]) {
					esSimetrica = false;
					System.out.println("La matriz no es simetrica");
					break;
				}	
			}
		}	
		if (esSimetrica == true)
			System.out.println("La matriz es simetrica");
		return null;	
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public static int[][] matrizTraspuesta (int m[][]) {
		int n[][] = UtilsArray.creaInicializaMatriz(m.length,m.length, 0);
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				n[j][i] = m[i][j];
			}
		}
		
		
		
		return n;
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public static int[][] eliminarLineasArray (int m[][], int num) {
		int n[][] = UtilsArray.creaInicializaMatriz(m.length - num,m.length, 0);
		for (int i = 0; i < n.length ;i++) {
			for(int j = 0; j < m[i].length;j++) {
				n[i][j] = m[i][j];
			
			}
			
		}
		
		
		return n;
		
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public static void porcentajeArrays (int m[]) {
		double contadorAprobados = 0;
		for(int i = 0; i < m.length; i++) {
			if (m[i] > 4) {
				contadorAprobados += 1;
			}
		}
		System.out.println("La media de aprobados es: " + contadorAprobados/20 * 100 + "%");
		System.out.println("La media de suspensos es: " + (100 - contadorAprobados/20 * 100) + "%");
		
		
		
		
		
	}
	/**
	 * 
	 * 
	 * 
	 */
	
	public static int[] generarNumeroComplementario(int tamano) {
		int n[] = UtilsArray.creaArrayNumerosAzar(tamano, 0, 0);
		for(int i = 0; i < n.length; i++) {
				do {
					
				
					if (i == n.length -1) {
						n[i] = UtilsArray.obtenerNumeroAzar(1, 49);
						break;
					}
					n[i] = UtilsArray.obtenerNumeroAzar(1, 49);
				} while (UtilsArray.valorYaexiste(n,i));
			
		}
		
		return n;

	}
	/**
	 * 
	 * 
	 * 
	 */
	
	public static boolean valorYaexiste(int n[], int valor) {
		for(int i = 0; i < n.length; i++) {
			if (n[i] == n[valor] && i != valor) {
				return true;
			}
		}
		
		
		return false;
	
	}
	/**
	 * 
	 * 
	 * 
	 */
	public static void mostrarArrayChar(char asteriscos[][]) {
		for (int i = 0 ; i < asteriscos.length ; i++){
            for (int j = 0 ; j < asteriscos[i].length; j++){
                System.out.print(asteriscos[i][j]);
            }
            System.out.println("");
				
		}
	
	}
	/**
	 * @param numeros 
	 * 
	 * 
	 * 
	 */
	public static int[] integrarEnArrayNumero(int[] numeros, int num, int contador) {
		int numerosNuevos[] = UtilsArray.creaArrayNumerosAzar(contador + 1, 0, 0);
		for(int i = 0; i < numerosNuevos.length-1; i++) {
			numerosNuevos[i] = numeros[i];
		}
		numerosNuevos[numerosNuevos.length -1] = num;
		
		return numerosNuevos;
		
	}
	/**
	 * @param numeros 
	 * 
	 * 
	 * 
	 */
	public static boolean calcularMedia (int[] numeros, double contador) {
		boolean mediaCorrecta = false;
		int media = 0;
		for(int i = 0; i < numeros.length; i++) {
			media += numeros[i];
		}
		if(media / (contador + 1) >= 495 && media / (contador + 1) <= 505) {
			mediaCorrecta = true;
		}
		
		
		return mediaCorrecta;
	
	}
}