public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	myDeque(10);
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int init){
	if(init < 0){
	    throw new IllegalArgumentException();
	}
	data = (E()) new Object[init];
	start = 0;
	end = 0;
	size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	if(size == data.length()){
	    E[] newData = (E()) new Object[2 * size];
	    for(int i = 0; i < size; i++){
		newData[i] = data[(start + i) % size];
	    }
	    data = newData;
	}
    }

    
    public int size(){
	return size;
    }

    public void addFirst(E elem){
	if(elem == null){
	    throw new NullPointerException();
	}
	resize();
	start = (start - 1) % size;
	data[start] = elem;
	size++;
    }
    
    public void addLast(E elem){
	if(elem == null){
	    throw new NullPointerException();
	}
	resize();
	end =(end + 1) % size;
	data[end] = elem;
	size++;
    }
    
    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}

	
	E holder = data[start];
	data[start] = null;
	start = (start + 1) % size;
	size--;
	return holder;
    }

    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E holder = data[end];
	data[end] = null;
	end = (end - 1) % size;
	size--;
	return holder; 
    }

            
    
    public E getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
    }
    
    public E getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
    }
    
    
    
}
