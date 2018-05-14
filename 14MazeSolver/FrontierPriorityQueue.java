public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> frontier;
    public FrontierPriorityQueue(){
        frontier = new MyHeap<Location>();
    }
    
    public Location next(){
        return frontier.remove();
    }
    public void add(Location n){
        frontier.add(n);
    }
    public boolean hasNext(){
        return frontier.size() > 0;
    }
}
