package codingPractice;

import java.util.Arrays;

public class Sorts {
	
	//MERGESORT
	public static void merge(int[] arr, int begin, int middle, int end) {
		int[] left = Arrays.copyOfRange(arr, begin, middle+1);
		int[] right = Arrays.copyOfRange(arr, middle+1, end+1);
		int i = 0;
		int j = 0;
		int k = begin;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}
			
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < left.length) { 
            arr[k] = left[i]; 
            i++; 
            k++; 
        } 
  
        while (j < right.length) { 
            arr[k] = right[j]; 
            j++; 
            k++; 
        } 
	}
	
	public static void mergeSort(int[] arr) {
		mergeSortHelper(arr, 0, arr.length-1);
	}
	
	public static void mergeSortHelper(int[] arr, int begin, int end) {
		if(begin<end) {
			int middle = (begin+end)/2;
			mergeSortHelper(arr, begin, middle);
			mergeSortHelper(arr, middle+1, end);
			merge(arr, begin, middle, end);
		}
	}
	
	//QUICKSORT
	public static void swap(int[] arr, int swap1, int swap2) {
		int temp = arr[swap1];
		arr[swap1] = arr[swap2];
		arr[swap2] = temp;
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int arrDivide = start-1;
		for(int i = start; i < end; i++) {
			if(arr[i] <= pivot) {
				arrDivide++;
				swap(arr, arrDivide, i);
			}
		}
		swap(arr,arrDivide+1,end);
		
		return arrDivide+1;
	}
	
	public static void quickSort(int[] arr) {
		quickSortHelper(arr, 0, arr.length-1);
	}
	
	public static void quickSortHelper(int[] arr, int start, int end) {
		if(start<end) {
			int arrDivide = partition(arr, start, end);
			quickSortHelper(arr, start, arrDivide-1);
			quickSortHelper(arr, arrDivide+1,end);
		}
	}
}
