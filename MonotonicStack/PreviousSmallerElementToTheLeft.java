package MonotonicStack;

import java.util.*;

public class PreviousSmallerElementToTheLeft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = findPreviousSmaller(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
    public static int[] findPreviousSmaller(int[] arr){
        int[] ans  = new int[arr.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++){
            while(!dq.isEmpty() && dq.peek()>arr[i]){
                dq.pop();
            }
            ans[i] = dq.isEmpty()?-1:dq.peek();
            dq.push(arr[i]);
        }
        return ans;
    }
}
