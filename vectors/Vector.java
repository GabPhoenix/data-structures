package com.vectors;

public class Vector {
	public String[] elements;
	public int len;
	
	public Vector(String[] elements) {
		this.elements = elements;
		this.len = 0;
	}
	
	// add element to a vector
	public boolean addToVector(String element) {
		
		upCapacity();
		
		// verifying if len is lower than vector's length
		if(this.len<this.elements.length) {
			this.elements[len] = element;
			this.len++;
			return true;
		}
		
		return false;
	}
	
	// add element to a specific position
	public boolean addAtPosition(String element, int position) {
		
		if(!(position >= 0 && position < this.len)) {
			return false;
		}
		
		upCapacity();
		
		//move elements
		for(int i = this.len-1; i >= position; i--) {
			this.elements[i+1] = this.elements[i];
		}
		this.elements[position] = element;
		this.len++;
		return true;
	}
	
	// get len
	public int getLength() {
		return this.len;
	}
	
	
	// find element by Position
	public String findElementByPosition(int position) throws IllegalAccessException {
		if(!(position>= 0 && position < this.len)) {
			throw new IllegalAccessException("Invalid Position");
		}
		return this.elements[position];
	}
	
	// find if there is an element into the vector
	public int findElement(String element) {
		for(int i = 0; i < this.elements.length; i++) {
			if(this.elements[i].equals(element)) {
				return i;
			}
		}
		
		return -1;
	}
	
	// duplicating the capacity from the vect	or
	public void upCapacity() {
		if(this.len == this.elements.length) {
			String[] newVector = new String[this.elements.length*2];
			for(int i = 0; i < newVector.length; i++) {
				newVector[i] = this.elements[i];
			}
			this.elements = newVector;
		}
	}
	
	// remove element by position
	public void remove(int position) {
		if(!(position > 0 && position < this.len)) {
			throw new IllegalArgumentException("Invalid position!");
		}
		for(int i = position; i<this.len-1; i++) {
			this.elements[i] = this.elements[i+1];
		}
		this.len--;
	}
	
	// print the vector
	@Override
	public String toString() {
		StringBuilder vecString = new StringBuilder();
		vecString.append("[");
		
		for(int i = 0; i < this.len-1; i++) {
			vecString.append(this.elements[i]);
			vecString.append(", ");
		}								
		
		vecString.append("]");
		return vecString.toString();
	}
}
