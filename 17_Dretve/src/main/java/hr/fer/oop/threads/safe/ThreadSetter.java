package hr.fer.oop.threads.safe;

public class ThreadSetter extends Thread {
	private Point point;
	int start;

	public ThreadSetter(Point p, int s) {
		point = p;
		start = s;
	}

	public void run() {
		for (int i = start; i < 5 + start; i++) {
			point.setPoint(i, i);
			String str = point.toString();
			System.out.println("nit" + start + " " + str);
		}
	}
}
