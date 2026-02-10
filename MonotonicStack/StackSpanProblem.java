package MonotonicStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class StackSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = calculateSpan(arr);
        for (int value: ans) {
            System.out.print(value + " ");
        }
        sc.close();
    }
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++){
            while(!dq.isEmpty() && arr[dq.peek()]<=arr[i]){
                dq.pop();
            }
            result.add((dq.isEmpty())?i+1:i-dq.peek());
            dq.push(i);
        }
        return result;
    }
}
