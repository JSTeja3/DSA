package Mixed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int limit = sc.nextInt();
        System.out.println(longestSubarray(nums, limit));
        sc.close();
    }
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDQ = new ArrayDeque<>();
        Deque<Integer> maxDQ = new ArrayDeque<>();
        int p1 = 0;
        int p2 = 0;
        int maxLength = 0;
        while(p2<nums.length){
            while(!minDQ.isEmpty() && nums[minDQ.peekLast()] >= nums[p2]){
                minDQ.removeLast();
            }
            minDQ.addLast(p2);
            while(!maxDQ.isEmpty() && nums[maxDQ.peekLast()] <= nums[p2]){
                maxDQ.removeLast();
            }
            maxDQ.addLast(p2);
            while(nums[maxDQ.peekFirst()]-nums[minDQ.peekFirst()]>limit){
                if(!minDQ.isEmpty() && p1==minDQ.peekFirst()){
                    minDQ.removeFirst();
                }
                if(!maxDQ.isEmpty() && p1==maxDQ.peekFirst()){
                    maxDQ.removeFirst();
                }
                p1++;
            }
            maxLength = Integer.max(maxLength, p2-p1+1);
            p2++;
        }
        return maxLength;
    }
}
