public class MyLinkedList{
    private Node start;
    private Node end;
    int size;

    public MyLinkedList(){
       
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
    
    
    public Integer get(int index){
        return getNode(index).getValue();
    }
    
    public Integer set(int index, Integer value){
        return getNode(index).setValue(value); 
    }
    
    public int indexOf(Integer value){
        Node current = start;
        for(int i = 0; i < size - 1; i++){
            if(current.getValue().equals(value)){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }
    
    public boolean add(int value){
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
    
    public void add(int index, Integer value){
        Node newNode = new Node(value, null, null);
        if(index == size){
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
    
    // public boolean remove(Integer value){
    //  return Integer.valueof(7);
    // }

    public Integer remove(int value){
        //if(value = start)
    	Node pos = getNode(value);
        Integer val = pos.getValue();
        pos.getPrevious().setNext(pos.getNext());
        pos.getNext().setPrevious(pos.getPrevious());
        size--;
        return val;
    }
    
    
    public static void main(String[] args){
        //ADD EXCEPTIONS
        MyLinkedList list = new MyLinkedList();
	    list.add(5);
        list.add(6);
        list.add(10);
        list.add(3);
        list.add(2, 101);
        list.add(5, 33);
        //list.remove(0);
        //list.clear();
        //System.out.println(list.set(2, 200));
        //System.out.println(list.size());
        System.out.println(list);
	System.out.println(list.toStringReverse());
    }
    
    
    private class Node{
        Node next;
        Node prev;
        Integer value;
	
        public Node(int data, Node nextData, Node prevData){
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
	
        public Integer getValue(){
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
	
        public Integer setValue(int data){
            int holder = value;
            value = data;
            return holder;
        }
	
    }
    
    
}


