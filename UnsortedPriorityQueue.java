package leo.impl;

import java.util.Comparator;

import leo.adt.AbstractPriorityQueue;
import leo.adt.Entry;
import leo.adt.Position;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

	private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	
	public UnsortedPriorityQueue() {super();}
	public UnsortedPriorityQueue(Comparator<K> comp) {super(comp);}
	
	//Position<> is the node of list, entry is the element of each node
	private Position<Entry<K,V>> findMin() {
		Position<Entry<K,V>> small = list.first();
		for(Position<Entry<K,V>> walk : list.positions())
			if(compare(walk.getElement(), small.getElement())<0)
				small = walk;
		return small;
	}
	
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}
	
	public Entry<K,V> min() {
		if(list.isEmpty()) return null;
		return findMin().getElement();
	}
	
	public Entry<K,V> removeMin() {
		if(list.isEmpty()) return null;
		return list.remove(findMin());
	}
	
	public int size() {return list.size();}
}
