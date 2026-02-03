package MonotonicStack;

import java.util.*;

public class PreviousGreaterElementToTheLeft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = findPreviousGreater(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
    public static int[] findPreviousGreater(int[] arr){
        int[] ans = new int[arr.length];
        Deque<Integer> dq = new ArrayDeque<>();  
        for(int i=0; i<arr.length; i++){
            while(!dq.isEmpty() && dq.peekFirst() < arr[i]){
                dq.removeFirst();
            }
            ans[i] = dq.isEmpty()?-1:dq.peekFirst();
            dq.addFirst(arr[i]);
        }
        return ans;
    }
}
