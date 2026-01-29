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
        for(int i=0; i<nums.length; i++){
            int c = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2 != 0){
                    c++;
                }
                if(c==k){
                    countSub++;
                }
            }
        }
        return countSub;
    }

}
