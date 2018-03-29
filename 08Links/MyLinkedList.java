public class MyLinkedList{
    Node start;
    Node end;
    int size;

    public MyLinkedList(){
       
    }

    public boolean add(int value){
        Node newNode = new Node(value, null);
        if(size == 0){
            start = newNode;
            
        }else{
            end.setNext(newNode);         
        }
        end = newNode;
        size++;
        return true;
    }
    
    public String toString(){
        String ans = "[ ";
	Node current = start;
	for(int i = size; i > 0; i--){
            ans += current.toString() + " , ";
            current = current.getNext();
        }
        return ans + " ]";
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    public int size(){
	return size;
    }

    public Integer get(int index){
	
	Node current = start;
	for(int i = index; i > 0; i--){
	    current = current.getNext();
	}
    }
    
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(6);
	//	list.clear();
        System.out.println(list);
	System.out.println(list.size());
    }
    
    
    private class Node{
	Node next;
	Integer value;
	
	public Node(int data, Node nextData){
	    value = data;
	    next = nextData;
	}
	
	
	public Node getNext(){
	    return next;    
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
	
	public void setValue(int data){
	    value = data;
	}
	
    }
    
    
}


