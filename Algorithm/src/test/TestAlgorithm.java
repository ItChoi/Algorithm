package test;

public class TestAlgorithm {

	public static void main(String[] args) {
		IntQueue que = new IntQueue(12);
		
		que.enque(1);
		que.enque(1);
		que.enque(1);
		que.enque(1);
		que.enque(1);
		que.deque();
		que.deque();
		que.deque();
		que.deque();
		que.deque();
		
		que.enque(35);
		que.enque(56);
		que.enque(24);
		que.enque(68);
		que.enque(95);
		que.enque(73);
		que.enque(19);
		
		que.dump();
		que.search(3);
	}
	
	
}


class IntQueue {
	private int max;		// 큐의 용량
	private int front;		// 첫 번째 요소 커서
	private int rear;		// 마지막 요소 커서
	private int num;		// 현재 데이터 수
	private int[] que;		// 큐 본체
	
	
	// 실행 시 예외 : 큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() { } 
	}
	
	// 실행 시 예외 : 큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() { } 
	}
	
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		
		try {
			que = new int[max];
		} catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max) {
			throw new OverflowIntQueueException();
		}
		
		que[rear++] = x;
		num++;
		
		if (rear == max) {
			rear = 0;
		}
		return x;
	}
	
	public int deque() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		int x = que[front++];
		num --;
		
		if (front == max) {
			front = 0;
		}
		
		return x;
	}
	
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.println(que[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}
	
	public int search(int x) {
		
		
		
		return 0;
	}
	
}