package leo.impl;

/**
 * 
 * @author zyongbo
 * @category tail is node in the list
 * @param <E>
 */
public class CircularlyLinkedList<E> {

	public static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> n) {next = n;}
	}
	
	private Node<E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() {}
	public CircularlyLinkedList(E[] arr) {
		for(int i=arr.length-1; i>=0; i--) {
			addFirst(arr[i]);
			size++;
		}
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size==0;}
	public E first() {
		if(isEmpty()) return null;
		return tail.getNext().getElement();
	}
	public E last() {
		if(isEmpty()) return null;
		return tail.getElement(); 
	}
	public void rotate() {
		if(tail!=null)
			tail = tail.getNext();
	}
	public void addFirst(E e) {
		if(isEmpty())
			tail = new Node<>(e, tail);
		Node<E> newest = new Node<>(e, tail.getNext());
		tail.setNext(newest);
		size++;
	}
	public void addLast(E e) {
		addFirst(e);
		rotate();
	}
	public E removeFirst() {
		if(isEmpty()) return null;
		Node<E> head = tail.getNext();
		if(head==tail) tail = null;
		tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
}
