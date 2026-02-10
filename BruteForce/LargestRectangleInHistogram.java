import java.util.Scanner;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(largestRectangleArea(heights));
        sc.close();
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = -1;
            int right = heights.length;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    left = j;
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    right = j;
                    break;
                }
            }
            int area = (right - left - 1) * heights[i];
            maxArea = Integer.max(maxArea, area);
        }
        return maxArea;
    }
}
