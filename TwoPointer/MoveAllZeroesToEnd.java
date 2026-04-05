package TwoPointer;

import java.util.*;

public class MoveAllZeroesToEnd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(moveZeroes(N, nums));
        sc.close();
    }
    public static String returnMovedArray(int N, int[] nums){
        StringBuilder result = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(p2<nums.length){
            if(nums[p2] == 0 && nums[p1] != 0){
                p1 = p2;
            }
            else if(nums[p2] != 0 && nums[p1] == 0 ){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p1++;
            }
            p2++;
        }
        for(int i=0; i<N; i++){
            result.append(nums[i]).append(" ");
        }
        return result.toString();

    }
    //more optimized and clean
    public static String moveZeroes(int N, int[] nums) {
        StringBuilder result = new StringBuilder();
        int s = 0;
        for(int f=0; f<nums.length; f++){
            if(nums[f] != 0){
                int t = nums[s];
                nums[s] = nums[f];
                nums[f] = t;
                s++;
            }
        }
        for(int i=0; i<N; i++){
            result.append(nums[i]).append(" ");
        }
        return result.toString();
    }
}
