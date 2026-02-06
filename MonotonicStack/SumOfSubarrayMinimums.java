package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(sumSubarrayMins(heights));
        sc.close();
    }
    public static int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        int M = (int)1e9+7;
        int[] L = new int[N];
        int[] R = new int[N];
        Deque<Integer> lDeque = new ArrayDeque<>();
        Deque<Integer> rDeque = new ArrayDeque<>();
        long sum = 0;
        for(int i=0; i<N; i++){
            while(!lDeque.isEmpty() && arr[lDeque.peek()]>arr[i]){
                lDeque.pop();
            }
            L[i] = (lDeque.isEmpty())?(i+1):(i-lDeque.peek());
            lDeque.push(i);
        }
        for(int i=N-1; i>=0; i--){
            while(!rDeque.isEmpty() && arr[rDeque.peek()]>=arr[i]){
                rDeque.pop();
            }
            R[i] = (rDeque.isEmpty())?(N-i):(rDeque.peek()-i);
            rDeque.push(i);
        }
        for(int i=0; i<N; i++){
            sum = (sum + L[i]*R[i]*(long)arr[i])%M;
        }
        return (int)sum;

    }
}
