package BinarySearch;

import java.util.Scanner;

public class SearchInsertPosition {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(searchInsert(nums, target));
        sc.close();
    }
    public static int searchInsert(int[] nums, int target) {
        int result = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                result = mid;
                break;
            }
            else if(nums[mid] < target){
                result = mid+1;
                low = mid+1;
            }
            else{
                result = mid;
                high = mid-1;
            }
        }
        return result;
    }
}
