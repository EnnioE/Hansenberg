package info.datenstrukturen.AvlTree;

public class Node {
    int value, height, bf;
    Node parent = null;
    Node left = null;
    Node right = null;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value) {
        if (this.value == value) return this;
        if (this.value < value) return right.search(value);
        return left.search(value);
    }

    public void insert(Node node) {

        if (node.value < this.value) {
            if (left != null) {
                left.insert(node);
            } else {
                left = node;
            }
        } else {
            if (right != null) {
                right.insert(node);
            } else {
                right = node;
            }
        }

    }

    public void insert(int value) {
        this.insert(new Node(value));
    }

    public void delete() {
        if (blatt()) { // Knoten ist ein Blatt
            if (this.value < this.parent.value) {
                this.parent.left = null;
            } else {
                this.parent.right = null;
            }
        } else if (this.left != null && this.right == null) { // Knoten hat linkes Kind
            if (this.left.blatt()) {
                this.parent.left = this.left;
            } else {

            }
        }
    }

    public boolean blatt() {
        return this.left == null && this.right == null;
    }


/*
    public int getBf() {
        if (this.right != null && this.left != null) {
            this.height++;
        } else {

        }

    }
*/
    /*
    public boolean istBalanciert() {

    }

    public void balanciereBaum() {

    }


     */
}

