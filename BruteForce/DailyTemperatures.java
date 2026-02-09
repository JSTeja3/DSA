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
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
