package com.hashtables;

public class Lista {
	private Node ref;
	private int size;
	
	public Lista() {
		
	}
	
	public Lista(Node novo) {
		this.ref = novo;
		this.size = 0;
	}
	
	// get size
	public int getSize() {
		return this.size;
	}
	
	// inserir 
	public void inserir(String elemento, String descrição){
		Node node = new Node(elemento, descrição);
		node.setProx(this.ref);
		this.ref = node;
		this.size++;
		return;
	}
	

	// inserir ordenando
//	public void inserirOrdenado(String elemento) {
//		if(this.listaVazia()) {
//			inserir(elemento);
//			return;
//		} else {
//			if(this.ref.getInfo() >= elemento) {
//				No node = new No(elemento);
//				node.setProx(this.ref);
//				this.ref = node;
//				this.size++;
//				return;
//			} else {
//				No anterior = this.ref, atual = this.ref.getProx();
//				while(atual != null && elemento > atual.getInfo()) {
//					anterior = atual;
//					atual = atual.getProx();
//				}
//				No temp = new No(elemento);
//				anterior.setProx(temp);
//				temp.setProx(atual);
//				this.size++;
//				return;
//			}
//		}
//	}
	

	// lista vazia
	public boolean listaVazia() {
		if(this.ref!=null) {
			return false;
		}
		return true;
	}
	
	// imprimir 
	public void imprimir() {
		if(this.listaVazia()) {
			System.out.println("Lista Vazia!");
			return;
		} 
		for(Node position=this.ref; position!=null; position = position.getProx()) {
			System.out.print("[");
			System.out.print(position.getInfo() + " ");
			System.out.print("]");
		}
		System.out.println(" \n");
	}
	
	// buscar
	public boolean buscar(String elemento) {
		Node position;
		for(position=this.ref; position!=null; position = position.getProx()) {
			if(position.getInfo().equals(elemento)) {
				return true;
			}
		}
		return false;
	}
	
	// remover 
	public void remover(String elemento) {
		Node anterior = null;
		for(Node position=this.ref; position!=null; position = position.getProx()) {
//			if(position.getInfo() > elemento) {
//				System.out.println("Não está na lista!");
//				return;
//			}
			if(position.getInfo().equals(elemento)) {
				if(position == this.ref) {
					this.ref = position.getProx();
					this.size--;
					return;
				} else {
					anterior.setProx(position.getProx());
					this.size--;
					return;
				}
			}
			anterior = position;
		}
		System.out.println("Não encotrado!");
	}
	
}
