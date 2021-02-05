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

    /** --- Not  covered in cs245 -----------
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


    public static int[] merge(int[] arr1, int[] arr2) {

        int[] temp = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (k <= arr1.length + arr2.length) {
            if (i > arr1.length) {// ran out of elements in the i list
                temp[k] = arr2[j];
                k++;
                j++;
            } else if (j > arr2.length) {// ran out of elements in the j list
                temp[k] = arr1[i];
                k++;
                i++;
            } else if (arr1[i] < arr2[j]) { // place arr[i] in temp, move i
                temp[k] = arr1[i];
                k++;
                i++;
            } else {
                temp[k] = arr2[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        return temp;
    }

    /** public method for mergeSort - called from outside of the class */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    /**
     * A private mergeSort method - takes an array, a temporary array, and the
     * indices that specify what part of the list we are working with (we need
     * to sort the part from low to high)
     *
     * @param arr
     * @param temp
     * @param low
     * @param high
     */
    private static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return;
        // divide in half
        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);


        merge(arr, temp, low, mid, high); // merge two sorted halves into one
        // sorted list
    }

    /**
     * Merge two sorted sublists together, one that goes from low to mid another
     * goes from mid+1 to high. Uses a temporary array.
     *
     * @param arr
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int k = low;
        int i = low;
        int j = mid + 1;
        while (k <= high) {
            if (i > mid) {// ran out of elements in the i sublist
                temp[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {// ran out of elements in the j sublist
                temp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] < arr[j]) { // place arr[i] in temp, move i
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        // copy the result from temp back to arr
        for (k = low; k <= high; k++)
            arr[k] = temp[k];
    }

    public static void main(String[] args) {
        int[] array = {5, 0, 1, 15, 4, 26, 3, 9, 7, 2};

        // selectionSort(array);
        // bubbleSort(array);
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
