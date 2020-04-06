package hr.fer.oop.doodle;

import java.util.Scanner;

import hr.fer.oop.list.SimpleArrayList;

/**
 * Task 2
 *
 * An arbitrary number need to fill in a Doodle in an attempt to meet during the
 * current day. The Doodle needs to ask them to fill in their names and the
 * desired time of the meeting or the keyword "END" via the console, and print
 * their responses in a tabular format, e.g:
 *
 * | ---- |Time | |Alice |12 | |Bob |13 | |Charile |14 |
 *
 * It is necessary to use {@link hr.fer.oop.list.SimpleArrayList} from Task 1
 *
 * Zadatak 2
 *
 * Proizvoljan broj osoba trebaj popuniti Doodle u pokušaju da se sastanu u toku
 * dana. Doodle ih treba pitati da navedu imena, željeno vrijeme sastanka ili
 * ključnu riječ "END" te treba ispisati njihove odgovore u tabličnom obliku,
 * npr. :
 *
 * | ---- |Time | |Alice |12 | |Bob |13 | |Charile |14 |
 *
 * Potrebno je koristiti {@link SimpleArrayList} iz Zadatka 1
 *
 * @author OOP
 *
 */

public class Doodle {
  private static final String DOODLE_FORMAT = "|%-10s|%-10s|%n";
  private static final String EOI = "END";

  private SimpleArrayList names;
  private SimpleArrayList times;

  public Doodle() {
    names = new SimpleArrayList();
    times = new SimpleArrayList();
  }

  public static void main(String[] args) {
    Doodle d = new Doodle();
    d.askTime();

    System.out.println(d);
  }

  public String toTable() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format(DOODLE_FORMAT, "  ----  ", "Time")); // 2 spaces, 4 dashes, 2 spaces

    int len = names.size();
    for (int i = 0; i < len; i++) {
      sb.append(String.format(DOODLE_FORMAT, names.get(i), times.get(i)));

    }
    return sb.toString();

  }

  // Override method
  @Override
  public String toString() {
    return this.toTable();

  }

  public void askTime() {
    String line = null;
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Tell me your name or tell me to END.");
      line = sc.nextLine();

      if (line.equals(EOI)) {
        break;
      }

      names.add(line);
      String name = line;
      int time = -1;
      while(time < 0 || time > 23) {
        System.out.println(name + ", when can you meet (0-23)?");
        line = sc.nextLine();
        time = Integer.parseInt(line);
      }

      times.add(Integer.valueOf(time));
    }

    sc.close();

  }

  public SimpleArrayList getNames() {
    return names;
  }

  public SimpleArrayList getTimes() {
    return times;
  }

}
