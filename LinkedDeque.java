package leo.impl;

import leo.adt.Deque;

public class LinkedDeque<E> implements Deque<E> {

	private DoublyLinkedList<E> list;
	
	public LinkedDeque() {
		list = new DoublyLinkedList<>();
	}
	public LinkedDeque(E[] arr) {
		list = new DoublyLinkedList<>(arr);
	}
	
	@Override
	public int size() {return list.size();}

	@Override
	public boolean isEmpty() {return list.isEmpty();}

	@Override
	public E first() {return list.first();}

	@Override
	public E last() {return list.last();}

	@Override
	public void addFirst(E e) {list.addFirst(e);}

	@Override
	public void addLast(E e) {list.addLast(e);}

	@Override
	public E removeFirst() {return list.removeFirst();}

	@Override
	public E removeLast() {return list.removeLast();}

	
}
