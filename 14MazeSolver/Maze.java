import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze{
    private static final int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0 -1}};
    Location start,end;
    private char[][] maze;
    
    public void showSolution(Location n){
        Location temp = n.getPrevious();        
        while(temp != start ){
            
            maze[temp.getRow()][temp.getCol()] = '@';
            temp = temp.getPrevious();
            
        }
    }
    
    
    public void addNeighbors(Location L, Frontier frontier, int mode){
        if(L != start){
            set(L, '.');
        }    
        Location temp;
        for(int[] coord: pos){
            try{
                int r = L.getRow() + coord[0];
                int c = L.getCol() + coord[1];
                temp = new Location(r, c, L, priority(r, c, mode));
                if(get(temp) == 'E'){
                    end = temp;
                    frontier.add(temp);
                }
                if(get(temp) == ' '){
                    set(temp, '?');
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
    
    public char get(Location loc){
        return maze[loc.getRow()][loc.getCol()];
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
