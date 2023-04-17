package prj5;

public class LinkedList<T> 
{
    private Node<T> firstNode;
    private int size;
    
    public LinkedList()
    {
        firstNode = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return size <= 0;
    }
    
    public int size()
    {
        return size;
    }
    
    private class Node<D>
    {
        private D data;
        private Node<D> next;
        
        public Node()
        {
            data = null;
            next = null;
        }
        
        public Node<D> getNext()
        {
            return next;
        }
        
        public D getData()
        {
            return data;
        }
    }
}
