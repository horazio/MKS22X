import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int[][] coords;

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename)throws FileNotFoundException, IllegalStateException{
        int[][] c = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        coords = c;
        File text = new File(filename);// can be a path like: "/full/path/to/file.txt" 
        //inf stands for the input file
        Scanner inf = new Scanner(text);
        int count = 0;
	int width = 0;
	while (inf.hasNextLine()) {
	    count++;
	    width = inf.nextLine().length();
	}
    inf = new Scanner(text);
	maze = new char[count][width];
    count = 0;
        while(inf.hasNextLine()){
            String a = inf.nextLine();
	    for(int i = 0; i < a.length(); i++){
		maze[count][i] = a.charAt(i);
	    }
	    count++;
        }
        
        invalid();
        
    }
    
    private void invalid() throws IllegalStateException{
        int countE = 0;
        int countS = 0;
        for(int r = 0; r < maze.length; r++){
                for(int c = 0; c < maze[0].length; c++){
                    if (maze[r][c] == 'E'){
                        countE++;
                    }
                    if (maze[r][c] == 'S'){
                        countS++;
                    }
                }
            
            }
        if(!(countE == 1 && countS == 1)){
            throw new IllegalStateException();
        }
    }
    
    
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

   

    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    
    public String toString(){
        String ans = "";
        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                ans += maze[r][c];
            }
            ans += '\n';
        }
        return ans;
    }
    
    
    public int solve(){
        //find the location of the S. 
        //erase the S
        //and start solving at the location of the s.
        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                if (maze[r][c] == 'S'){
                    return solve(r, c, 0);
                }
            }
        }
        return 0;   
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    
    private int solve(int row, int col, int count){ //you can add more parameters since this is private
        //System.out.println(count);
        
        //if(animate){
        //    clearTerminal();
        //    System.out.println(this);
        //    wait(10);
        //}
        if(maze[row][col] == 'E'){
            return count;
        }
        
        if(maze[row][col] == '#' || maze[row][col] == '@' || maze[row][col] == '.'){      
            //System.out.println('r');
            
            return -1;
        }
        maze[row][col] = '@';
        for(int i = 0; i < coords.length; i++){
            int a = solve(row + coords[i][0], col + coords[i][1], count + 1);
            if(a > 0){;
                return a;
            }
            //count--;
            
        }
        maze[row][col] = '.';
        

        return -1;//COMPLETE SOLVE

    }
    

    public static void main(String[]args){
        Maze f;
        
        try {
            f = new Maze("data3.dat");//true animates the maze.
            //for(int r = 0; r < f.maze.length; r++){
            //    for(int c = 0; c < f.maze[0].length; c++){
            //        System.out.print(f.maze[r][c]);
            //    }
            //System.out.println();
            //}
            f.setAnimate(true);
            System.out.println(f.solve());
            System.out.println(f);
        }catch(FileNotFoundException e){
            
        }
        
       

        //System.out.println(f);
    }
    
}
