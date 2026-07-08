import java.util.Objects;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            tail = node;
            head = node;
            size++;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = tail.next;
        size++;

    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public T get(int index) {
        validateIndex(index);
        Node<T> m = head;
        for (int i = 0; i < index; i++) {
            m = m.next;
        }
        return m.data;
    }

    public void set(int index, T value) {
        validateIndex(index);

        Node<T> m = head;
        for (int i = 0; i < index; i++) {
            m = m.next;
        }
        m.data = value;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> node = new Node<T>(data);

        if (index == 0) {
            if(head!=null){
                node.next = head;
                head.prev = node;
                head = node;
            }
            else{
                head = node;
                tail = node;
            }
            size++;
            return;
        }

        Node<T> m = head;
        int i = 0;
        while (m != null) {
            if (i == index - 1) {
                node.next = m.next;
                node.prev = m;
                m.next = node;
                
                if (node.next == null) {
                    tail = node;
                }
                else{
                    node.next.prev = node;
                }
                size++;
                return;
            }
            m = m.next;
            i++;
        }
    }

    public void remove(int index) {
        validateIndex(index);
        Node<T> m = head;

        if (index == 0) {
            removeFirst();
            return;
        }
        if(index == size-1){
            removeLast();
            return;
        }

        int i = 0;
        while (m != null) {
            if (i == index - 1) {
                m.next = m.next.next;
                m.next.prev = m;
                size--;
                return;
            }
            m = m.next;
            i++;
        }
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public int indexOf(T data) {
        Node<T> m = head;
        int i = 0;
        while (m != null) {
            if (Objects.equals(data, m.data)) {
                return i;
            }
            m = m.next;
            i++;
        }
        return -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<T> m = head;
        while (m != null) {
            result.append(m.data);
            if (m.next != null) {
                result.append(",");
            }
            m = m.next;
        }
        result.append("]");
        return result.toString();
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }
}
