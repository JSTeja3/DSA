package TwoPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarrayAtmostKDistinctInteger {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestKDistinct(nums, k));
        sc.close();
    }
    public static int longestKDistinct(int[] nums, int k){
        int maxLength = 0;
        //int[] count = new int[(int)1e5];
        Map<Integer, Integer> map = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            //count[nums[p2]]++;
            map.put(nums[p2], map.getOrDefault(nums[p2], 0)+1);
            // if(count[nums[p2]]==1){
            //     c++;
            // }
            while(map.size()>k){
                //count[nums[p1]]--;
                // if(count[nums[p1]]==0){
                //     c--;
                // }
                map.put(nums[p1], map.get(nums[p1])-1);
                if(map.get(nums[p1])==0){
                    map.remove(nums[p1]);
                }
                p1++;
            }
            maxLength = Integer.max(maxLength, p2-p1+1);
            p2++;
        }
        return maxLength;
    }
}
