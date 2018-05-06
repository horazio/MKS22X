public class Location{
    private int row,col;
    private Location previous;

    public Location(int _row, int _col, Location prev){
        row = _row;
        col = _col;
        previous = prev;
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

