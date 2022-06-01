package com.algorithms;

public class MergeSort {
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
		int length = 50000;
		int k = 0;
		while(k<3) {
			int[] array = new int[length];
			int[] aux = new int[length];
			int[] clone = new int[length];
			double[] tempo = new double[30];
			double mediaDeTempo = 0;
			
			// povoando o array
			for(int i=0; i<array.length; i++) {
				// para gerar um númeroa aleatório entre 0 e 10000
				int random_int = (int) Math.floor(Math.random()*(10000-1)+1);
				array[i] = random_int;
			}
			
			// clonar o array 
			for(int i=0; i<array.length; i++) {
				clone[i] = array[i];
			}
			
			// medir o tempo de execução para 30 casos
			for(int i=0; i<30; i++) {
				// pegar o tempo inicial
				long start = System.currentTimeMillis();
				mergeSort(array, aux, 0, array.length-1);			
				// peagar o tempo de execução final em segundos 
				double end = (System.currentTimeMillis() - start)/1000.0; 
				
				// armazenar o tempo no array de tempos 
				tempo[i] = end;
				
				// retornar o array a sua forma inicial
				for(int j=0; j<clone.length; j++) {
					array[j] = clone[j];
				}
			}
			
			// calcular a média de tempos
			for(double t : tempo) {
				mediaDeTempo+=t;
			}
			mediaDeTempo = mediaDeTempo/30;
			
			// exibir tempo médio de execução do algortimo 
			System.out.println("O algortimo mergeSort para um array de tamanho \n"+
			length+" executou em um tempo médio de: "+String.format("%.5f", mediaDeTempo)+" s\n");
			k++;
			if(k==1) {
				length = 100000;
			} else if(k==2) {
				length = 200000;
			}
		}
		
	}

}
