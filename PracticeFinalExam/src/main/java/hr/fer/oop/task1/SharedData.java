package hr.fer.oop.task1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedData {

    private boolean gameOver = false;
    // TODO

    public SharedData(int noOfEmployees) {
        // TODO
    }

    // TODO
    //metoda nextId vraća sljedeći redni broj natjecatelja
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    // TODO
}
