package com.hashtables;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Teste {
	static Hash hashTable = new Hash();
	
	@BeforeAll
	static void beforeAll() {
		hashTable.insere("arroz", "teste 1");
		hashTable.insere("abacate", "teste 2");
		hashTable.insere("feijão", "teste 3");
		hashTable.insere("pão", "teste 4");
		hashTable.insere("padaria", "teste 5");
		hashTable.insere("farinha", "teste 6");
	}
	
	@Test
	void buscaPrimeiroDaLista() {
		assertTrue(hashTable.busca("arroz"));
	}
	
	@Test
	void buscaExistenteQueSejaUltimoDaLista() {
		assertTrue(hashTable.busca("padaria"));
	}
	
	@Test
	void buscaElementoNuncaInserido() {
		assertFalse(hashTable.busca("mandioca"));
	}
	
	@Test
	void buscaElementoJaRemovido() {
		hashTable.remove("farinha");
		assertFalse(hashTable.busca("farinha"));
	}
	
	@Test
	void buscaAposRemoverTodosEInserirNovos() {
		hashTable.remove("feijão");
		hashTable.insere("fazer", "teste 7");
		hashTable.insere("feito", "teste 8");
		assertTrue(hashTable.busca("fazer"));
		assertTrue(hashTable.busca("feito"));
	}

}
