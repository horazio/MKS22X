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
        String first = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        String temp;
        int newi = 0;
        boolean goOn = true;
        
        int i = 0;
        while(newi == 0 || (goOn && ((heap[i].compareTo(heap[newi]) >= 0) ^ max))){
            temp = heap[newi];
            heap[newi] = heap[i];
            heap[i] = temp;
            i = newi;
            if((2 * i) + 1 >= size){
                goOn = false;
            }else if((2 * i) + 2 >= size){
                newi = (2 * i) + 1; 
            }else{
                if((heap[(2 * i) + 2].compareTo(heap[(2 * i) + 1]) < 0) ^ max){ 
                    newi = (2 * i) + 2; 
                }else{
                    newi = (2 * i) + 1;
                }
            }
        }
        return first;
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
        MyHeap heap = new MyHeap(true);
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
        heap.add("A");
        heap.add("1");
        heap.add("1");
        heap.add("9");
        
        
        System.out.println(heap);
        
        heap.remove();
        
        System.out.println(heap);
    }
    
}