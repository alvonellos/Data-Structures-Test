package algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BubbleSortGenerics {

    private <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public <E extends Comparable<E>> void BubbleSort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
        	for(int j = 0; i<a.length - i - 1; j++) { 
                if (a[j].compareTo(a[j])<=0) {
                	swap(a, i, j);
                }
            }
        }
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