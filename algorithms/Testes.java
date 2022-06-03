package com.algorithms;

public class Testes {
	public static int[] bubbleSort(int[] array) {
		int aux;
		boolean exchange;
		for(int i=0; i<array.length; i++) {
			exchange = true;
			for(int j=0; j < array.length - 1; j++) {
				if(array[j] > array[j + 1]) {
					aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
					exchange = false;
				}
			}
			if(exchange) {
				break;
			}
		}
		return array;
	}
	
	public static int[] mergeSort(int array[], int[] aux, int low, int high) {
		int mid = (low + high)/2;
		if(low < high) {
			mergeSort(array, aux, low, mid);
			mergeSort(array, aux, mid + 1, high);
			join(array, aux, low, mid, high);
		}
		return array;
	}
	
	private static int[] join(int array[], int[] aux, int low, int mid, int high) {
		for(int i=low; i<=high; i++) {
			aux[i] = array[i]; // clonar o vetor
		}
		int left = low;
		int right = mid + 1;
		
		for(int i=low; i<=high; i++) {
			if(left > mid) { // caso o da esquerda acabe
				array[i] = aux[right++];
				
			} else if(right > high) { // caso o da direita acabe
				array[i] = aux[left++];
			} else if(aux[left] < aux[right]) { // caso o da esquerda for menor que o da direita
				array[i] = aux[left++];
			} else { // caso o da direita for menor que o da esquerda;
				array[i] = aux[right++];
			}
		}
		return array;
	}
	
	public static int[] quickSort(int[] array, int left, int right) {
		if(left < right) {
			int p = part(array, left, right);
			quickSort(array, left, p);
			quickSort(array, p + 1, right);
		}
		return array;
	}
	
	private static int part(int[] array, int left, int right) {
		int mid = (left + right)/2;
		int pivot = array[mid];
		int i = left - 1, j = right + 1;
		while(true) {
			do {
				i++;
			} while(array[i] < pivot);
			do {
				j--;
			} while(array[j] > pivot);
			if(i>=j) {
				return j;
			}
			int aux = array[i];
			array[i] = array[j];
			array[j] = aux;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {36, 4, 3, 2, 5, 1, 9};
		int[] bubble = bubbleSort(array);
		System.out.println("BubbleSort: ");
		for (int i : bubble) {
			System.out.print(i + ", ");
		}
		
		System.out.println("\nMergeSort: ");
		int[] aux = new int[array.length];
		int[] merge = mergeSort(array, aux, 0, array.length-1);
		for (int i : merge) {
			System.out.print(i + ", ");
		}
		
		System.out.println("\nQuickSort: ");
		int[] quick = quickSort(array, 0, array.length-1);;
		for (int i : quick) {
			System.out.print(i + ", ");
		}
	}
}
