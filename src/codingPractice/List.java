package codingPractice;

//interface - doesnt do bodies, just the bare skeleton
public interface List<E> {
	//methods needed: add(if no value at index), remove, size, isEmpty, get, set (if already have value at index)
	void add(int i, E value) throws IndexOutOfBoundsException;
	E remove(int i) throws IndexOutOfBoundsException;
	E get(int i) throws IndexOutOfBoundsException;
	E set(int i, E value) throws IndexOutOfBoundsException;
	int size();
	boolean isEmpty();
}
