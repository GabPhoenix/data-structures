package com.trees.binaries;

public class Test {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(15);
		tree.add(10);
		tree.add(20);
		tree.add(12);
		tree.add(5);
		tree.add(25);
		tree.add(18);
		System.out.println("Pre order:");
		tree.preOrder(tree.getRoot());
		System.out.println("\n");
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("\n");
		System.out.println("Post order:");
		tree.postOrder(tree.getRoot());
		System.out.println("\n");
		System.out.println("height: " + tree.getHeight(tree.getRoot()));
		try {
			System.out.println(tree.search(tree.getRoot(), 15).getInfo());
		} catch (NullPointerException e){
			System.out.println("The value isn't in the tree");
		} 
		try {
			System.out.println(tree.search(tree.getRoot(), 12).getInfo());
		} catch (NullPointerException e){
			System.out.println("The value isn't in the tree");
		} 
		try {
			System.out.println(tree.search(tree.getRoot(), 19).getInfo());
		} catch (NullPointerException e){
			System.out.println("The value isn't in the tree");
		} 
		try {
			System.out.println(tree.search(tree.getRoot(), 18).getInfo());
		} catch (NullPointerException e){
			System.out.println("The value isn't in the tree");
		} 
				
		System.out.println("Min value: " + tree.getMin(tree.getRoot()).getInfo());
		System.out.println("Max value: " + tree.getMax(tree.getRoot()));
		
		try {
			System.out.println("Next: "+ tree.getNext(tree.getRoot(), 18).getInfo());
		} catch (NullPointerException e){
			System.out.println("The next value is null");
		} 
		
		try {
			System.out.println("parent "+ tree.getParent(tree.getRoot(), 20).getInfo());
		} catch (NullPointerException e){
			System.out.println("There is no parent!");
		} 
		
		// remove leaf
		try { 
			tree.remove(tree.getRoot(), 25);
		} catch (NullPointerException e){
			System.out.println("There isn't in the list!");
		} 
		
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("");
		
		// remove two children
		try { 
			tree.remove(tree.getRoot(), 10);
		} catch (NullPointerException e){
			System.out.println("There isn't in the list!");
		} 
		
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("");
		
		// remove one child
		try { 
			tree.remove(tree.getRoot(), 12);
		} catch (NullPointerException e){
			System.out.println("There isn't in the list!");
		} 
		
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("");
		
		try {
			System.out.println("parent "+ tree.getParent(tree.getRoot(), 5).getInfo());
		} catch (NullPointerException e){
			System.out.println("There is no parent!");
		} 
		
	}

}
