import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    static final int N = 10; // Tamaño del arreglo

    public static void main(String[] args) {
        int[] arr = new int[N];
        long t_ini, t_end;
        double t_elapsed;

        createArray(arr);

            // Bubble Sort
        
   int[] bubbleArr = arr.clone();
   System.out.println("Original Array for Bubble Sort:");
   printArray(bubbleArr);
   t_ini = System.currentTimeMillis();
   System.out.println("\nInitial time: " + t_ini);
   bubbleSort(bubbleArr);
   t_end = System.currentTimeMillis();
   System.out.println("Final time: " + t_end);
   t_elapsed = (t_end - t_ini) / 1000.0;
   System.out.println("Total time: " + t_elapsed + " secs");
   System.out.println("Sorted Array for Bubble Sort:");
   printArray(bubbleArr);
   
   // Insertion Sort

   int[] insertionArr = arr.clone();
   System.out.println("Original Array for Insertion Sort:");
   printArray(insertionArr);
   t_ini = System.currentTimeMillis();
   System.out.println("\nInitial time: " + t_ini);
   insertionSort(insertionArr);
   t_end = System.currentTimeMillis();
   System.out.println("Final time: " + t_end);
   t_elapsed = (t_end - t_ini) / 1000.0;
   System.out.println("Total time: " + t_elapsed + " secs");
   System.out.println("Sorted Array for Insertion Sort:");
   printArray(insertionArr);
   

    // Merge Sort
   int[] mergeArr = arr.clone();
   System.out.println("Original Array for Merge Sort:");
   printArray(mergeArr);
   t_ini = System.currentTimeMillis();
   System.out.println("\nInitial time: " + t_ini);
   mergeSort(mergeArr, 0, mergeArr.length - 1);
   t_end = System.currentTimeMillis();
   System.out.println("Final time: " + t_end);
   t_elapsed = (t_end - t_ini) / 1000.0;
   System.out.println("Total time: " + t_elapsed + " secs");
   System.out.println("Sorted Array for Merge Sort:");
   printArray(mergeArr);

   // Quick Sort
   int[] quickArr = arr.clone();
   System.out.println("Original Array for Quick Sort:");
   printArray(quickArr);
   t_ini = System.currentTimeMillis();
   System.out.println("\nInitial time: " + t_ini);
   quickSort(quickArr, 0, quickArr.length - 1);
   t_end = System.currentTimeMillis();
   System.out.println("Final time: " + t_end);
   t_elapsed = (t_end - t_ini) / 1000.0;
   System.out.println("Total time: " + t_elapsed + " secs");
   System.out.println("Sorted Array for Quick Sort:");
   printArray(quickArr);

   */
    }

    // Implementación de Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Implementación de Insertion Sort
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Implementación de Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Implementación de Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Genera un arreglo de tamaño N con valores aleatorios
    public static void createArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = rand.nextInt(1000000);
        }
    }

    // Imprime un arreglo
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
