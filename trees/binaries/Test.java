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
			System.out.println("Next: "+ tree.getNext(tree.getRoot(), 25).getInfo());
		} catch (NullPointerException e){
			System.out.println("There is not next value");
		} 
		
		try {
			System.out.println("parent "+ tree.getParent(tree.getRoot(), 20).getInfo());
		} catch (NullPointerException e){
			System.out.println("There is no parent!");
		} 
		
		// Trying to get the parent from a node that doesn't have parent (ROOT)
		try {
			System.out.println("parent "+ tree.getParent(tree.getRoot(), 15).getInfo());
		} catch (NullPointerException e){
			System.out.println("There is not a parent node");
		} 
		
		// remove leaf
		var t0 = tree.remove(tree.getRoot(), 25);
		if(t0 == true) {
			System.out.println("The value was deleted!");
		}else {
			System.out.println("The value is not in the tree");
		}
		
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("");
		
		// remove two children
		var t1 = tree.remove(tree.getRoot(), 10);
		if(t1 == true) {
			System.out.println("The value was deleted!");
		}else {
			System.out.println("The value is not in the tree");
		}

		
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("");
		
		// remove one child
		var t2 = tree.remove(tree.getRoot(), 12);
		if(t2 == true) {
			System.out.println("The value was deleted!");
		}else {
			System.out.println("The value is not in the tree");
		}
		
		// trying to remove a value that doesn't exist
		var t3 = tree.remove(tree.getRoot(), 49);
		if(t3 == true) {
			System.out.println("The value was deleted!");
		}else {
			System.out.println("The value is not in the tree");
		}
		
		System.out.println("In order:");
		tree.inOrder(tree.getRoot());
		System.out.println("");
		
		try {
			System.out.println("parent "+ tree.getParent(tree.getRoot(), 5).getInfo());
		} catch (NullPointerException e){
			e.getMessage();
		} 
		
	}

}
