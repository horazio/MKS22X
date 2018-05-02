import java.util.*;
public class RunningMedian{
    int size;
    Double median;
    MyHeap<Double> minHeap, maxHeap;
    
    public RunningMedian(){
        size = 0;
        minHeap = new MyHeap<Double>(false);
        maxHeap = new MyHeap<Double>(true);
    }
    
    public void add(Double d){
        if(d > median){
            maxHeap.add(d);
        }else{
            minHeap.add(d);
        }
        
        if(maxHeap.size() - minHeap.size() == 2){
            minHeap.add(maxHeap.remove());
        }else if(minHeap.size() - maxHeap.size() == 2){
            maxHeap.add(minHeap.remove());
        }
        
        if(maxHeap.size() > minHeap.size()){
            median = maxHeap.peek();
        }else if(maxHeap.size() == minHeap.size()){
            median = (maxHeap.peek() + minHeap.peek()) / 2;
        }else{
            median = minHeap.peek();
        }
    }
    
    public Double getMedian(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return median;
    }
    
    public int size(){
        return size;
    }
    
    
}