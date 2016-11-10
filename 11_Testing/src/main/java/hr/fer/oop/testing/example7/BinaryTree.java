package hr.fer.oop.testing.example7;

public class BinaryTree<T> implements Container<T> {

    private BinaryTree left;
    private BinaryTree right;
    private T content;

    public BinaryTree() {
    }

    public BinaryTree(T item) {
        this.content = item;
    }

    @Override
    public Container add(T item) {
        if (this.content == null) {
            // prvi
            this.content = item;
            return this;
        } else if (item.hashCode() < this.content.hashCode()) {
            // treba ga stavit lijevo
            this.addLeft(item);
        } else {
            // treba ga stavit desno
            this.addRight(item);
        }
        return this;
    }

    private void addLeft(T item) {
        if (this.left != null) {
            this.left.add(item);
        } else {
            this.left = new BinaryTree(item);
        }
    }

    private void addRight(T item) {
        if (this.right != null) {
            this.right.add(item);
        } else {
            this.right = new BinaryTree(item);
        }
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
            // nastavi tražit lijevo
            return this.findLeft(item);
        } else {
            // nastavi tražit desno
            return this.findRight(item);
        }
    }

    private boolean findLeft(T item) {
        if (this.left != null) {
            return this.left.contains(item);
        } else {
            return false;
        }
    }

    private boolean findRight(T item) {
        if (this.right != null) {
            return this.right.contains(item);
        } else {
            return false;
        }
    }
}