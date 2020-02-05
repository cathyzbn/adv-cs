import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] arr = (Item[]) new Object[1];
    private int size;
    
    public RandomizedQueue() { size = 0; }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    private void resize(int len) {
        Item[] copy = (Item[]) new Object[len];
        for (int i = 0; i < size; i++) copy[i] = arr[i];
        arr = copy;
    }
    
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        else {
            if (isEmpty()) arr[0] = item;
            else {
                int rand = StdRandom.uniform(size+1);
                if (rand == size) arr[size] = item;
                else {
                    Item temp = arr[rand];
                    arr[rand] = item;
                    arr[size] = temp;
                }
            }
            size++;
            if (size == arr.length) resize(2 * arr.length);
        }
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        else {
            size--;
            Item output = arr[size];
            if (size > 0 && size <= arr.length/4) resize(arr.length/2);
            arr[size] = null;
            return output;
        }
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int rand = StdRandom.uniform(size);
        return arr[rand];
    }

    public Iterator<Item> iterator() { return new ListIterator(); }
    
    private class ListIterator implements Iterator<Item>{
        
        private int current;
        private int[] randomArr;
        public ListIterator() {
            current = 0;
            randomArr = new int[size];
            for (int i = 0; i < size; i++) randomArr[i] = i;
            StdRandom.shuffle(randomArr);
        }
        public boolean hasNext() { return current < size; }
        public void remove() { throw new UnsupportedOperationException(); }
        
        @Override
        public Item next() {
            if(hasNext()) return arr[randomArr[current++]];
            else throw new NoSuchElementException();
        } 
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> d = new RandomizedQueue<Integer>();
        d.enqueue(1);
        d.enqueue(2);
//        d.enqueue(3);
//        d.enqueue(4);
//        d.enqueue(5);
//        d.enqueue(6);
        System.out.println(Arrays.toString(d.arr));
        System.out.println(d.dequeue());
        System.out.println(d.dequeue());
//        System.out.println(d.dequeue());
//        System.out.println(d.dequeue());
//        System.out.println(Arrays.toString(d.arr));
//        System.out.println(d.dequeue());
//        System.out.println(d.dequeue());
//        System.out.println(d.isEmpty());
//        
    }

}