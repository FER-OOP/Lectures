package hr.fer.oop.recap2.task5;

import hr.fer.oop.recap2.task1.Ntuple;

public class Main {

	public static void main(String[] args) {
		PythagoreanTriangles triples = new PythagoreanTriangles(50, 80);
		for (Ntuple<Integer> p : triples)
			System.out.println(p);
		//triples = new PythagoreanTriangles(50, -2); //throws exception
	}
}
