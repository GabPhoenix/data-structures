package com.lists;

public class Teste {

	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.inserirOrdenado(3);
		lista.inserirOrdenado(5);
		lista.inserirOrdenado(1);
		lista.inserirOrdenado(4);
		lista.inserirOrdenado(1);
		lista.inserirOrdenado(2);
//		lista.inserirOrdenado(0);
		lista.imprimir();
		System.out.println("tamanho: " + lista.getSize());
		lista.imprimir();
		lista.remover(0);
		lista.imprimir();
		
		
		
	}

}
