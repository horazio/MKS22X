public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	myDeque(10);
    }

    public MyDeque(int init){
	if(init < 0){
	    throw new IllegalArgumentException();
	}
	data = (E()) new Object[init];
	start = 0;
	end = 0;
    }

    public int size(){
	return size;
    }

    public void addFirst(E elem){

    }

    public void addLast(E elem){

    }

    public E removeFirst(){
	
    }

    public E removeLast(){

    }

    

    

    

    
    




}
