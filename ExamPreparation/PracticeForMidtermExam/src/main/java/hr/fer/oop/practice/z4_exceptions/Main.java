package hr.fer.oop.practice.z4_exceptions;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		int[] numbers = new int[] { 15, 0, 10 };
		try {
			Stream s40 = new Stream(40);
			for (int i = 0; i <= numbers.length; i++)
				iteration(numbers, i);
			Stream s50 = new Stream(50);
		} catch (Exception e) {
			System.out.println("main: exception");
		} finally {
			System.out.println("main: finally");
		}
		System.out.println("main: done");
	}

	private static void iteration(int[] arr, int i) throws IOException {
		try (Stream s = new Stream(i)) {
			division(arr[i] + arr[i + 2], i);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("iteration: array index");
			throw new IOException(e);
		}
		System.out.println("iteration: done");
	}

	private static int division(int x, int y) throws IOException {
		int r = 0;
		try (Stream s = new Stream(x + y)) {
			r = y / x;
		} finally {
			System.out.println("div: finally");
		}
		System.out.println("div: done");
		return r;
	}
}
