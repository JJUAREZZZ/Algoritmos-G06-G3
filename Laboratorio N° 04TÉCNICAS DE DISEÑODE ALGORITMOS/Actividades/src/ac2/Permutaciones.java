package ac2;
import java.util.*;

public class Permutaciones {
    public static void permutar(int[] arr, List<Integer> actual, boolean[] usado) {
        if (actual.size() == arr.length) { // permutación completa
            System.out.println(actual);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!usado[i]) { // Si no ha sido elegido 
                usado[i] = true; // Marcar como usado
                actual.add(arr[i]);
                permutar(arr, actual, usado); // Avanza
                
                // Backtracking
                actual.remove(actual.size() - 1);
                usado[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] usado = new boolean[arr.length];
        permutar(arr, new ArrayList<>(), usado);
    }
}
