package TwoPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraysWithKDistinct(nums, k));
        sc.close();
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return countOfSub(nums, k)-countOfSub(nums, k-1);
    }
    public static int countOfSub(int[] nums, int k){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            map.put(nums[p2], map.getOrDefault(nums[p2], 0)+1);
            while(map.size()>k){
                map.put(nums[p1], map.get(nums[p1])-1);
                if(map.get(nums[p1])==0){
                    map.remove(nums[p1]);
                }
                p1++;
            }
            count+= p2-p1+1;
            p2++;
        }
        return count;
    }
}
