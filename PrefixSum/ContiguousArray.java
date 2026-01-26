package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContiguousArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(findMaxLength(nums));
        sc.close();
    }
    public static int findMaxLength(int[] nums) {
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        map.put(1, -1);
        /* If equal 0's and 1's then sum of subarray == (length of subarray)/2 
                                -->   currSum[j]-currSum[i] == (j-i)/2 
                                -->   modify this as per prefix sum */
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            int temp = 2*currSum-i;
            if(map.containsKey(temp)){
                int x = map.get(temp);
                maxLength = Integer.max(maxLength, i-x);
            }
            else{
                map.put(temp, i);
            }
        }
        return maxLength;
    }
}
