package Mixed;

import java.util.Scanner;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(findDuplicate(nums));
        sc.close();
    }
    public static int findDuplicate(int[] nums){
        int s = nums[0];
        int f = nums[nums[0]];
        while(s!=f){
            s = nums[s];
            f = nums[nums[f]];
        }
        s = nums[0];
        f = nums[f];
        while(s!=f){
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
}
