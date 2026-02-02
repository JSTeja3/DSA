package MonotonicStack;

import java.util.*;

public class NextGreaterElementToTheRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = findNextGreater(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }

    public static int[] findNextGreater(int[] arr) {
        int[] ans = new int[arr.length];
        //Use Deque instead of Stack since it became legacy and Deque is modern Replacement
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!dq.isEmpty() && dq.peekFirst()<=arr[i]) {
                dq.removeFirst();
            }
            if(!dq.isEmpty() && dq.peekFirst()>arr[i]){
                ans[i] = dq.peekFirst();
            }
            else{
                ans[i]=-1;
            }
            dq.addFirst(arr[i]);
        }
        return ans;
    }
}