package algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuickSortGenerics {

    private <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public <E extends Comparable<E>> void QuickSort(E[] a, int low, int high) {

    }
   
	/* This function takes last element as pivot, places
	the pivot element at its correct position in sorted
	 array, and places all smaller (smaller than pivot)
	to left of pivot and all greater elements to right
	of pivot */
	 private <E extends Comparable<E>> void partition (E[] arr, int low, int high)
	 {
	     // pivot (Element to be placed at right position)
	     E pivot = arr[high];  
	  
	     int i = (low - 1)  // Index of smaller element and indicates the 
	                    // right position of pivot found so far
	
	     for (j = low; j <= high- 1; j++)
	     {
	         // If current element is smaller than the pivot
	         if (arr[j] < pivot)
	         {
	             i++;    // increment index of smaller element
	             swap arr[i] and arr[j]
	         }
	     }
	     swap arr[i + 1] and arr[high])
	     return (i + 1)
	 }

    public static void main(String[] args){
        SelectionSortGenerics firstsort = new SelectionSortGenerics();

        Integer[] arr = {3,4,1,5};
        System.out.println("before sorting int: "+ Arrays.toString(arr));
        firstsort.selectionSort(arr);
        System.out.println("After sorting int : "+Arrays.toString(arr));
         String[] arr1= {"acd","ded","dal","bad","cle"};
         System.out.println("before sorting String: "+ Arrays.toString(arr1));
         firstsort.selectionSort(arr1);
         System.out.println("After sorting String : "+Arrays.toString(arr1));
         Character[] arr2= {'c','e','a','d','c'};
         System.out.println("before sorting char: "+ Arrays.toString(arr2));
         firstsort.selectionSort(arr2);
         System.out.println("After sorting char : "+Arrays.toString(arr2));
    }
}