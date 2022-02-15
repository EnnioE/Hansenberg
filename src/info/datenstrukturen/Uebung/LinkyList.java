package info.datenstrukturen.Uebung;

public class LinkyList {
    Node first = null;
    Node last = null;

    public LinkyList(Node first) {
        this.first = first;
        this.last = first;
    }

    public LinkyList(int value) {
        this(new Node(value));
    }

    public void add(Node node) {
        this.last.next = node;
        this.last = node;
    }

    public void add(int value) {
        this.add(new Node(value));
    }

    public Node search(int value) {
        Node current = first;
        Node returnValue = null;
        while (true) {
            if (current == null) {
                System.out.println("Oh nein!");
                break;
            }
            if (current.value == value) {
                returnValue = current;
                break;
            }
            current = current.next;
        }
        return returnValue;
    }

    public void remove(Node node) {
        Node current = this.first;
        while (true) {
            if (node == first) {
                this.first = node.next;
            }
            if (current.next == node) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    public void remove(int value) {
        this.remove(this.search(value));
    }

    public String printValues() {
        Node current = first;
        String sum = "";
        while (current != null) {
            sum = sum + " | " + current.value;
            current = current.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkyList liste = new LinkyList(5);
        liste.add(8);
        liste.add(18);
        liste.add(12);
        System.out.println(liste.printValues());
        liste.remove(18);
        System.out.println(liste.printValues());
    }
}
