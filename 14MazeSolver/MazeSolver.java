public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    
    public MazeSolver(String filename){
        maze = new Maze(filename);
    }
    
    //Default to BFS
    public boolean solve(){ return solve(0); }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
        if(mode == 0){
            frontier = new FrontierQueue();
        }else if(mode == 1){
            frontier = new FrontierStack();
        }else if(mode == 2){
	    frontier = new FrontierPriorityQueue();
	}
    
        frontier.add(maze.getStart());
        Location n;
        while(frontier.hasNext()){
            n = frontier.next();
            if(n.getRow() == maze.getEnd().getRow() && n.getCol() == maze.getEnd().getCol()){
                maze.showSolution(n);
                return true;
            }
            maze.addNeighbors(n, frontier, mode);
            
        }
        
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
	
	//System.out.println("adsf");
	
    return false;
    }
    

    public String toString(){
        
       // System.out.println(maze.getEnd().getPrevious());
        return maze.toString();
    }
    
    public static void main(String[] args){
        MazeSolver test = new MazeSolver("input.txt");
        test.solve(1);
        //System.out.println()
        System.out.println(test);
    }
}
