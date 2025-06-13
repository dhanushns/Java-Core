package dsa;

import java.util.Arrays;

public class SortAlgo {
	
	
	static void swap(int[] arr,int x,int y) {
		
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		
	}
	
	static void selectionsort(int[] arr) {
		
		int n = arr.length;
		
		for(int i = 0; i < n ; i++) {
			
			int minIndex = i;
			
			for(int j = i+1; j < n; j++) {
				
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			
		}
		
	}
	
	static void insertionsort(int[] arr) {
		
		int n = arr.length;
		
		for(int i = 1; i < n;i++) {
			
			int key = arr[i];
			int j = i-1;
			
			while(j >= 0 && arr[j] > key) {
				
				arr[j+1] = arr[j];
				j-=1;
				
			}
			
			arr[j+1] = key;
			
		}
		
		
	}
	
	static void	 rec_bubbleSort(int[] arr, int n) {
		
		if(n == 1) return;
		
		boolean isSwaped = false;
		
		for(int i = 0; i < n-1; i++) {
			
			if(arr[i] > arr[i+1]) {
				swap(arr,i,i+1);
				isSwaped = true;
			}
			
		}
		
		if(!isSwaped) return;
		
		rec_bubbleSort(arr, n-1);
		
	}
	
	static void bubblesort(int[] arr) {
		
		int n = arr.length;
		boolean isSwaped;
		for(int i = 0; i < n; i++) {
			isSwaped = false;
			for(int j = i+1; j < n; j++) {
				
				if(arr[i] > arr[j]) {
					 swap(arr,i,j);
					 isSwaped = true;
				}
				
			}
			
			if(!isSwaped) return;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {8,1,3,10,12,0};
		//rec_bubbleSort(arr, arr.length);
		//bubblesort(arr);
//		insertionsort(arr);
		selectionsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
