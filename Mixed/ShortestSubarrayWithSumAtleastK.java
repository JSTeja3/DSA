package Mixed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ShortestSubarrayWithSumAtleastK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(shortestSubarray(nums, k));
        sc.close();
    }
    public static int shortestSubarray(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        long sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            prefix[i] = sum;
            if(sum >= k){
                minLength = Math.min(minLength, i+1);
            }
            while(!dq.isEmpty() && prefix[dq.peekLast()]>=prefix[i] ){
                dq.removeLast();
            }
            dq.addLast(i);
            while(!dq.isEmpty() && sum-prefix[dq.peekFirst()]>=k){
                minLength = Math.min(minLength, i-dq.peekFirst());
                dq.removeFirst();
            }
        } 
        return (minLength==Integer.MAX_VALUE)?-1:minLength;
    }
}
