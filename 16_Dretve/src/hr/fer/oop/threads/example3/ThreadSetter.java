package hr.fer.oop.threads.example3;

public class ThreadSetter extends Thread {
	private Point point;
	private int start;

	public ThreadSetter(Point p, int s) {
		point = p;
		start = s;
	}

	public void run() {
		for (int i = start; i < 5 + start; i++) {
			point.setPoint(i, i);
			String str = point.toString();
			System.out.println("t" + start + " " + str);
		}
	}
}
