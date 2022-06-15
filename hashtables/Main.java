package com.hashtables;

public class Main {

	public static void main(String[] args) {
		Hash hashTable = new Hash();
		hashTable.insere("arroz", "teste 1");
		hashTable.insere("abacate", "teste 2");
		hashTable.insere("feijão", "teste 3");
		hashTable.insere("pão", "teste 4");
		hashTable.insere("padaria", "teste 5");
		hashTable.insere("farinha", "teste 6");
		// class teste manual 
		// caso: buscar um elemento existente que seja o primeiro da lista
		if(hashTable.busca("arroz")) System.out.println("buscar um elemento existente que seja o primeiro da lista: Ok"); // deve retornar true;
		else System.out.println("buscar um elemento existente que seja o primeiro da lista: ERRO");
		
		// caso: buscar um elemento existente que seja o último da lista e não seja o primeiro
		if(hashTable.busca("padaria")) System.out.println("buscar um elemento existente que seja o último da lista e não seja o primeiro: OK"); // deve retornar true;
		else System.out.println("buscar um elemento existente que seja o último da lista e não seja o primeiro: ERRO");
		
		// caso: buscar um elemento que nunca foi inserido
		if(!hashTable.busca("mandioca")) System.out.println("buscar um elemento que nunca foi inserido: OK");  // deve retornar false;
		else System.out.println("buscar um elemento que nunca foi inserido: ERRP");
		
		// caso: buscar um elemento que já foi inserido e removido
		hashTable.remove("farinha");
		if(!hashTable.busca("farinha")) System.out.println("buscar um elemento que já foi inserido e removido: OK"); // deve retornar false;
		else System.out.println("buscar um elemento que já foi inserido e removido: ERRO");
		
		// caso: remover todos os elementos de uma posição da tabela e voltar a inserir elementos novamente
		hashTable.remove("feijão");
		hashTable.insere("fazer", "teste 7");
		hashTable.insere("feito", "teste 8");
		
		if(hashTable.busca("fazer") && hashTable.busca("feito")) System.out.println("remover todos os elementos de uma posição da tabela \ne voltar a inserir elementos novamente: OK");  // deve retornar true;
		else System.out.println("remover todos os elementos de uma posição da tabela \ne voltar a inserir elementos novamente: ERRO");
	}

}
