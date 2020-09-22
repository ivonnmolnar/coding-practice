package codingPractice;

public class ArrayList<E> implements List<E>{
	//constructors
	public ArrayList() {
		this(capacity);
	}
	public ArrayList(int i) {
		values = (E[]) new Object[i];
	}
	
	//fields
	private static int capacity = 16; //default value - needs to be static so we can use it in constructor
	private int size = 0;
	private E[] values;
	
	//method implementations from the list interface
	public E set(int i, E value) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E ogValue = values[i];
		values[i] = value;
		return ogValue;
	}
	
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		return values[i];
	}
	
	public void add(int i, E value) throws IndexOutOfBoundsException{
		checkIndex(i, size+1);
		if(size == values.length) {
			resize(2 * size);
		}
		for(int j = size-1; j >= i; j--) {
			values[j+1] = values[j];
		}
		values[i] = value;
		size++;
	}
	
	public E remove(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E temp = values[i];
		for(int j = i; j < size-1; j--) {
			values[j] = values[j+1];
		}
		values[size-1] = null;
		size--;
		return temp;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	//helper methods
	//if index is out of bounds, throws exception
	protected void checkIndex(int i, int n) {
		if(i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
	}
	
	//creates new array twice the sign, copies values into it and then assigns it to values variable, "discarding" the prev one
	protected void resize(int newCap) {
		E[] arr = (E[]) new Object[newCap];
		for(int i = 0; i < size; i++) {
			arr[i] = values[i];
		}
		values = arr;
	}
}
