package project05SocialMedia;

import java.util.NoSuchElementException;

/**
 * this class is the linked list class.
 * It uses nodes to store data.
 * 
 * @author George Liu
 * @version 19 April 2023
 *
 */
public class SingularlyLinkedList<T> implements LList<T> {

    /**
     * This is the node class
     * this holds the data
     * 
     * @author George Liu (GeorgeLiu)
     * @version 19 April 2023
     */
    public static class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * creates new node with data
         * 
         * @param dat
         *            data to be used
         */
        public Node(T dat) {
            data = dat;
            next = null;
        }


        /**
         * creates new node with data and next node
         * 
         * @param dat
         *            the data
         * @param nexter
         *            the next node
         */
        public Node(T dat, Node<T> nexter) {
            data = dat;
            next = nexter;
        }


        /**
         * sets next node
         * 
         * @param next
         *            the next node
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }


        /**
         * returns the next node
         * 
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }


        /**
         * gets the data
         * 
         * @return the data
         */
        public T getData() {
            return data;
        }
    }

    private int size;
    private Node<T> head;

    /**
     * Constructor
     */
    public SingularlyLinkedList() {
        head = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }


    @Override
    public boolean add(T thing) {
        if (thing == null) {
            return false;
        }
        else if (isEmpty()) {
            head = new Node<T>(thing);
        }
        else {
            head = new Node<T>(thing, head);
        }
        size++;
        return true;
    }


    @Override
    public void add(int index, T thing) {
        if (index > size || thing == null) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            Node<T> newNext = new Node<T>(thing);
            newNext.setNext(head);
            head = newNext;
        }
        else {
            Node<T> prev = getNodeAt(index);
            Node<T> newNext = new Node<T>(thing);
            newNext.setNext(prev);
            prev.setNext(newNext);
        }
        size++;
    }


    /**
     * this is a helper node that retrives a node at an index
     * 
     * @param index
     *            where the index is
     * @return
     *         the node
     */
    private Node<T> getNodeAt(int index) {
        Node<T> holder = head;
        for (int i = 0; i < index - 1; i++) {
            holder = holder.next();
        }
        return holder;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void remove(T thing) {
        if (thing == null) {
            throw new IndexOutOfBoundsException();
        }
        else {
            int index = lastIndexOf(thing);
            remove(index + 1);
        }
    }


    @Override
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            head = head.next();
        }
        else {
            Node<T> prev = getNodeAt(index);
            prev.setNext(prev.next().next());
        }
        size--;
    }


    @Override
    public T get(int index) {
        return getNodeAt(index).getData();
    }


    @Override
    public void clear() {
        head = null;
        size = 0;

    }


    @Override
    public int getLastIndexOf(T thing) {
        Node<T> temp = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (temp.getData().equals(thing)) {
                index = i;
            }
            temp = temp.next();
        }
        if (index >= 0) {
            return index;
        }
        else {
            throw new NoSuchElementException(); // Item not found
        }
    }


    /**
     * returns the linked list as a string
     * 
     * @return the string version of the linked list
     *         Formated as [Item1, Item2, Item3..., ItemX] or [] for an empty
     *         list
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String returner = "[";
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            returner = returner + temp.getData() + ", ";
            temp = temp.next();
        }
        return returner.substring(0, returner.length() - 2) + "]";
    }
}
