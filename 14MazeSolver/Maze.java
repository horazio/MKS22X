import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze{
    private static final int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0 -1}};
    Location start,end;
    private char[][] maze;
    
    public void showSolution(Location n){
        Location temp = n;
        
        while(temp != start ){
            //System.out.println(this);
            temp = temp.getPrevious();
            //System.out.println(temp);
            maze[temp.getRow()][temp.getCol()] = '@';
            
        }
    }
    
    
    public void addNeighbors(Location L, Frontier frontier, int mode){
        if(L != start){
            set(L, '.');
        }    
        Location temp;
        for(int[] coord: pos){
            try{
                temp = new Location(L.getRow() + coord[0], L.getCol() + coord[1], L);
                if(maze[temp.getRow()][temp.getCol()] == ' ' || maze[temp.getRow()][temp.getCol()] == 'E'){
                    maze[temp.getRow()][temp.getCol()] = '?';
                    frontier.add(temp);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                
            }
        }
    }
    
    public int priority(int r, int c, int mode){
        if(mode == 3){
            return Math.abs(r - end.getRow()) + Math.abs(c - end.getCol()) + Math.abs(r - start.getRow()) + Math.abs(c - start.getCol());
        }else if(mode == 2){
            return Math.abs(r - end.getRow()) + Math.abs(c - end.getCol());
        }
        return -1;
    }

    public Location getStart(){
        return start;
    }
  
    public Location getEnd(){ 
        return end;
    }
    
    public char get(int row,int col){
        return maze[row][col];
    }
    
    public void set(Location loc, char n){
        maze[loc.getRow()][loc.getCol()] = n;
    }
    
    
   
  
  
    public Maze(String filename){
        ArrayList<char[]> lines = new ArrayList<char[]>();
        int startr=-1, startc=-1;
        int endr=-1,endc=-1;
        try{
        Scanner in = new Scanner(new File(filename));
        while(in.hasNext()){
            lines.add(in.nextLine().toCharArray());
        }
        }catch(FileNotFoundException e){
            System.out.println("File not found: "+filename);
            System.exit(1);
        }
        maze = new char[lines.size()][];
        for(int i = 0; i < maze.length; i++){
            maze[i]=lines.get(i);
        }
        for(int r=0; r<maze.length;r++){
            for(int c=0; c<maze[r].length;c++){
                if(maze[r][c]=='S'){
                    if(startr == -1){
                        startr=r;
                        startc=c;
                    }else{
                        System.out.println("Multiple 'S' found!");
                    System.exit(0);
                    }
                }

                if(maze[r][c]=='E'){
                //erase E
                //maze[r][c]=' ';
                    if(endr == -1){
                        endr=r;
                        endc=c;
                    }else{
                        System.out.println("Multiple 'E' found!");
                        System.exit(0);
                    }
                }
            }
        }
        if(startr == -1 || endr == -1){
            System.out.println("Missing 'S' or 'E' from maze.");
            System.exit(0);
        }

        /*
        THIS IS AN IMPORTANT PART BECAUSE YOU WILL NEED TO CHANGE IT LATER!
        The start/end Locations may need more information later when we add
        other kinds of frontiers!
        */
        end = new Location(endr, endc, null);
        start = new Location(startr,startc,null, 0);
    }


    
    
    
    public String toString(){
        int maxr = maze.length;
        int maxc = maze[0].length;
        String ans = "";
        for(int i = 0; i < maxr * maxc; i++){
            int row = i/maxc;
            int col = i%maxc;
            char c =  maze[row][col];
            ans+=c;
            if( col == maxc-1 ){
                ans += "\n";
            }
        }
        return ans + "\n";
    } 
 
}
