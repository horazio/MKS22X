import java.util.LinkedList;
public class MyLinkedListImproved<T extends Comparable<T>>{
    private Node start;
    private Node end;
    int size;

    public MyLinkedListImproved(){
       
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
    
    
    public static void main(String[] args){
        MyLinkedListImproved<String> list = new MyLinkedListImproved<>();
        list.add(0, "1342");
        list.add(0, "1341212");
        list.add(0, "134ds2");
        list.add(0, "134a2");
        list.add(0, "134adf2");
        System.out.println(list.remove("1342"));
        System.out.println(list);
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
    
    
}

