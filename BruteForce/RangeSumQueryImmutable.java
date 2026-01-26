import java.util.*;

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
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left; i<=right; i++){
            sum += this.nums[i];
        }
        return sum;
    }
}

