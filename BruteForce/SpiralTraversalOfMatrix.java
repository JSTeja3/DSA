import java.util.Scanner;

public class SpiralTraversalOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            int[][] ar = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    ar[i][j] = sc.nextInt();
                }
            }
            spiralTraversal(N, ar);
        }
        sc.close();
    
    }

    public static void spiralTraversal(int N, int[][] ar){
        StringBuilder result = new StringBuilder();
        int top=0, bottom=N-1, left=0, right=N-1;
        while(top<=bottom && left<=right){
            for(int i=left; i<=right; i++){
                result.append(ar[top][i]).append(" ");
            }
            top++;
            for(int i=top; i<=bottom; i++){
                result.append(ar[i][right]).append(" ");
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    result.append(ar[bottom][i]).append(" ");
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    result.append(ar[i][left]).append(" ");
                }
                left++;
            }
        }
        System.out.println(result);
    }
}
