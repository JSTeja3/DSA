package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SumOfSubarrayMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(sumOfMax(heights));
        sc.close();
    }
    public static int sumOfMax(int[] arr) {
        // code here
        long sum = 0;
        int N = arr.length;
        Deque<Integer> lDq = new ArrayDeque<>();
        Deque<Integer> rDq = new ArrayDeque<>();
        int[] left = new int[N];
        int[] right = new int[N];
        //left greater distance
        for(int i=0; i<N; i++){
            while(!lDq.isEmpty() && arr[lDq.peek()]<arr[i]){
                lDq.pop();
            }
            left[i] = (lDq.isEmpty())?i+1:i-lDq.peek();
            lDq.push(i);
        }
        //right greater distance
        for(int i=N-1; i>=0; i--){
            while(!rDq.isEmpty() && arr[rDq.peek()]<=arr[i]){
                rDq.pop();
            }
            right[i] = (rDq.isEmpty())?N-i:rDq.peek()-i;
            rDq.push(i);
        }
        //sum find
        for(int i=0; i<N; i++){
            sum += (left[i]*right[i]*(long)arr[i]);
        }
        return (int)sum;
    }
}
