package PrefixSum;

import java.util.Scanner;

public class RangeSumQueryImmutable {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        NumArray nArray = new NumArray(arr);
        int Q = sc.nextInt();
        for(int i=0; i<Q; i++){
            int result = nArray.sumRange(sc.nextInt(), sc.nextInt());
            System.out.println(result);
        }
        sc.close();

    }
}
class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                prefix[i] = nums[i];
                continue;
            }
            prefix[i] = prefix[i-1] + nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefix[right];
        }
        int sum = prefix[right]-prefix[left-1];
        return sum;
    }
}

