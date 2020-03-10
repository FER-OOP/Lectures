package hr.fer.oop.introduction.strings;


/*
Napisati program koji će sa komandne linije primiti niz slova sastavljenih od znakova A, C, G i T,
koji predstavlja sekvencu DNK. Ispisati na ekran reverzno komplementarnu sekvencu.
Reverzno komplementarna sekvenca je sekvenca je sekvenca u kojoj je svaki znak zamijenjen komplementarnim
te koja ima obrnuti redoslijed od početne. Parovi znakova A-T i C-G su međusobno komplementarni.
Npr. za ulaznu sekvencu AACCGT treba ispisati ACGGTT.
 */

public class Bioinfo {

    // Izračunaj komplementarni znak
    public static char complementChar(char c) {
        if (c == 'A') return 'T';
        else if (c == 'C') return 'G';
        else if (c == 'G') return 'C';
        else if (c == 'T') return 'A';
        else return 'N';
    }

    // Reverzni komplement samo sa stringovima
    public static String revCompStr(String seq) {
        String revCompStr = "";

        for (int i=0; i<seq.length(); i++) {
            char c = seq.charAt(i);
            char complement = complementChar(c);
            revCompStr = complement + revCompStr;
        }
        return revCompStr;
    }

    // Reverzni komplement pomoću StringBuilder-a
    public static String revCompSB(String seq) {
        StringBuilder sBuilder = new StringBuilder();

        for (int i=seq.length()-1; i>=0; i--) {
            char c = seq.charAt(i);
            char complement = complementChar(c);
            sBuilder.append(complement);
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {

        if (args.length == 1) {
            System.out.println("Učitani niz: " + args[0]);
            System.out.println("Reverzno-komplementarni niz (String): " + Bioinfo.revCompStr(args[0]));
            System.out.println("Reverzno-komplementarni niz (Builder): " + Bioinfo.revCompSB(args[0]));
        }
        else {
            System.out.println("Neispravan broj argumenata: " + args.length);
        }
    }
}
