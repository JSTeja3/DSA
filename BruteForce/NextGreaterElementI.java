import java.util.Scanner;

public class NextGreaterElementI {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums1 = new int[N];
        for(int i=0; i<N; i++){
            nums1[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] nums2 = new int[M];
        for(int i=0; i<M; i++){
            nums2[i] = sc.nextInt();
        }
        int[] ans = nextGreaterElement(nums1, nums2);
        for(int v: ans){
            System.out.print(v+" ");
        }
        sc.close();
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans  = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = -1;
            boolean found = false;
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    found = true;
                }
                if(found && nums2[j]>nums1[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

}
