package Actividades;

public class Main {
	 public static void main(String[] args) {
	        int[] datos = {2, 3, 2, 5, 3, 2, 4, 3, 3};

	        int moda = Moda3.moda3(datos, 0, datos.length - 1);

	        System.out.println("Moda: " + moda);
	    }
	}
