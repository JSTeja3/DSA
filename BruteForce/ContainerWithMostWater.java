import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxArea(nums));
        sc.close();
    }
    public static int maxArea(int[] height) {
    int maxArea = 0;
    for(int i=0; i<height.length; i++){
        for(int j=i+1; j<height.length; j++){
            int area = Math.min(height[i], height[j]) * (j-i);
            maxArea = Math.max(maxArea, area);
        }
    }
    return maxArea;
}
}
