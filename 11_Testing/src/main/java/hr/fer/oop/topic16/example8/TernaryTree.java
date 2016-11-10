package hr.fer.oop.topic16.example8;

import hr.fer.oop.topic16.example7.Container;

public class TernaryTree<T> implements Container<T> {

    private TernaryTree left;
    private TernaryTree middle;
    private TernaryTree right;
    private T content;

    public TernaryTree() {
    }

    public TernaryTree(T content) {
        this.content = content;
    }

    @Override
    public Container add(T item) {
        if (this.content == null) {
            // prvi
            this.content = item;
            return this;
        } else if (item.hashCode() < this.content.hashCode()) {
            //treba ga stavit lijevo ili u sredinu
            this.addLC(item);
        } else {
            //treba ga staviti desno ili u sredinu
            this.addRC(item);
        }
        return this;
    }

    @Override
    public boolean contains(T item) {
        if (this.content == null) {
            // prazno stablo
            return false;
        } else if (item.equals(this.content)) {
            // nađen je
            return true;
        } else if (item.hashCode() < this.content.hashCode()) {
            //treba ga tražit lijevo ili u sredini
            return this.findLC(item);
        } else {
            //treba ga tražit desno ili u sredini
            return this.findRC(item);
        }
    }

    private void addLC(T item) {
        if (this.left == null) {
            //stavi ga lijevo
            this.left = new TernaryTree(item);
        } else if (this.goesLeft(item)) {
            //dodaj ga niže lijevo
            this.left.add(item);
        } else if (this.middle == null) {
            //stavi ga u sredinu
            this.middle = new TernaryTree(item);
        } else {
            //dodaj ga niže u sredinu
            this.middle.add(item);
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

    private void addRC(T item) {
        if (this.right == null) {
            //stavi ga desno
            this.right = new TernaryTree(item);
        } else if (this.goesRight(item)) {
            //dodaj ga niže desno
            this.right.add(item);
        } else if (this.middle == null) {
            //stavi ga u sredinu
            this.middle = new TernaryTree(item);
        } else {
            //dodaj ga niže u sredinu
            this.middle.add(item);
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

    private boolean goesLeft(T item) {
        return item.hashCode() <= this.left.content.hashCode() + (this.content.hashCode() - this.left.content.hashCode()) / 2;
    }

    private boolean goesRight(T item) {
        return item.hashCode() >= this.content.hashCode() + (this.right.content.hashCode() - this.content.hashCode()) / 2;
    }
}
