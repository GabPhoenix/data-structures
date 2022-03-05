package com.circularlists;

public class Test {

	public static void main(String[] args) {
		CircularList list = new CircularList();
		list.sortInsert(4);
		list.sortInsert(2);
		list.sortInsert(3);
		list.sortInsert(5);
		list.printCircularList();
		System.out.println("Length: "+ list.getSize());
		list.remove(2);
		list.remove(3);
		list.remove(4);
		list.remove(5);
		list.printCircularList();
		list.sortInsert(3);
		list.sortInsert(2);
		list.sortInsert(11);
		list.printCircularList();
		System.out.println("Length: "+ list.getSize());

	}
}
