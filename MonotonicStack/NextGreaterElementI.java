package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NextGreaterElementI {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums1 = new int[N];
        for(int i=0; i<N; i++){
            nums1[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] nums2 = new int[M];
        for(int i=0; i<M; i++){
            nums2[i] = sc.nextInt();
        }
        int[] ans = nextGreaterElement(nums1, nums2);
        for(int v: ans){
            System.out.print(v+" ");
        }
        sc.close();
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                stack.pop();
            }
            int val = (stack.isEmpty())?-1:stack.peek();
            map.put(nums2[i], val);
            stack.push(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }
        
        return nums1;
    }
}
