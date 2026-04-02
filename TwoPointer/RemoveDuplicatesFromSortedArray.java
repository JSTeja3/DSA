package TwoPointer;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(removeDuplicates(nums));
        sc.close();
    }
    public static int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            if(nums[p1] != nums[p2]){
                nums[++p1] = nums[p2];
            }
            p2++;
        }
        return p1+1;
    }
}
