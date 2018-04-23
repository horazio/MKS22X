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
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[]) new Object[10];
        start = 0;
        end = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        if(size == data.length - 1){
            E[] newData = (E[]) new Object[2 * size];
            int c = 0;
            for(int i = start; i != end; i = (i + 1) % data.length){
                newData[c] = data[i];
                c++;
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
    end = (data.length + (end - 1)) % data.length;
	E holder = data[end];
	data[end] = null;
	
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
    return data[end - 1];
    }
    
    public static void main(String[] args){
        MyDeque<String> a = new MyDeque<String>(), a1 = new MyDeque<String>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }

   
    }
    
    
    
}
