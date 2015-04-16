package leo.impl;

import leo.adt.Queue;

public class LinkedQueue<E> implements Queue<E> {

	private SinglyLinkedList<E> list;
	
	public LinkedQueue() {}
	public LinkedQueue(E[] arr) {
		list = new SinglyLinkedList<>(arr);
	}
	
	@Override
	public int size() {return list.size();}

	@Override
	public boolean isEmpty() {return list.isEmpty();}

	@Override
	public void enqueue(E e) {list.addLast(e);}

	@Override
	public E first() {return list.first();}

	@Override
	public E dequeue() {return list.removeFirst();}

	
}
