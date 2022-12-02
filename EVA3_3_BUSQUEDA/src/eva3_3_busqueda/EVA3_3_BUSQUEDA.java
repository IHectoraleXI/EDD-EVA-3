package eva3_3_busqueda;

import java.util.Scanner;

public class EVA3_3_BUSQUEDA {

    public static void main(String[] args) {
        int[] arregloDatos = new int[15];
        int[] arregloSel = new int[15];
        llenar(arregloDatos);
        copiar(arregloDatos, arregloSel);
        selectionSort(arregloSel);
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el valor a buscar.");
        int buscar = input.nextInt();
        System.out.println("El valor está en la posición: " + busquedaBinaria(arregloSel, buscar));
    }

    //Llenar arreglo
    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }

    //Imorimir arreglo
    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < 10) {
                System.out.print("[0" + arreglo[i] + "]");
            } else {
                System.out.print("[" + arreglo[i] + "]");
            }
        }
        System.out.println("");
    }

    //Copiar arreglo
    public static void copiar(int[] arreglo, int[] copia) {
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }

    //Selection Sort
    public static void selectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            //Busqueda del elemento más pequelo
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            //Intercambio
            if (min != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
            }
        }
    }

    //Insertion Sort
    public static void insertionSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i]; // es lo que vamos a ordenar
            int insP = i;
            // BUSCAMOS EN QUE PUNTO DEBE QUEDAR TEMP
            // ESA POSICIÓN QUEDA ALMACENADA EN isnP
            for (int prev = i - 1; prev >= 0; prev--) { // comparamos
                if (arreglo[prev] > temp) {
                    arreglo[insP] = arreglo[prev];
                    insP--;
                } else {
                    break;
                }
            }
            arreglo[insP] = temp;
        }
    }

    public static int busquedaBinaria(int[] datos, int valor) {
        return busquedaBinariaRec(datos, 0, datos.length - 1, valor);
    }

    private static int busquedaBinariaRec(int[] datos, int ini, int fin, int valor) {
        int mitad = ini + ((fin - ini) / 2);
        int resu = -1;
        if (ini < fin) {
            if (valor == datos[mitad]) {
                resu = mitad;
            } else if (valor < datos[mitad]) {
                resu = busquedaBinariaRec(datos, ini, mitad - 1, valor);
            } else {
                resu = busquedaBinariaRec(datos, mitad + 1, fin, valor);
            }
        }
        return resu;
    }
}
