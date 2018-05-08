import java.util.*;
public class FrontierQueue implements Frontier{
    private ArrayDeque<Location> frontier;
   
    public FrontierQueue{
        frontier = new ArrayDeque<Location>();
    }
    
    public Location next(){
        return frontier.poll();
    }
    public void add(Location n){
        frontier.offer(n);
    }
    public boolean hasNext(){
        return frontier.size();
    }

}