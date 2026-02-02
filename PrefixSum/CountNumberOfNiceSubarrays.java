package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(numberOfSubarrays(nums, k));
        sc.close();
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int countSub = 0;
        int c = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                c++;
            }
            if (map.containsKey(c - k)) {
                countSub += map.get(c - k);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return countSub;
    }

}
