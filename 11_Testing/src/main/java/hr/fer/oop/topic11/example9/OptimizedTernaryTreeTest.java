package hr.fer.oop.topic11.example9;

import hr.fer.oop.topic11.example7.BinaryTree;
import hr.fer.oop.topic11.example7.Container;
import hr.fer.oop.topic11.example8.EnglishConvert;
import hr.fer.oop.topic11.example8.TernaryTree;
import java.util.Random;

public class OptimizedTernaryTreeTest {

    public static void main(String[] args) {

        Container<String> ternaryTree = new TernaryTree<>();
        Container<String> optimizedTree = new OptimizedTernaryTree<>();
        Container<String> binaryTree = new BinaryTree<>();

        //ukupni broj objekata
        final int N = 100000;
        String[] items = new String[N];

        Random random = new Random();
        for (int i = 0; i < N; i++) {
            //dohvati objekt kao nasumični cijeli broj u intervalu [-N,N]
            int item = random.nextInt(2 * N + 1) - N;
            //dodaj objekte u polje (služi za kasnije traženje)
            items[i] = EnglishConvert.numberToWords(item);
        }

        for (int i = 0; i < N; i++) {
            //dodaj objekte u spremnike
            ternaryTree.add(items[i]);
            optimizedTree.add(items[i]);
            binaryTree.add(items[i]);
        }
        System.out.println("Dodao sam " + fancyNum(N) + " u stabla.");
        
        //potraži dodane objekte
        int found[] = new int[3];
        for (int i = 0; i < N; i++) {
            
            if (ternaryTree.contains(items[i])) {
                found[0]++;
            }   
            
            if (optimizedTree.contains(items[i])) {
                found[1]++;
            }
            
            if (binaryTree.contains(items[i])) {
                found[2]++;
            }
        }
        System.out.println("Pronašao sam " + fancyNum(found[0]) + " u ternarnom stablu, " 
                + fancyNum(found[1]) + " u optimiziranom ternarnom stablu i "
                + fancyNum(found[2]) + " u binarnom stablu.");
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