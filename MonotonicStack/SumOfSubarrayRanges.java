package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(subArrayRanges(heights));
        sc.close();
    }
    public static long subArrayRanges(int[] nums) {
        long sum  = 0;
        int N = nums.length;
        int[] pSmall = new int[N];
        int[] pLarge = new int[N];
        int[] nSmall = new int[N];
        int[] nLarge = new int[N];
        Deque<Integer> pSmallDq = new ArrayDeque<>();
        Deque<Integer> pLargeDq = new ArrayDeque<>();
        Deque<Integer> nSmallDq = new ArrayDeque<>();
        Deque<Integer> nLargeDq = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            while(!pSmallDq.isEmpty() && nums[pSmallDq.peek()]>nums[i]){
                pSmallDq.pop();
            }
            pSmall[i] = (pSmallDq.isEmpty())?i+1:i-pSmallDq.peek();
            pSmallDq.push(i);
            while(!pLargeDq.isEmpty() && nums[pLargeDq.peek()]<nums[i]){
                pLargeDq.pop();
            }
            pLarge[i] = (pLargeDq.isEmpty())?i+1:i-pLargeDq.peek();
            pLargeDq.push(i);
        }
        for(int i=N-1; i>=0; i--){
            while(!nSmallDq.isEmpty() && nums[nSmallDq.peek()]>=nums[i]){
                nSmallDq.pop();
            }
            nSmall[i] = (nSmallDq.isEmpty())?N-i:nSmallDq.peek()-i;
            nSmallDq.push(i);
            while(!nLargeDq.isEmpty() && nums[nLargeDq.peek()]<=nums[i]){
                nLargeDq.pop();
            }
            nLarge[i] = (nLargeDq.isEmpty())?N-i:nLargeDq.peek()-i;
            nLargeDq.push(i);
        }
        for(int i=0; i<N; i++){
            sum += (long)nums[i]*(pLarge[i]*nLarge[i] - pSmall[i]*nSmall[i]);
        }

        return sum;
    }

}
