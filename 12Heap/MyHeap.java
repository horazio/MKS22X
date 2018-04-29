import java.util.*;
public class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private int size;
    private boolean max;
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
        heap = (T[]) new Comparable[10];
        size = 0;
        max = true;
    }
    
    @SuppressWarnings("unchecked")
    public MyHeap(boolean toggle){
        heap = (T[]) new Comparable[10];
        size = 0;
        max = toggle;
    }
    
    public int size(){
        return size;
    }
    
    private void resize(){
        if(size == heap.length - 1){
            T[] temp = (T[]) new Comparable[size * 2];
            for(int i = 0; i < size; i++){
                temp[i] = heap[i];    
            }
            heap = temp;
        }
    }
      
    public void add(T s){
        resize();
        heap[size] = s;
        T temp;
        
        for(int i = size; i > 0 && ((heap[i].compareTo(heap[(i - 1) / 2]) < 0 ) ^ max); i = (i - 1) / 2){
            temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
        }
        size++;
    }
    
    public T remove(){
        if(size == 0){
            throw new UnsupportedOperationException();
        }
        T first = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if(size == 0){
            return first;       
        }
        
        T temp;
        int newi = 0;
        boolean goOn = true;
        
        int i = 0;
        while(size > 1 && newi == 0 || (goOn && ((heap[i].compareTo(heap[newi]) >= 0) ^ max))){
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
    
    public T peek(){
        return heap[0];
    }
    
    public String toString(){
        String pta = "";
        for(int i = 0; i < size; i++){
            pta += heap[i] + " ";
        }
        return pta;
    }
    
    //public static void heapify
    
    public static void main(String[] args){
        MyHeap<Integer> heap = new MyHeap<Integer>(false);
        heap.add(3);
        heap.add(2);
        heap.add(14);
        heap.add(14);
        heap.add(46);
        heap.add(33);
        heap.add(34454);
        heap.add(45);
        heap.add(3);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(1);
        heap.add(3);
        heap.add(4);
        heap.add(2);
        heap.add(63);
        heap.add(38);
        heap.add(324);
        heap.add(36);
        heap.add(36);
        heap.add(33);
        heap.add(32);
        heap.add(31);
        heap.add(32);
        heap.add(373);
        heap.add(455);
        heap.add(224);
        System.out.println(heap);
        
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        
        System.out.println(heap);
    }
    
}