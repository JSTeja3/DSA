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
        int N = nums.length;
        int maxLength = 0;
        for(int i=0; i<N; i++){
            int[] count  = new int[2];
            for(int j=i; j<N; j++){
                count[nums[j]]++;
                if(count[0]==count[1]){
                    maxLength = Integer.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}
