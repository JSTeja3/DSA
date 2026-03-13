package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumWidthRamp {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxWidthRamp(nums));
        sc.close();
    }
    public static int maxWidthRamp(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        int ramp = 0;
        for(int i=0; i<nums.length; i++){
            if(dq.isEmpty() || nums[dq.peek()]>nums[i]){
                dq.push(i);
            }
        }
        for(int i=nums.length-1; i>=0; i--){
            while(!dq.isEmpty() && nums[i]>=nums[dq.peek()]){
                ramp = Math.max(ramp, i-dq.peek());
                dq.pop();
            }
        }
        return ramp;
    }
}
