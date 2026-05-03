import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                }
                if (set.size() == k) {
                    count++;
                }
                else if(set.size()>k){
                    break;
                }
            }
        }
        return count;
    }
}
