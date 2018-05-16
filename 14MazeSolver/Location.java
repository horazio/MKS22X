public class Location implements Comparable<Location>{
    private int row,col;
    private Location previous;
    private int distance;

    public Location(int _row, int _col, Location prev, int d){
        row = _row;
        col = _col;
        previous = prev;
        distance = d;
    }
    
    public Location(int _row, int _col, Location prev){
        row = _row;
        col = _col;
        previous = prev;
    }

    public int compareTo(Location other){
	return distance - other.getDistance();
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

