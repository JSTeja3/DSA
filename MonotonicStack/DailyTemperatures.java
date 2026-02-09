package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DailyTemperatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = sc.nextInt();
        }
        int[] ans = dailyTemperatures(temperatures);
        for (int value : ans) {
            System.out.print(value + " ");
        }
        sc.close();
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=temperatures.length-1; i>=0; i--){
            while(!dq.isEmpty() && temperatures[dq.peek()]<=temperatures[i]){
                dq.pop();
            }
            ans[i] = (dq.isEmpty())?0:dq.peek()-i;
            dq.push(i);
        }
        return ans;
    }
}
