package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {

		Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
		queue.add(1);
		queue.add(2);
		queue.add(1);
		queue.add(2);
		queue.add(1);

		for (Integer val : queue) {
			System.out.print(val);
		}
		System.out.println();
		queue.poll();

		for (Integer val : queue) {
			System.out.print(val);
		}
		
		System.out.println();
		queue.poll();

		for (Integer val : queue) {
			System.out.print(val);
		}

	}
}