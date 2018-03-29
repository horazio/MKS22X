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
        String ans = "";
        Node current = start;
        while(current != end){
            ans += current.toString() + " , ";
            current = current.getNext();
        }
        ans += current.toString();
        return ans;
    }

    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(6);
        System.out.println(list);
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
    
    
}


