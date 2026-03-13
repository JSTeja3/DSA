package MonotonicStack;
import java.util.*;

public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(numSubarrayBoundedMax(nums, left, right));
        sc.close();
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        Deque<Integer> pDQ = new ArrayDeque<>();
        Deque<Integer> nDQ = new ArrayDeque<>();
        int[] p = new int[nums.length];
        int[] n = new int[nums.length];
        int count = 0;
        for(int i=0; i<nums.length; i++){
            while(!pDQ.isEmpty() && nums[pDQ.peek()]<=nums[i]){
                pDQ.pop();
            }
            p[i] = pDQ.isEmpty()?i+1:i-pDQ.peek();
            pDQ.push(i);
        }
        for(int i=nums.length-1; i>=0; i--){
            while(!nDQ.isEmpty() && nums[nDQ.peek()]<nums[i]){
                nDQ.pop();
            }
            n[i] = nDQ.isEmpty()?nums.length-i:nDQ.peek()-i;
            nDQ.push(i);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=left && nums[i]<=right){
                count += p[i]*n[i];
            }
        }
        return count;
    }
}


