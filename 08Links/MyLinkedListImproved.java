import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node start;
    private Node end;
    int size;

    public MyLinkedListImproved(){
       
    }
    
    public LLIterator iterator(){
        return new LLIterator(start);
    }
    
    public String toString(){
        String ans = "[ ";
        Node current = start;
        for(int i = size; i > 0; i--){
            ans += current.toString() + ", ";
            current = current.getNext();
        }
        return ans + "]";
    }

    public String toStringReverse(){
        String ans = "[ ";
        Node current = end;
        for(int i = size; i > 0; i--){
            ans += current.toString() + ", ";
            current = current.getPrevious();
        }
        return ans + "]";
    }

    public void clear(){
        start = null;
        end = null;
        size = 0;
    }

    public int size(){
        return size;
    }
    
    private Node getNode(int index){  
        Node current = start;
        for(int i = index; i > 0; i--){
            current = current.getNext();
        }
        return current;
    }
    
    
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).getValue();
    }
    
    public T set(int index, T value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).setValue(value); 
    }
    
    public int indexOf(T value){
        Node current = start;
        for(int i = 0; i < size - 1; i++){
            if(current.getValue().equals(value)){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }
    
    public boolean add(T value){
        Node newNode = new Node(value, null, null);
        if(size == 0){
            start = newNode;
            
        }else{
            newNode.setPrevious(end);
            end.setNext(newNode);         
        }
        end = newNode;
        size++;
        return true;
    }
    
    public void add(int index, T value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value, null, null);
        if(size == 0){
            add(value);
            size--;
        }else if(index == size){
            end.setNext(newNode);
            newNode.setPrevious(end);
            end = newNode;
            
        }else if(index > 0){
            Node pos = getNode(index - 1);
            newNode.setPrevious(pos);
            pos.getNext().setPrevious(newNode);
            newNode.setNext(pos.getNext());
            pos.setNext(newNode);
        }else{
            start.setPrevious(newNode);
            newNode.setNext(start);
            start = newNode;
        }
        size++;
    }
    
    public boolean remove(T value){
        Node current = start;
        for(int i = 0; i < size; i++){
            if(current.getValue().equals(value)){
                remove(i);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T remove(int value){
        if(value < 0 || value >= size){
            throw new IndexOutOfBoundsException();
        }
        T val;
        if(size == 1){
            val = start.getValue();
            clear();
            return val;
        }else if(value == 0){
            val = start.getValue();
            start = start.getNext();
            start.setPrevious(null);
        }else if (value == size - 1){
            val = end.getValue();
            end = end.getPrevious();
            end.setNext(null);
        }else{
            Node pos = getNode(value);
            val = pos.getValue();
            pos.getPrevious().setNext(pos.getNext());
            pos.getNext().setPrevious(pos.getPrevious());
        }
        size--;
        return val;
    }
    
    public int max(){
        if(size == 0){
            return -1;
        }
        int max = 0;
        int i = 0;
        for(T elem : this){
            if(elem.compareTo(this.get(max)) > 0){
                max = i;
            }
            i++;
        }
        
        return max;
    }
    
    public int min(){
        if(size == 0){
            return -1;
        }
        int min = 0;
        int i = 0;
        for(T elem : this){
            if(elem.compareTo(this.get(min)) < 0){
                min = i;
            }
            i++;
        }
        
        return min;
        
    }
    
    public void extend(MyLinkedListImproved<T> other){
	if(other.size() > 0){
	    if(size == 0){
		start = other.start;
		end = other.end;
		
	    }else{
		//	other.start.setPrevious(end);
		//	end.setNext(other.get);
	    }
	    other.clear();
	}	
    }
    public static void main(String[] args){
	MyLinkedListImproved<Integer> list = new MyLinkedListImproved<>();
        String ans = " -- ";
        list.add(123);
        list.add(2);
        list.add(30);
        list.add(4);
        list.add( 5);
        System.out.println(list.min() );
    }

    
    
    private class Node{
        Node next;
        Node prev;
        T value;
	
        public Node(T data, Node nextData, Node prevData){
            value = data;
            next = nextData;
            prev = prevData;
        }
	
	
        public Node getNext(){
            return next;    
        }
        
        public Node getPrevious(){
            return prev;
        }
	
        public T getValue(){
            return value;
        }
        public String toString(){
            return value + "";
        }
        public void setNext(Node nextData){
            next = nextData;
        }
        
        public void setPrevious(Node prevData){
            prev = prevData;
        }
	
        public T setValue(T data){
            T holder = value;
            value = data;
            return holder;
        }
	
    }
    
    private class LLIterator implements Iterator<T>{
        Node next;
    
        public LLIterator(Node h){
            next = h;
        }
    
        public boolean hasNext(){
            return next != null;
        }
    
        public T next(){
	    if(!(this.hasNext())){
		throw new NoSuchElementException();
	    }
            T holder = next.getValue();
            next = next.getNext();
            return holder;
        }
    
        public void remove(){
            throw new UnsupportedOperationException();
        }
    
    }
    
}



