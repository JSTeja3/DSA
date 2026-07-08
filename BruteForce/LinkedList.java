import java.util.Objects;

public class LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
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
        }
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data) {
        if (head == null) {
            head = new Node<T>(data);
            tail = head;
            size++;
            return;
        }

        tail.next = new Node<T>(data);
        tail = tail.next;
        size++;

    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
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
        Node<T> t = head;
        Node<T> m = head.next;
        while (m.next != null) {
            m = m.next;
            t = t.next;
        }
        t.next = null;
        tail = t;
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
            node.next = head;
            head = node;
            size++;
            return;
        }

        Node<T> m = head;
        int i = 0;
        while (m != null) {
            if (i == index - 1) {
                node.next = m.next;
                m.next = node;
                if (node.next == null) {
                    tail = node;
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
            head = head.next;

            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        int i = 0;
        while (m != null) {
            if (i == index - 1) {
                if (m.next.next == null) {
                    tail = m;
                }
                m.next = m.next.next;
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
