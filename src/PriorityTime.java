import java.util.PriorityQueue;

public class PriorityTime {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();


		pq.add(9);
		pq.offer(6);
		System.out.println(pq.peek()+" #");
		pq.offer(5);
		pq.add(8);
		pq.add(10);
		System.out.println(pq);
		System.	out.println(pq.poll() + " @");
		System.out.println(pq.size() + " %");
		System.out.println(pq);
		pq.remove(2);
		System.out.println(pq);
	}
}
