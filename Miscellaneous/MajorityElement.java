package Miscellaneous;

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
    public static int majorityElement(int[] nums){
        int answer = 0;
        int count = 0;
        for(int v : nums){
            if(count == 0){
                answer = v;
            }
            if(v == answer){
                count++;
            }
            else{
                count--;
            }
        }
        return answer;
    }
}
