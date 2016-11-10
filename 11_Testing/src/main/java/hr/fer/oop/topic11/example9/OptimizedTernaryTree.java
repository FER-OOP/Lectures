package hr.fer.oop.topic11.example9;

import hr.fer.oop.topic11.example7.Container;

public class OptimizedTernaryTree<T> implements Container<T> {

    private OptimizedTernaryTree left;
    private OptimizedTernaryTree middle;
    private OptimizedTernaryTree right;
    private T content;
    
    private int leftHashcode;
    private int rightHashcode;
    private int hashcode;

    public OptimizedTernaryTree() {
    }

    public OptimizedTernaryTree(T content) {
        this.content = content;
        this.hashcode = content.hashCode();
    }

    @Override
    public Container add(T item) {
        if (this.content == null) {
            // prvi
            this.content = item;
            this.hashcode = item.hashCode();
            return this;
        } else if (item.hashCode() < this.hashcode) {
            //treba ga stavit lijevo ili u sredinu
            this.addLC(item);
        } else {
            //treba ga staviti desno ili u sredinu
            this.addRC(item);
        }
        return this;
    }

    private void addLC(T item) {
        if (this.left == null) {
            //stavi ga lijevo
            this.left = new OptimizedTernaryTree(item);
            this.leftHashcode = item.hashCode();
        } else if (this.goesLeft(item)) {
            //dodaj ga niže lijevo
            this.left.add(item);
        } else if (this.middle == null) {
            //stavi ga u sredinu
            this.middle = new OptimizedTernaryTree(item);
        } else {
            //dodaj ga niže u sredinu
            this.middle.add(item);
        }
    }

    private boolean goesLeft(T item) {
        return item.hashCode() <= this.leftHashcode + (this.hashcode - this.leftHashcode)/2;
    }

    private void addRC(T item) {
        if (this.right == null) {
            //stavi ga desno
            this.right = new OptimizedTernaryTree(item);
            this.rightHashcode = item.hashCode();
        } else if (this.goesRight(item)) {
            //dodaj ga niže desno
            this.right.add(item);
        } else if (this.middle == null) {
            //stavi ga u sredinu
            this.middle = new OptimizedTernaryTree(item);
        } else {
            //dodaj ga niže u sredinu
            this.middle.add(item);
        }
    }

    private boolean goesRight(T item) {
        return item.hashCode() >= this.hashcode + (this.rightHashcode - this.hashcode)/2;
    }

    @Override
    public boolean contains(T item) {
        if (this.content == null) {
            // prazno stablo
            return false;
        } else if (item.equals(this.content)) {
            // nađen je
            return true;
        } else if (item.hashCode() < this.hashcode) {
            //treba ga tražit lijevo ili u sredini
            return this.findLC(item);
        } else {
            //treba ga tražit desno ili u sredini
            return this.findRC(item);
        }
    }

    private boolean findLC(T item) {
        if (this.left == null) {
            //nema ga lijevo
            return false;
        } else if (this.goesLeft(item)) {
            //traži ga niže lijevo
            return this.left.contains(item);
        } else if (this.middle == null) {
            //nema ga u sredini
            return false;
        } else {
            //traži ga niže u sredini
            return this.middle.contains(item);
        }
    }

    private boolean findRC(T item) {
        if (this.right == null) {
            //nema ga desno
            return false;
        } else if (this.goesRight(item)) {
            //traži ga niže desno
            return this.right.contains(item);
        } else if (this.middle == null) {
            //nema ga u sredini
            return false;
        } else {
            //traži ga niže u sredini
            return this.middle.contains(item);
        }
    }
}
