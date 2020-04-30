package hr.fer.oop.pred.kolekcije.av.zad2;

public class Score implements Comparable<Score>{

	private String name;
	private double score;
	
	public Score(String name, double score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Score o) {
//		if (o.getScore() > this.getScore()) return 1;
//		else if (o.getScore() == this.getScore()) return 0;
//		return -1;
		return Double.compare(o.getScore(), this.getScore());
	}
	
}
