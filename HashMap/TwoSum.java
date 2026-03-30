package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = twoSum(nums, target);
        for(int v: result){
            System.out.print(v+" ");
        } 
        sc.close();
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int value = target-nums[i];
            if(map.containsKey(value)){
                return new int[]{i, map.get(value)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
