package sorting;

import java.util.Arrays;

/** A class demonstrating several sorting algorithms covered in the Data Structures and Algorithms course */
public class SortingAlgorithms {

    /**
     * Selection sort
     * @param arr input array
     */
    public static void selectionSort(int[] arr) {
        if (arr == null)
            return;
        for (int i = 0; i < arr.length; i++) {
            // find the current smallest element in the
            // sublist from index i until the end of the list
            int indexOfMin = i;
            for (int j = indexOfMin + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin])  {
                    indexOfMin = j;
                }
            }
            // Now we know the smallest element in the sublist from i to n-1: arr[indexOfMin]
            // swap it with the element at index i
            int tmp = arr[indexOfMin];
            arr[indexOfMin] = arr[i];
            arr[i] = tmp;
        }
    }

    /**
     * Bubble sort
     * @param arr input array
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null)
            return;
        for (int pos = 0; pos < arr.length - 1; pos++) {
            // Bubble up the smallest element to the front of the list
            for (int j = arr.length - 1; j > pos; j--) {
                if (arr[j - 1] > arr[j] ) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1]= tmp;
                }
            }
        }
    }

    /**
     * Insertion sort
     * @param arr input array
     */
    public static void insertionSort(int[] arr) {
        if (arr == null)
            return;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            // Compare with elements of the sorted list, starting at i - 1;
            int j = i - 1;
            while ((j >= 0) && (curr < arr[j])) {
                arr[j + 1] = arr[j]; // shift elements to make space for curr
                j--;
            }
            arr[j + 1] = curr; // place curr
        }
    }

    /**
     * Sort a given array using shell sort and n/2, n/4, n/8 etc increments. The
     * code is modified from the code of Prof. Galles.
     */
    public static void shellSort(int[] arr) {
        if (arr == null)
            return;
        int n = arr.length;
        int increment, offset;
        for (increment = n / 2; increment > 0; increment = increment / 2)
            for (offset = 0; offset < increment; offset++)
                insertionSort(arr, offset, increment);
    }

    /**
     * Another version of the insertion sort that sorts a sublist of a given
     * list. Used in Shell Sort. Takes an offset (the first element of the list
     * will be at arr[offset]) and increment (the gap between the elements of
     * the list)
     */
    public static void insertionSort(int[] arr, int offset, int increment) {
        if (arr == null)
            return;
        int i, j;
        int n = arr.length;
        for (i = offset + increment; i < n; i = i + increment) {
            int curr = arr[i];
            j = i - increment;
            while (j >= 0 && arr[j] > curr) {
                arr[j + increment] = arr[j];
                j = j - increment;
            }
            arr[j + increment] = curr;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 0, 1, 15, 4, 26, 3, 9, 7, 2};

        // selectionSort(array);
        // bubbleSort(array);
        insertionSort(array);
        // shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
