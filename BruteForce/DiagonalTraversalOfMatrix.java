import java.util.Scanner;

public class DiagonalTraversalOfMatrix {
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
            DiagonalTraversalSum(N, ar);
        }
        sc.close();
    }
    public static void DiagonalTraversalSum(int N, int[][] ar){
        StringBuilder result = new StringBuilder();
        int j=N-1;
        int i=0;
        while(i<N && j>=0){ // move through first row and first column
            int sum = 0;
            int x = i;
            int y = j;
            while(x<N && y<N){ // move diagonally
                sum += ar[x][y];
                x++; 
                y++;
            }
            if(i>=j){
                i++;
            }
            else{
                j--;
            }
            result.append(sum).append(" ");

        }
        System.out.println(result);
    }
}
