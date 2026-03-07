package MonotonicStack;

import java.util.*;

public class SubarraysWithMaximumLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(countSubArrays(nums, k));
        sc.close();
    }

    public static int countSubArrays(int[] nums, int k) {
        int count = 0;
        Deque<Integer> nGDQ = new ArrayDeque<>();
        Deque<Integer> pGDQ = new ArrayDeque<>();
        int[] nG = new int[nums.length];
        int[] pG = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!pGDQ.isEmpty() && nums[pGDQ.peek()] < nums[i]) {
                pGDQ.pop();
            }
            pG[i] = (pGDQ.isEmpty()) ? -1 : pGDQ.peek();
            pGDQ.push(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!nGDQ.isEmpty() && nums[nGDQ.peek()] <= nums[i]) {
                nGDQ.pop();
            }
            nG[i] = (nGDQ.isEmpty()) ? nums.length : nGDQ.peek();
            nGDQ.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count += (i - pG[i]) * (nG[i] - i);
            }
        }
        return count;
    }
}
