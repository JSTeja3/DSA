import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(majorityElement(nums));
        sc.close();
    }
    public static int majorityElement(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
        int count = 0;

        for(int j = 0; j < nums.length; j++) {
            if(nums[i] == nums[j]) 
                count++;
        }

        if(count > nums.length / 2) 
            return nums[i];
    }

    return -1;
}
}
