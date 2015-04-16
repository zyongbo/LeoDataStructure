package leo.impl;

public class Josephus {

	public static <E> E josephusGame(LinkedCircularQueue<E> queue, int k) {
		if(queue.isEmpty()) return null;
		while(queue.size()>1) {
			for(int i=0; i<k-1; i++)
				queue.rotate();
			E e = queue.dequeue();
			System.out.println("    " + e + "is out");
		}
		return queue.dequeue(); //the winner
	}
	public static <E> LinkedCircularQueue<E> buildQueue(E[] a) {
		return (new LinkedCircularQueue<>(a));
	}
	
	public static void main(String[] args) {
		String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
		String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
		String[] a3 = {"Mike", "Bob", "Roberto"};
		System.out.println("First winner is " + josephusGame(buildQueue(a1), 3));
		System.out.println("Second winner is " + josephusGame(buildQueue(a2), 10));
		System.out.println("Third winner is " + josephusGame(buildQueue(a3), 7));
	}
}
