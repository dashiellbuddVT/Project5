package prj5;

import java.util.Comparator;
import java.util.NoSuchElementException;

import java.util.Iterator;

/**
 * this class is the linked list class.
 * It uses nodes to store data.
 * 
 * @author George Liu
 * @version 19 April 2023
 * @param <T> the generic
 */
public class SingularlyLinkedList<T> implements LList<T>, Iterable<T> {

    /**
     * This is the node class
     * this holds the data
     * 
     * @author George Liu (GeorgeLiu)
     * @version 19 April 2023
     * @param <T>
     *            data class
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
            Node<T> prev = getNodeAt(index-1);
            Node<T> newNext = new Node<T>(thing,prev.next());
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
        for (int i = 0; i < index; i++) {
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
            int index = getLastIndexOf(thing);
            remove(index);
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
            if (prev.next() != null) {
                prev.setNext(prev.next().next());
            }
            else {

            }

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
        for(int i = 0; i < size; i ++) {
            returner = returner + temp.getData() + ", ";
            temp = temp.next();
        }
        if (returner.length() > 2) {
            returner = returner.substring(0, returner.length() - 2);
        }
        return  returner + "]";
    }


    /**
     * Sorter class, insertion sort
     * 
     * @param judgement
     *            thou shalt be judgement
     */
    public void sort(Comparator<T> judgement) {
        Node<T> ref = head;
        Node<T> sorted = null;
        if (ref == null) {
            return;
        }
        while (ref != null) {
            Node<T> temp = ref.next();
            if (sorted == null || judgement.compare(ref.getData(),
                sorted.getData()) < 0) {
                ref.setNext(sorted);
                sorted = ref;
            }
            else {
                Node<T> prev = sorted;
                while (prev.next != null && judgement.compare(ref.getData(), prev
                    .next().getData()) > 0) {
                    prev = prev.next();
                }
                ref.setNext(prev.next());
                prev.setNext(ref);
            }
            ref = temp;
        }
        head = sorted;
    }
    
    /**
     * 
     * @param <T>
     * @param list
     * @param comp
     */
    public static <T> void sort(
        SingularlyLinkedList<T> list,
        Comparator<? super T> comp) {

        Iterator<T> iter = list.iterator();
        SingularlyLinkedList<T> sortedList = new SingularlyLinkedList<T>();
        while (iter.hasNext()) {
            T curElement = iter.next();
            int index = 0;

            while (index < sortedList.size && comp.compare(curElement,
                sortedList.get(index)) >= 0) {

                index++;
            }

            sortedList.add(index, curElement);
        }
        list.head = sortedList.head;
    }
    
    /**
     * Sorter class, insertion sort, made specially just for judging months
     * 
     * @param judgement
     *            thou shalt be judgement
     * @param month
     *      the month to be judged           
     */
    public void sort(Comparator<Month> judgement, int month) {
        if (!head.getData().getClass().equals(Account.class)) {
            return;
        }
        Node<Account> ref = (Node<Account>)head;
        Node<Account> sorted = null;
        if (ref == null) {
            return;
        }
        while (ref != null) {
            Node<Account> temp = ref.next();
            if (sorted == null || judgement.compare(ref.getData().getMonth(month),
                sorted.getData().getMonth(month)) < 0) {
                ref.setNext(sorted);
                sorted = ref;
            }
            else {
                Node<Account> prev = sorted;
                while (prev.next != null && judgement.compare(ref.getData().getMonth(month), prev
                    .next().getData().getMonth(month)) > 0) {
                    prev = prev.next();
                }
                ref.setNext((Node<Account>)prev.next());
                prev.setNext(ref);
            }
            ref = temp;
        }
        head = (Node<T>)sorted;
    }
    
    
    public Iterator<T> iterator()
    {
        return new LListIterator<T>();
    }
    
    private class LListIterator<A> implements Iterator<T>
    {
        private Node<T> prev;
        private Node<T> curr;
        private Node<T> next;
        private boolean newCurr;

        /**
        * Creates a new DLListIterator
        */
        public LListIterator()
        {
            prev = null;
            curr = null;
            next = head;
            newCurr = false;
        }

        /**
        * Checks if there are more elements in the list
        *
        * @return true if there are more elements in the list
        */
        @Override
        public boolean hasNext()
        {
            return (next != null);
        }

        /**
        * Gets the next value in the list
        *
        * @return the next value
        * @throws NoSuchElementException
        *             if there are no nodes left in the list
        */
        @Override
        public T next()
        {
            prev = curr;
            curr = next;
            next = next.next();
            if (curr == null)
            {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            newCurr = true;
            return curr.getData();
        }

       /**
        * Removes the last object returned with next() from the list
        *
        * @throws IllegalStateException
        *             if next has not been called yet
        *             and if the element has already been removed
        */
        @Override
        public void remove()
        {
            if (next == head)
            {
                throw new IllegalStateException(
                     "Next has not been called yet.");
            }
            else if (!newCurr)
            {
                throw new IllegalStateException(
                     "The Element has already been removed.");
            }
            else if (curr == head) {
                head = next;
                curr = null;
            } else {
                prev.setNext(curr.next());
                curr = prev;
                 //this code that updates prev is not necessary
                 //because next() must be called before another remove()
                 //and that will update prev, saving this O(n) operation
                 //prev = firstNode;
                 //while ((prev != null) && (prev.getNext() != curr)){
                 //    prev = prev.getNext();
                 //}
            }
            size--;
            newCurr = false;
        }
    }

}
