import java.util.*;

public class SpiralPattern {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            printSpiral(t, N);
        }
        sc.close();
    }
    public static void printSpiral(int t, int N){
        char[][] result = new char[N][N];
        int top=0, left=0, bottom=N-1, right=N-1;

        for(char[] row : result){
            Arrays.fill(row, ' ');
        }
        boolean first = true;
        while(top<=bottom && left<=right){
            for(int i=left; i<=right; i++){
                result[top][i] = '*';
            } 
            top++;
            if(!first){ //Since we need to print bottom row till 0th column in first iteration
                left++;
            }
            for(int i=top; i<=bottom; i++){
                result[i][right] = '*';
            }
            right--;
            top++;
            if(first || top<=bottom){ //Edge case for N=2
                for(int i=right; i>=left; i--){
                    result[bottom][i] = '*';
                }
                bottom--;
                right--;
            }
            if(first || left<=right){ //Edge case for N=2
                for(int i=bottom; i>=top; i--){
                    result[i][left] = '*';
                }
                left++;
                bottom--;
            }
            first=false;
        }

        System.out.println("Case #"+t+":");

        for(char[] r : result){
            for(char c : r){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

}