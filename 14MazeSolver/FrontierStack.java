import java.util.*;
public class FrontierStack implements Frontier{
    private ArrayDeque<Location> frontier;
   
    public FrontierStack(){
        frontier = new ArrayDeque<Location>();
    }
    
    public Location next(){
        return frontier.pop();
    }
    public void add(Location n){
        frontier.push(n);
    }
    public boolean hasNext(){
        return frontier.size() > 0;
    }

}