package hr.fer.oop.homework_09.t02;

import java.util.*;

import hr.fer.oop.homework_09.t01.Ladder;

public class LadderUtil {
	public static Iterable<Pair<String>> randomDraw(Ladder ladder) {
		List<Pair<String>> draw = new LinkedList<>();
		int count = ladder.count();
		List<String> list = new ArrayList<>(count);
		for(String s : ladder.standings()) {
			list.add(s);
		}
		Collections.shuffle(list);
		for(int i=0; i < list.size() / 2; i++) {
			draw.add(new Pair<String>(list.get(i), list.get(count - 1 - i)));
		}
		if (count % 2 == 1) {
			draw.add(new Pair<String>(list.get(count / 2), "FREE"));
		}
		return draw;
	}
}
