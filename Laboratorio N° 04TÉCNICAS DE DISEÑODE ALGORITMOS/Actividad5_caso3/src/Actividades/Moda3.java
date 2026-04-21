package Actividades;
import java.util.ArrayList;

class Limits {
    int prim, ult;

    Limits(int prim, int ult) {
        this.prim = prim;
        this.ult = ult;
    }

    int longitud() {
        return ult - prim + 1;
    }
}

public class Moda3 {

    // Función principal
    public static int moda3(int[] a, int prim, int ult) {

        ArrayList<Limits> heterogeneo = new ArrayList<>();
        ArrayList<Limits> homogeneo = new ArrayList<>();

        heterogeneo.add(new Limits(prim, ult));

        while (longMayor(heterogeneo) > longMayor(homogeneo)) {

            Limits p = extraerMayor(heterogeneo);

            int mediana = a[(p.prim + p.ult) / 2];

            // Partición
            int[] res = pivote2(a, p.prim, p.ult, mediana);
            int izq = res[0];
            int der = res[1];

            Limits p1 = new Limits(p.prim, izq - 1);
            Limits p2 = new Limits(izq, der - 1);
            Limits p3 = new Limits(der, p.ult);

            if (p1.prim <= p1.ult)
                heterogeneo.add(p1);

            if (p3.prim <= p3.ult)
                heterogeneo.add(p3);

            if (p2.prim <= p2.ult)
                homogeneo.add(p2);
        }

        if (homogeneo.isEmpty())
            return a[prim];

        Limits mejor = extraerMayor(homogeneo);
        return a[mejor.prim];
    }

    // Función pivote (tipo quicksort en 3 partes)
    public static int[] pivote2(int[] a, int prim, int ult, int pivote) {

        int i = prim, j = prim, k = ult;

        while (j <= k) {
            if (a[j] < pivote) {
                swap(a, i, j);
                i++;
                j++;
            } else if (a[j] > pivote) {
                swap(a, j, k);
                k--;
            } else {
                j++;
            }
        }

        return new int[]{i, j}; // izq y der
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Devuelve el subarreglo más largo
    public static Limits extraerMayor(ArrayList<Limits> lista) {
        int idx = 0;
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).longitud() > lista.get(idx).longitud()) {
                idx = i;
            }
        }
        return lista.remove(idx);
    }

    public static int longMayor(ArrayList<Limits> lista) {
        int max = 0;
        for (Limits l : lista) {
          if (l.longitud() > max)
                max = l.longitud();
        }
        return max;
    }
}
