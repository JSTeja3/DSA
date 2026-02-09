import java.util.ArrayList;
import java.util.Scanner;

public class StackSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = calculateSpan(arr);
        for (int value: ans) {
            System.out.print(value + " ");
        }
        sc.close();
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(i+1);
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    result.set(i, i - j);
                    break;
                }
            }
        }
        return result;
    }
}
