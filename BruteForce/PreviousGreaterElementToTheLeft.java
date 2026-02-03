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
        for(int i=0; i<arr.length; i++){
            ans[i] = -1;
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
}
