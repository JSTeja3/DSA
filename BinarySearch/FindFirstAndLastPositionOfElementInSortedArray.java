package BinarySearch;

import java.util.Scanner;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = searchRange(nums, target);
        for(int v: result){
            System.out.print(v+" ");
        }
        sc.close();
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = findFirst(nums, target);
        if(result[0] == -1){
            return result;
        }
        result[1] = findLast(nums, target);
        return result;
    }
    public static int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int first = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                first = mid;
                right = mid-1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return first;
    }
    public static int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int last = -1;
        while(left<=right){
            int mid  = left + (right-left)/2;
            if(nums[mid]==target){
                last = mid;
                left = mid+1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return last;
    }
}
