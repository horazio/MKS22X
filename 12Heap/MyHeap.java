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
        if(size == heap.length - 1){
            String[] temp = new String[size * 2];
            for(int i = 0; i < size; i++){
                temp[i] = heap[i];    
            }
            heap = temp;
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
        String tempV = heap[0];
        heap[0] = heap[size--];
        String temp;
        int i = 0;
        while((2 * i) + 2 < size && (((heap[i].compareTo(heap[(2 * i) + 1]) < 0 ) ^ max) ||
                           ((heap[i].compareTo(heap[(2 * i) + 2]) < 0) ^ max)
                          )
            ){
            if((heap[(2 * i) + 2].compareTo(heap[(2 * i) + 1]) > 0) ^ max){ 
                temp = heap[(2 * i) + 2];
                heap[(2 * i) + 2] = heap[i];
                heap[i] = temp; 
                i = (2 * i) + 2; 
            }else{
                temp = heap[(2 * i) + 1];
                heap[(2 * i) + 1] = heap[i];
                heap[i] = temp; 
                i = (2 * i) + 1;
            }
        }
        return tempV;
    }
    
    public String peek(){
        return heap[0];
    }
    
    public String toString(){
        String pta = "";
        for(int i = 0; i < size; i++){
            pta += heap[i] + " ";
        }
        return pta;
    }
    
    public static void main(String[] args){
        MyHeap heap = new MyHeap(false);
        heap.add("1");
        heap.add("2");
        heap.add("3");
        heap.add("4");
        heap.add("5");
        heap.add("6");
        heap.add("7");
        heap.add("1");
        heap.add("1");
        heap.add("1");
        heap.add("1");
        heap.add("0");
        heap.add("1");
        heap.add("1");
        heap.add("1");
        heap.add("1");
        heap.add("1");
        heap.add("1");
        
        
        System.out.println(heap);
        
        heap.remove();
        
        System.out.println(heap);
    }
    
}