import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(reverse(x));
        sc.close();
    }
    public static int reverse(int x) {
        int result = 0;
        while(x!=0){

            if(result>Integer.MAX_VALUE/10  || (result==Integer.MAX_VALUE/10 && x%10>7)) return 0;
            if(result<Integer.MIN_VALUE/10  || (result==Integer.MIN_VALUE/10 && x%10<-8)) return 0;
            result = result*10+x%10;
            x=x/10;

        }
        return result;
    }

}
