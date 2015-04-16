package leo.impl;

/**
 * 
 * @author zyongbo
 * @category singly linked list, head and tail are not functioning as sentinel
 * @param <E>
 * 
 */

public class SinglyLinkedList<E> implements Cloneable {

	//--------nested class for list node definition----------
	public static class Node<E> {
		private E element;
		private Node<E> next;
		
		//Node() is all about default values
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> n) {next = n;}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;	
	
	//constructors
	public SinglyLinkedList() {}
	public SinglyLinkedList(E[] arr) {
		for(int i=arr.length-1; i>=0; i--) {
			addFirst(arr[i]);
			size++;
		}
	}
	
	//head is the first element, and tail is the last element
	public int size() {return size;}
	public boolean isEmpty() {return size==0;}
	public E first() {
		if(isEmpty()) return null;
		return head.getElement();
	}
	public E last() {
		if(isEmpty()) return null;
		return tail.getElement();
	}
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if(isEmpty()) {
			tail = head;
		}
		size++;
	}
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if(isEmpty()) {
			head = newest;
			tail = head;
		}
		tail.setNext(newest);
		tail = newest;
		size++;
	}
	public E removeFirst() {
		if(isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if(size==0)
			tail = null;
		return answer;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(Object o) {
		if(o==null) return false;
		if(this.getClass()!=o.getClass()) return false;
		SinglyLinkedList other = (SinglyLinkedList) o;
		if(size!=other.size) return false;
		Node walkA = head;
		Node walkB = other.head;
		while(walkA!=null) {
			if(!walkA.getElement().equals(walkB.getElement())) return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		@SuppressWarnings("unchecked")
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
		if(size>0) {
			other.head = new Node<>(head.getElement(), null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			while(walk!=null) {
				Node<E> newest = new Node<>(walk.getElement(), null);
				otherTail.setNext(newest);
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
}
