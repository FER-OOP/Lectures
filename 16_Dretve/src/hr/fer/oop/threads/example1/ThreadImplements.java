package hr.fer.oop.threads.example1;

public class ThreadImplements implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("broj " + i);
        }
        System.out.println("Gotovo brojenje");
    }

    public static void main(String[] args) {
        ThreadImplements t1;
        //ThreadImplements t2;
        t1 = new ThreadImplements();
        new Thread(t1).start();
        //t2 = new ThreadImplements();
        //new Thread(t2).start();
    }
}
