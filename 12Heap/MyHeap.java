public class MyHeap{
    String[] heap;
    int size;
    boolean max;
    
    public MyHeap(){
        heap = new String[10];
        size = 0;
        max = true;
    }
    
    public MyHeap(boolean toggle){
        heap = new String[10];
        size = 0;
        max = toggle;
    }
    
    public int size(){
        return size;
    }
    
    private void resize(){
        if(size >= heap.length - 1){
            String[] temp = new String[size * 2];
            for(int i = 0; i < size; i++){
                temp[i] = heap[i];
                heap = temp;
            }
        }
    }
    
    
    
    public void add(String s){
        resize();
        heap[size] = s;
        String temp;
        for(int i = size; i > 0 && ((heap[i].compareTo(heap[(i - 1) / 2]) < 0 ) ^ max); i = (i - 1) / 2){
            temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
        }
        size++;
    }
    
    public String remove(){
        String temp = heap[0];
        
        size--;
        return temp;
    }
    
    public String peek(){
        return heap[0];
    }
    
    public String toString(){
        String pta = "";
        String ptb = "";
        for(int i = 0; i < size; i++){
            pta += heap[i] + " ";
            ptb += i + " ";
        }
        return pta + "\n" + ptb;
    }
    
    public static void main(String[] args){
        MyHeap heap = new MyHeap(true);
        heap.add("1");
        heap.add("2");
        heap.add("3");
        heap.add("4");
        heap.add("5");
        heap.add("6");
        heap.add("7");
        heap.add("8");
        
        System.out.println(heap);
    }
    
}