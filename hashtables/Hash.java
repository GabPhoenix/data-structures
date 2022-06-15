package com.hashtables;

public class Hash {
	private Lista vetor[];
	
	public Hash() {
		vetor = new Lista[50]; 
		init(); // iniciar as listas dentro do array 
	}
	
	private final void init() {
		for(int i=0; i<vetor.length; i++) {
			vetor[i] = new Lista();
		}
	}
	
	private final int hash(String elemento) {
		elemento = elemento.toLowerCase();
		int position = elemento.charAt(0);
		
		return position % vetor.length;
		
	}
	
	public final void insere(String elemento, String descricao) {
		vetor[hash(elemento)].inserir(elemento, descricao);
	}
	
	public final boolean busca(String elemento) {
		if(vetor[hash(elemento)].buscar(elemento)) {
			return true;
		}
		return false;
	}
	
	public final void remove(String elemento) {
		vetor[hash(elemento)].remover(elemento);;
	}
	
	
	
}
