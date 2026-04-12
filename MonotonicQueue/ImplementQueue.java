package MonotonicQueue;

import java.util.*;


//Very Basic Implementation
public class ImplementQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // No. of Instructions
        String[] instructions = new String[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            instructions[i] = sc.next();
            values[i] = sc.nextInt();
            System.out.println(values[i]);
        }
        MyQueueLL queue = new MyQueueLL();
        for (int i = 0; i < N; i++) {
            if (instructions[i].equals("MyQueue")) {
                queue = new MyQueueLL();
                System.out.print("null ");
            } else if (instructions[i].equals("enqueue")) {
                queue.enqueue(values[i]);
                System.out.print("null ");
            } else if (instructions[i].equals("dequeue")) {
                System.out.print(queue.dequeue() + " ");
            } else if (instructions[i].equals("peek")) {
                System.out.print(queue.peek() + " ");
            } else if (instructions[i].equals("isEmpty")) {
                System.out.print(queue.isEmpty() + " ");
            }
        }
        sc.close();
    }

    //using LinkedList
    public static class MyQueueLL {

        private Node head;
        private Node tail;

        public MyQueueLL() {
            head = null;
            tail = head;
        }

        public void enqueue(int val) {
            if (head == null) {
                head = new Node(val);
                tail = head;
            } else {
                tail.next = new Node(val);
                tail = tail.next;
            }

        }

        public int dequeue() {
            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek() {
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    //using Array
    public static class MyQueue {
        private int[] array;
        private int first;
        private int last;

        public MyQueue() {
            array = new int[1000];
            first = 0;
            last = 0;
        }

        public void enqueue(int val) {
            array[last++] = val;
        }

        public int dequeue() {
            return array[first++];
        }

        public int peek() {
            return array[first];
        }

        public boolean isEmpty() {
            return first == last;
        }
    }
}
