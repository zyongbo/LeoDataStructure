package leo.impl;

import leo.adt.Stack;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000;
	private E[] data;
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {return t+1;}

	@Override
	public boolean isEmpty() {return (size()==0);}

	@Override
	public void push(E e) throws IllegalStateException {
		if(size()==data.length)
			throw new IllegalStateException("Stack is full");
		data[t+1] = e;
		t++;
	}

	@Override
	public E top() {
		if(isEmpty()) return null;
		return data[t];
	}

	@Override
	public E pop() {
		if(isEmpty()) return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> st = new ArrayStack<>();
		st.push(5);
		st.push(3);
		System.out.println(st.size());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
		System.out.println(st.pop());
		st.push(7);
		st.push(9);
		System.out.println(st.isEmpty());
		System.out.println(st.top());
	}
}
