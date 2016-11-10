package hr.fer.oop.topic16.example7;

import java.util.Random;

public class BinaryTreeTest {

    public static void main(String[] args) {

        Container<Integer> bt = new BinaryTree<>();

        //ukupni broj objekata
        final int N = 10000;
        int[] items = new int[N];

        Random random = new Random();
        for (int i = 0; i < N; i++) {
            //dohvati objekt kao nasumični cijeli broj u intervalu [-N,N]
            int item = random.nextInt(2 * N + 1) - N;
            //dodaj objekte u polje (služi za kasnije traženje)
            items[i] = item;
        }

        for (int i = 0; i < N; i++) {
            //dodaj objekte u binarno stablo
            bt = bt.add(items[i]);
        }
        System.out.println("Dodao sam " + fancyNum(N) + " u binarno stablo.");
        //potraži dodane objekte
        int numberOfFound = 0;
        for (int i = 0; i < N; i++) {
            if (bt.contains(items[i])) {
                numberOfFound++;
            }
        }
        System.out.println("Pronašao sam " + fancyNum(numberOfFound) + " u binarnom stablu.");
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
