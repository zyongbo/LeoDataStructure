package leo.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import leo.adt.List;

public class ArrayList<E> implements List<E> {

	public static final int CAPACITY=16;
	private E[] data;
	private int size=0;
	
	public ArrayList() {this(CAPACITY);}
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity, E[] arr) throws IllegalStateException {
		data = (E[]) new Object[capacity];
		if(arr.length>capacity)
			throw new IllegalStateException("Capacity is too less");
		for(int i=0; i<arr.length; i++) {
			data[i] = arr[i];
		}
	}
	
	private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if(i<0 || i>=n)
			throw new IndexOutOfBoundsException("Illegal index " + i);
	}
	
	@Override
	public int size() {return size;}
	@Override
	public boolean isEmpty() {return size==0;}
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E tmp = data[i];
		data[i] = e;
		return tmp;
	}
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		if(size==data.length)
			resize(2*data.length);
		for(int k=size-1; k>=i; k--) {
			data[k+1] = data[k];
		}
		data[i] = e;
		size++;
	}
	public void add(E e) throws IndexOutOfBoundsException {
		checkIndex(size,size+1);
		if(size==data.length)
			resize(2*data.length);
		data[size] = e;
		size++;
	}
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E tmp = data[i];
		for(int k=i+1; k<size; k++)
			data[k-1] = data[k];
		data[size-1] = null;
		size--;
		return tmp;
	}
	
	@SuppressWarnings("unchecked")
	protected void resize(int capacity) {
		E[] tmp = (E[]) new Object[capacity];
		for(int i=0; i<data.length; i++)
			tmp[i] = data[i];
		data = tmp; //reference type, only the address of the beginning of the array
	}
	
	//----------nested ArrayIterator class-----------
	@SuppressWarnings("hiding")
	private class ArrayIterator<E> implements Iterator<E> {

		private int j = 0;
		private boolean removable = false;
		
		@Override
		public boolean hasNext() {return (j<size);}

		@SuppressWarnings("unchecked")
		@Override
		public E next() throws NoSuchElementException {
			if(j==size) throw new NoSuchElementException("No next element");
			removable = true;
			return (E) data[j++];
		}
		
		public void remove() throws IllegalStateException {
			if(!removable) throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j-1);
			j--;
			removable = false;
		}
	}
	
	public Iterator<E> iterator() {
		return new ArrayIterator<E>();
	}
}
