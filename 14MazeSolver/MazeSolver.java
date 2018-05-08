public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    
    public MazeSolver(String filename){
        maze = newMaze(filename);
    }
    
    //Default to BFS
    public boolean solve(){ return solve(0); }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
        if(mode == 0){
            frontier = new FrontierQueue();
        }else{
            frontier = new FrontierStack();
        }
    
        frontier.add(maze.getStart());
        Location n;
        while(frontier.hasNext()){
            n = frontier.getNext();
            if(n == maze.getEnd()){
                return true
            }
            maze.addNeighbors(frontier.next(), frontier);
            
        }
        
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
	
	
	return false;
    }
    
    public String toString(){
        return maze.toString();
    }
}
