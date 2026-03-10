import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("cantidad numeros: ");
        int n = sc.nextInt();

        long t1 = 0, t2 = 1;
        System.out.print("serie del fibonacci: " + t1 + " " + t2);

        for (int i = 3; i <= n; i++) {
            long sum = t1 + t2;
            System.out.print(" " + sum);
            t1 = t2;
            t2 = sum;
        }
    }
}
