package HashMapOrHashSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(longestConsecutive(nums));
        sc.close();
    }
    public static int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for(int val: nums){
            set.add(val);
        }
        for(int val: set){
            int x = val;
            if(!set.contains(x-1)){
                int c = 1;
                while(set.contains(x+1)){
                    c++;
                    x += 1;
                }
                maxLen = Math.max(maxLen, c);
            }
        }
        return maxLen;
    }
}
