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