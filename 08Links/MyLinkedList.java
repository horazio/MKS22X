public class MyLinkedList{
    Node start;
    Node end;
    Node current;
    int size;

    public MyLinkedList(){
       
    }

    public boolean add(int value){
	Node newNode = new Node(value, null);
	if(size == 0){
	    
	}
      
	end.setNext()
	end = end.set;
	size++;
    }

    
}

private class Node{
    Node next;
    int value;
    
    public Node(int data, Node nextData){
	value = data;
	next = nextData;
    }


    public Node getNext(){
	return next;
    }

    public int getValue(){
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
