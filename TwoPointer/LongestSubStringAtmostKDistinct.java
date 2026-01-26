package TwoPointer;

import java.util.Scanner;

public class LongestSubStringAtmostKDistinct {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(kDistinctChars(k, s));
        sc.close();
    }
    public static int kDistinctChars(int k, String str) {
		int p1 =0;
		int p2 =0;
		int[] count  = new int[256];
		int distinct = 0;
		int max = -1;
		while(p2<str.length()){
			int x = str.charAt(p2);
			count[x]++;
			if(count[x]==1){
				distinct++;
			}
			while(distinct>k){
				int y = str.charAt(p1);
				count[y]--;
				if(count[y]==0){
					distinct--;
				}
				p1++;
			}
			max = Integer.max(max, p2-p1+1);
			p2++;
		}
		return max;
	}
}
