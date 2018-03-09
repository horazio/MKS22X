import java.util.*;
import java.io.*;
public class USACO{
    
    
    public static int bronze(String filename){
        
        try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
        
        
	    String[] lines = inf.nextLine().split(" ");
	    int[] line1 = new int[4];
	    for(int i = 0; i < lines.length; i++){
		line1[i] = Integer.parseInt(lines[i]);
	    }
        
        
	    int[][] field = new int[line1[0]][line1[1]];
	    int depth = line1[2];
	    int[][] moves = new int[line1[3]][3];
        
        
	    String[] nextL;
	    for(int i = 0; i < field.length; i++){
		nextL = inf.nextLine().split(" ");
		for(int j = 0; j < field[0].length; j++){
                
		    field[i][j] = Integer.parseInt(nextL[j]);
		}
	    }
        
        
	    for(int i = 0; i < moves.length; i++){
		nextL = inf.nextLine().split(" ");
		moves[i][0] = Integer.parseInt(nextL[0]) - 1;
		moves[i][1] = Integer.parseInt(nextL[1]) - 1;
		moves[i][2] = Integer.parseInt(nextL[2]);
            
	    }
        
	    int row = 0;
	    int col = 0;
        
	    for(int i = 0; i < moves.length; i++){
            
        
		row = moves[i][0];
		col = moves[i][1];
		for(int j = 0; j < field.length; j++){
		    for(int k = 0; k < field[0].length; k++){
                
			if(j >= moves[i][0] && j < moves[i][0] + 3 &&
			   k >= moves[i][1] && k < moves[i][1] + 3 &&
			   field[j][k] > field[row][col]
			   ){
			    row = j;
			    col = k;
			}
                    
		    }
		}
            
		field[row][col] -= moves[i][2];
            
		for(int j = 0; j < field.length; j++){
		    for(int k = 0; k < field[0].length; k++){
                
			if(j >= moves[i][0] && j < moves[i][0] + 3 &&
			   k >= moves[i][1] && k < moves[i][1] + 3 &&
			   field[j][k] > field[row][col]
			   ){
			    field[j][k] = field[row][col];
			}
                    
		    }
		}
            
            
            
            
	    }
        
	    int addDepth = 0;
	    int a = 0;
	    for(int i = 0; i < field.length; i++){
		for(int j = 0; j < field[0].length; j++){
		    a = depth - field[i][j];
		    if(field[i][j] >= 0 && a >= 0){
			addDepth += a;
		    }
		}
	    }
        
        
	    return 72 * 72 * addDepth;
        
        }catch(FileNotFoundException e){
            
        }
        
        
        
        return -1;
        
    }
    
    
    
    
    
    
    
    
    public static void clear(int[][] field){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
		if(field[i][j] > 0){
		    field[i][j] = 0;
		} 
            }
        }
    }
    
    
    
    
    
    public static int silver(String filename){
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        
        try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
        
	
	    String[] lines = inf.nextLine().split(" ");
	    int[] line1 = new int[3];

	    for(int i = 0; i < lines.length; i++){
	   
		line1[i] = Integer.parseInt(lines[i]);
	    }
        
        
	    int[][] field1 = new int[line1[0]][line1[1]];
	    int[][] field2 = new int[line1[0]][line1[1]];
	    int seconds = line1[2];
        
        
	    String nextL;
	    for(int i = 0; i < field1.length; i++){
		nextL = inf.nextLine();
		for(int j = 0; j < field1[0].length; j++){
		    if(nextL.charAt(j) == '*' ){
			field1[i][j] = -1;
			field2[i][j] = -1;
		    }
		}
	    }
        
	    String[] lineLast = inf.nextLine().split(" ");
	    field1[Integer.parseInt(lineLast[0]) - 1][Integer.parseInt(lineLast[1]) - 1] = 1;
        
        
	    int[][] holder;
	    for(int i = 0; i < seconds; i++){
            
            
		for(int j = 0; j < field1.length; j++){
		    for(int k = 0; k < field1[0].length; k++){
			if(field1[j][k] != -1){
			    for(int l = 0; l < moves.length; l++){
				try{
				    int rowInc = moves[l][0];
				    int colInc = moves[l][1];
                            
				    if(field1[j + rowInc][k + colInc] != -1){
					field2[j + rowInc][k + colInc] += field1[j][k];
				    }
                            
				}catch(IndexOutOfBoundsException e){
                            
				}
                    
			    }
                    
			}
                    
                    
		    }
		}
            
            
            
		holder = field2;
		field2 = field1;
		field1 = holder;
            
            
            
		USACO.clear(field2);
            
            
	    }
        
        
	    //System.out.println("asdf");
	    int x = field1[Integer.parseInt(lineLast[2]) - 1][Integer.parseInt(lineLast[3]) - 1];
	    // System.out.println( "Hello + "+  x);
	    return x;
	    //System.out.println("asdasdf");
        }catch(FileNotFoundException e){
            
        }
        return -1;
        
    }
    
    
    public static void main(String[] args){
	//int x = USACO.silver("dataS.dat");
	//System.out.println(x);
	//System.out.println("asdf");
        System.out.println(USACO.silver("dataS.dat"));
    }
    
}
