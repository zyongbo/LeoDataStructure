package leo.impl;

/**
 * 
 * @author zyongbo
 * @category header, tailer are sentinels
 * @param <E>
 */
public class DoublyLinkedList<E> {

	public static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public Node<E> getPrev() {return prev;}
		public void setNext(Node<E> n) {next = n;}
		public void setPrev(Node<E> p) {prev = p;}
	}
	
	//functions as sentinels
	private Node<E> header = null;
	private Node<E> tailer = null;
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		tailer = new Node<E>(null, header, null);
		header.setNext(tailer);
	}
	public DoublyLinkedList(E[] arr) {
		this();
		for(int i=arr.length-1; i>=0; i--) {
			addBetween(arr[i], header, header.getNext());
			size++;
		}
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size==0;}
	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	public E last() {
		if(isEmpty()) return null;
		return tailer.getPrev().getElement();
	}
	
	public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	public E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	public void addLast(E e) {
		addBetween(e, tailer.getPrev(), tailer);
	}
	public E removeFirst() {
		if(isEmpty()) return null;
		return remove(header.getNext());
	}
	public E removeLast() {
		if(isEmpty()) return null;
		return remove(tailer.getPrev());
	}
}
