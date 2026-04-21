package act1;

public class Hanoi {
    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        h.torresHanoi(3, 1, 2,0);
    }

    public void torresHanoi(int discos, int torre1, int torre2, int torre3) {
        if (discos == 1) { // Caso base
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {
            // Mover n-1 discos 
            torresHanoi(discos - 1, torre1, torre3, torre2);
            // Mover el disco g
            System.out.println("mover disco de torre " + torre1 + " a torre " + torre3);
            // Mover n-1 discos de medio a destino
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}
