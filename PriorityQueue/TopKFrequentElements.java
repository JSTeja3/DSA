package PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = topKFrequent(nums, k);
        for(int val:result){
            System.out.print(val+" ");
        }
        sc.close();
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);

            if(pq.size()>k){
                pq.poll();
            }
        }


        for(int i=0; i<k; i++){
            result[i] = pq.poll().getKey();
        }
            
        return result;
    }
}
