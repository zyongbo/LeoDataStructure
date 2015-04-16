package leo.impl;

import leo.adt.Deque;

public class ArrayDeque<E> implements Deque<E> {

	private static final int CAPACITY = 1000;
	private E[] data;
	private int f = 0;
	private int sz = 0;
	
	public ArrayDeque() {
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
		data = (E[]) new Object[capacity];;
	}
	
	@Override
	public int size() {return sz;}

	@Override
	public boolean isEmpty() {return sz==0;}

	@Override
	public E first() {
		if(isEmpty()) return null;
		return data[f];
	}

	@Override
	public E last() {
		if(isEmpty()) return null;
		int avail = (f+sz)%data.length;
		return data[avail];
	}

	@Override
	public void addFirst(E e) throws IllegalStateException {
		if(sz==data.length)
			throw new IllegalStateException("The queue is full");
		f = (f-1+data.length)%data.length;
		data[f] = e;
		sz++;
	}

	@Override
	public void addLast(E e) throws IllegalStateException {
		if(sz==data.length)
			throw new IllegalStateException("The queue is full");
		int avail = (f+sz+1)%data.length;
		data[avail] = e;
		sz++;
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) return null;
		E tmp = data[f];
		data[f] = null;
		f = (f+1)%data.length;
		sz--;
		return tmp;
	}

	@Override
	public E removeLast() {
		if(isEmpty()) return null;
		int lp= (f+sz)%data.length;
		E tmp = data[lp];
		data[lp] = null;
		sz--;
		return tmp;
	}
}
