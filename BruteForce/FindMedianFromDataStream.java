import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedianFromDataStream {
    class MedianFinder {
    private List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int val = list.size()/2;
        if(list.size()%2 == 0){
            return ((double)list.get(val)+list.get(val-1))/2.0;
        }
        else{
            return (double)list.get(val);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
