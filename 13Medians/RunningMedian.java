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
        if(size == 0){
            maxHeap.add(d);
            median = d;
        }else{
            if(d > median){
                minHeap.add(d);
            }else{
                maxHeap.add(d);
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
        size++;
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
    
    public static void main(String[] args){
        double[] a = new double[111];
        RunningMedian test = new RunningMedian();
        for(int i = 0; i < a.length; i++){
            a[i] = 100 * Math.random();
            test.add(a[i]);
        }
        
        Arrays.sort(a);
        System.out.println(a[55]);
        System.out.println(test.getMedian());
    }
}