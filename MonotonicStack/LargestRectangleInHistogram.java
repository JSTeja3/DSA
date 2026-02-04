package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
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
        Deque<Integer> leftDQ = new ArrayDeque<>();
        Deque<Integer> rightDQ = new ArrayDeque<>();
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            while(!leftDQ.isEmpty() && heights[leftDQ.peek()]>=heights[i]){
                leftDQ.pop();
            }
            leftSmall[i] = (leftDQ.isEmpty())?-1:leftDQ.peek();
            leftDQ.push(i);
        }
        for(int i=heights.length-1; i>=0; i--){
            while(!rightDQ.isEmpty() && heights[rightDQ.peek()]>=heights[i]){
                rightDQ.pop();
            }
            rightSmall[i] = (rightDQ.isEmpty())?heights.length:rightDQ.peek();
            rightDQ.push(i);
        }
        for(int i=0; i<heights.length; i++){
            int area  = (rightSmall[i]-leftSmall[i]-1)*heights[i];
            maxArea = Integer.max(maxArea, area);
        }
        return maxArea;
    }
}
