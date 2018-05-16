public class Location implements Comparable<Location>{
    private int row,col,distance,priority;
    private Location previous;

    public Location(int _row, int _col, Location prev, int p, int d){
        row = _row;
        col = _col;
        previous = prev;
	priority = p;
        distance = d;
    }
    
    public Location(int _row, int _col, Location prev){
        row = _row;
        col = _col;
        previous = prev;
    }

    public int compareTo(Location other){
	return priority - other.getPriority();
    }

    public int getPriority(){
	return priority;
    }

    public int getDistance(){
	return distance;
    }
    
    public Location getPrevious(){
        return previous;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    
}

