package com.algorithms;

/**
 * @author iamgabc
 *
 */
public class BubbleSort {
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
	public static void main(String[] args) {
		int length = 50000;
		int k = 0;
		while(k<3) {
			int[] array = new int[length];
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
				bubbleSort(array);
				
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
			System.out.println("O algortimo BubbleSort para um array de tamanho \n"+
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
