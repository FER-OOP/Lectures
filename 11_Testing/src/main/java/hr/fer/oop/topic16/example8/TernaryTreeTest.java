package hr.fer.oop.topic16.example8;

import hr.fer.oop.topic16.example7.Container;
import java.util.Random;

public class TernaryTreeTest {

    public static void main(String[] args) {

        Container<Integer> ternaryTree = new TernaryTree<>();

        //ukupni broj objekata
        final int N = 100000;
        Integer[] items = new Integer[N];

        //dodat ćemo 0 kao prvi objekt (zbog balansiranja)
        items[0] = 0;

        Random random = new Random();
        for (int i = 1; i < N; i++) {
            //dohvati objekt kao nasumični cijeli broj u intervalu [-N,N]
            int item = random.nextInt(2 * N + 1) - N;
            //dodaj objekte u polje (služi za kasnije traženje)
            items[i] = item;
        }

        for (int i = 0; i < N; i++) {
            //dodaj objekte u spremnike
            ternaryTree = ternaryTree.add(items[i]);
        }
        System.out.println("Dodao sam " + fancyNum(N) + " u ternarno stablo.");
        //potraži dodane objekte
        int found = 0;
        for (int i = 0; i < N; i++) {
            
            if (ternaryTree.contains(items[i])) {
                found++;
            }            
        }
        System.out.println("Pronašao sam " + fancyNum(found) + " u ternarnom stablu.");
    }

    public static String fancyNum(int i) {
        int digit = i % 10;

        if (digit == 1) {
            return i + " objekt";
        } else if (digit >= 2 && digit <= 4) {
            return i + " objekta";
        } else {
            return i + " objekata";
        }
    }
}