package eva3_1_ordenamiento;

public class EVA3_1_ORDENAMIENTO {

    public static void main(String[] args) {
        int[] arregloDatos = new int[20];
        int[] arregloSel = new int[arregloDatos.length];
        int[] arregloIns = new int[arregloDatos.length];
        int[] arregloQ = new int[arregloDatos.length];
        System.out.println("ARREGLO ORIGINAL: ");
        llenar(arregloDatos);
        imprimir(arregloDatos);
        System.out.println("SELECTION SORT: ");
        copiar(arregloDatos, arregloSel);
        imprimir(arregloSel);
        System.out.println("ARREGLO COPIA ORDENADO: ");
        double ini = System.nanoTime();
        selectionSort(arregloSel);
        double fin = System.nanoTime();
        imprimir(arregloSel);
        System.out.println("Tiempo Selection Sort: " + (fin - ini));
        System.out.println("INSERTION SORT: ");
        copiar(arregloDatos, arregloIns);
        imprimir(arregloIns);
        System.out.println("ARREGLO COPIA ORDENADO: ");
        ini = System.nanoTime();
        insertionSort(arregloIns);
        fin = System.nanoTime();
        imprimir(arregloIns);
        System.out.println("Tiempo Insertion Sort: " + (fin - ini));
        System.out.println("QUICK SORT");
        copiar(arregloDatos, arregloQ);
        imprimir(arregloQ);
        // Se ordena el arreglo copia
        System.out.println("ARREGLO COPIA ORDENADO: ");
        ini = System.nanoTime();
        quickSort(arregloQ);
        fin = System.nanoTime();
        imprimir(arregloQ);
        System.out.println("Quick Sort: " + (fin - ini));
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
                if (arreglo[min] > arreglo[j]){
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
    public static void insertionSort(int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i]; // es lo que vamos a ordenar
            int insP = i;
            // BUSCAMOS EN QUE PUNTO DEBE QUEDAR TEMP
            // ESA POSICIÓN QUEDA ALMACENADA EN isnP
            for (int prev = i - 1; prev >= 0; prev--) { // comparamos
                if(arreglo[prev] > temp){
                    arreglo[insP] = arreglo[prev];
                    insP--;
                }else{
                    break;
                }
            }
            arreglo[insP] = temp;
        }
    }
    
    //Quick Sort
    public static void quickSort(int[] arreglo){
        quickSortRec(arreglo, 0, arreglo.length - 1);
    }
    
    private static void quickSortRec(int[] arreglo, int ini, int fin){
        int pivote, big, small, temp;
        pivote = ini;
        
        // Dos indices
        big = ini;
        small = fin;
        
        if(ini < fin)
        // Los indices se cruzaron 
            while(big < small){ 
                // ind_grand --> busca los mayores al pivote
                // buscar los elementos mas grandes que el pivote
                while((arreglo[big] <= arreglo[pivote]) && (big < small))
                    big++;

                while(arreglo[small] > arreglo[pivote])
                    small--;

                if(big < small){
                    temp = arreglo[big];
                    arreglo[big] = arreglo[small];
                    arreglo[small] = temp;
                }
            }
          
             temp = arreglo[pivote];
             arreglo[pivote] = arreglo[small];
             arreglo[small] = temp;
             pivote = small;

        quickSortRec(arreglo, ini, pivote - 1); 
        quickSortRec(arreglo, pivote + 1, fin);
        
    }
}
