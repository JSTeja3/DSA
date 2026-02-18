package MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] ans = maxSlidingWindow(nums, k);
        for(int val : ans){
            System.out.print(val+" ");
        }
        sc.close();
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] ans = new int[N-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            if(!dq.isEmpty() && (dq.peekFirst() <= i-k)){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
