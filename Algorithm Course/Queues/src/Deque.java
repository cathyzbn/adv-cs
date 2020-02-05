import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    private int size;
    
    private class Node {
        private Item item; 
        private Node previous;
        private Node next;
        
        public Node(Item it, Node prev, Node nex) {
            item = it;
            previous = prev;
            next = nex;
        }
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }  

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node temp = first;
        first = new Node(item, null, temp);
        if (isEmpty()) last = first;
        else if (size == 1) {
            first.item = item;
            first.next = last;
            last.previous = first;
        } else temp.previous = first;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node temp = last;
        last = new Node(item, temp, null);
        if (isEmpty()) first = last;
        else if (size == 1) {
            last.item = item;
            last.previous = first;
            first.next = last;
        } else temp.next = last;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item output = first.item;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        return output;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item output = last.item;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
            
        } else {
            last = last.previous;
            last.next = null;
        }
        return output;
    }

    public Iterator<Item> iterator() { return new ListIterator();}
    
    private class ListIterator implements Iterator<Item>{
        
        private Node current = first;
        
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        
        @Override
        public Item next() {
            if (hasNext()) {
                Item output = current.item;
                current = current.next;
                return output;
            } else throw new NoSuchElementException();
        } 
    }

    public static void main(String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        d.addFirst(2);
        d.isEmpty();
        d.removeLast();
        d.addFirst(5);
        d.removeLast();
    }
}
