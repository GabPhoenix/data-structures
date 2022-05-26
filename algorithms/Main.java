package com.algorithms;

public class Main {
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
	
	public static void main(String[] args) {
		int[] array = {36, 4, 3, 2, 5, 1, 9};
		int[] bubble = bubbleSort(array);
		System.out.println("BubbleSort: ");
		for (int i : bubble) {
			System.out.print(i + ", ");
		}
		System.out.println("\nMerge sort: ");
		int[] aux = new int[array.length];
		int[] merge = mergeSort(array, aux, 0, array.length-1);
		for (int i : merge) {
			System.out.print(i + ", ");
		}
	}
}
