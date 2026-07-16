import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> {
    private List<T> list;
    private int size;

    public MyStack() {
        list = new ArrayList<T>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T value) {
        list.add(value);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        size--;
        return list.remove(size);

    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return list.get(size - 1);
    }

    public void clear() {
        list = new ArrayList<>();
        size = 0;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");

        for (int i = 0; i < size; i++) {
            res.append(list.get(i));
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
