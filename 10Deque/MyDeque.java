import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

   

    @SuppressWarnings("unchecked")
    public MyDeque(int init){
	if(init < 0){
	    throw new IllegalArgumentException();
	}
    data = (E[]) new Object[init];
	start = 0;
	end = 0;
	size = 0;
    }
    
    
    //public MyDeque(){
    //    MyDeque<E>(10);
    //}

    @SuppressWarnings("unchecked")
    private void resize(){
        if(size == data.length){
            E[] newData = (E[]) new Object[2 * size];
            for(int i = 0; i < size; i++){
                newData[i] = data[(start + i) % size];
            }
            start = 0;
            end = size;
            data = newData;
        }
    }

    
    public String toString(){
        String ans = "";
        for(int i = start; i != end; i = (i + 1) % data.length){
            ans += data[i] + "\n";
        }
        return ans;
    }
    
    //for testing
    public String arrayToString(){
        String ans = "";
        
        for(int i = 0; i < data.length; i++){
            ans += data[i] + "\n";
        }
        
        return ans;
    }
    
    public int size(){
        return size;
    }

    public void addFirst(E elem){
        if(elem == null){
            throw new NullPointerException();
        }
        resize();
        start = (data.length + (start - 1)) % data.length;
        data[start] = elem;	
        size++;
    }
    
    public void addLast(E elem){
        if(elem == null){
            throw new NullPointerException();
        }
        resize();
        data[end] = elem;
        end = (end + 1) % data.length; 
        size++;
    }
    
    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}

	
	E holder = data[start];
	data[start] = null;
	start = (start + 1) % data.length;
	size--;
	return holder;
    }

    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E holder = data[end];
	data[end] = null;
	end = (data.length + (end - 1)) % data.length;
	size--;
	return holder; 
    }

            
    
    public E getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
    return data[start];
    }
    
    public E getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
    return data[end];
    }
    
    public static void main(String[] args){
        MyDeque<String> deq= new MyDeque<>(5);
        
        deq.addFirst("Robert");
        deq.addLast("Jim");
        deq.addFirst("ree");
        deq.addLast("normies");
        deq.addLast("normies");
        deq.addLast("normies");
        deq.addLast("normies");
        deq.addLast("normies");
        deq.addLast("normies");
        deq.addLast("normies");
        
        
        
        System.out.println(deq.arrayToString());
        System.out.println();
        System.out.println(deq);
        
        System.out.println();
        System.out.println(deq.removeFirst());
        System.out.println(deq.removeFirst());
        System.out.println(deq.removeLast());
        System.out.println(deq.removeLast());
        System.out.println(deq.removeLast());
        System.out.println();
        
        
        System.out.println(deq.arrayToString());
        System.out.println();
        System.out.println(deq);
    }
    
    
    
}
