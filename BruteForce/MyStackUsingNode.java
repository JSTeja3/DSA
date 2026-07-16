import java.util.EmptyStackException;

public class MyStackUsingNode<T> {
    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    private Node<T> head;
    private int size;

    public MyStackUsingNode(){
        this.head = null;
        this.size = 0; 
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void push(T value){
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node; 
        size++;
    }

    public T pop(){
        if(head==null){
            throw new EmptyStackException();
        }
        T val = head.data;
        head = head.next;
        size--;

        return val;        
    }

    public T peek(){
        if(head==null){
            throw new EmptyStackException();
        }
        return head.data;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");

        Node<T> m = head;
        while(m!=null){
            res.append(m.data);
            if(m.next!=null){
                res.append(",");
            }
            m = m.next;
        }
        res.append("]");

        return res.toString();
    }
}
