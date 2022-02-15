package info.datenstrukturen.LinkedList;

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

    public Node search(int value, boolean front) throws NullPointerException {
        Node current = (front) ? first : last;
        Node returnValue = null;
        while (true) {
            if (current == null) {
                throw new NullPointerException("Kein Knoten hat diesen Wert!");
            }
            if (current.value == value) {
                returnValue = current;
                break;
            }
            current = (front) ? current.next : current.prev;
        }
        return returnValue;
    }

    public void add(Node node, boolean front) {
        if (front) {
            this.last.next = node;
            this.last.next.prev = this.last;
            this.last = this.last.next;
        } else {
            this.first.prev = node;
            this.first.prev.next = this.first;
            this.first = this.first.prev;
        }
    }

    public void add(int value, boolean front) {
        this.add(new Node(value), front);
    }

    public void remove(Node node) {
        if (node.prev == null) {
            if (node.next == null) {
                System.out.println("Die Liste besteht nur noch aus diesem Element!");
            } else {
                node.next.prev = null;
                this.first = this.first.next;
                node.next = null;
            }
        } else if (node.next == null) {
            node.prev.next = null;
            this.last = this.last.prev;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void remove(int value, boolean front) {
        this.remove(this.search(value, front));
    }

    public int getNextValue(Node node) throws NullPointerException {
        if (node.next == null) {
            throw new NullPointerException("Es gibt keinen nächsten Knoten!");
        } else {
            return node.next.value;
        }
    }

    public int getPrevValue(Node node) throws NullPointerException {
        if (node.prev == null) {
            throw new NullPointerException("Es gibt keinen vorherigen Knoten!");
        } else {
            return node.prev.value;
        }
    }

    public String printValues(boolean front) {
        Node current = (front) ? first : last;
        String sum = "";
        while (current != null) {
            sum = sum + " | " + current.value;
            current = (front) ? current.next : current.prev;
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkyList linky = new LinkyList(10);
        linky.add(20, true);
        linky.add(7, true);
        linky.add(31, true);
        System.out.println(linky.getNextValue(linky.first.next.next));
        linky.add(18, false);
        System.out.println(linky.printValues(true));
        System.out.println(linky.getPrevValue(linky.first.next.next));
        linky.remove(10, false);
        linky.remove(31, true);
        System.out.println(linky.printValues(true));
        linky.remove(20, false);
        System.out.println(linky.printValues(true));
    }
}



