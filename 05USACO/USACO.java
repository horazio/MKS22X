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
            moves[i][0] = Integer.parseInt(nextL[0]);
            moves[i][1] = Integer.parseInt(nextL[1]);
            moves[i][2] = Integer.parseInt(nextL[2]);
            
        }
        
        
        
        //for(int i = 0; i < field.length; i++){
        //    for(int j = 0; j < field[0].length; j++){
        //        
        //        System.out.print(field[i][j]);
        //    }
        //    System.out.println();
        //}
        
        //System.out.println(depth);
        
        
        }catch(FileNotFoundException e){
            
        }
        
        
        
        return -1;
    }
    
    public static int silver(String filename){
        try{
        File text = new File(filename);
        Scanner inf = new Scanner(text);
        
        
        String[] lines = inf.nextLine().split(" ");
        int[] line1 = new int[3];
        for(int i = 0; i < lines.length; i++){
            line1[i] = Integer.parseInt(lines[i]);
        }
        
        
        int[][] field = new int[line1[0]][line1[1]];
        int seconds = line1[2];
        
        
        String[] nextL;
        for(int i = 0; i < field.length; i++){
            nextL = inf.nextLine().split(" ");
            for(int j = 0; j < field[0].length; j++){
                if(nextL[j].charAt(0) == '*' ){
                    field[i][j] = -1;
                }
            }
        }
        
        String[] lineLast = inf.nextLine().split(" ");
        field[Integer.parseInt(lineLast[0]) - 1][Integer.parseInt(lineLast[1]) - 1] = 'S';
        field[Integer.parseInt(lineLast[2]) - 1][Integer.parseInt(lineLast[3]) - 1] = 'e';
        
        
        for(int i = 0; i < seconds; i++){
            
            
            
            
            for(int j = 0; j < field.length; j++){
                for(int k = 0; k < field[0].length; k++){
                    
                    if(field[j][k] == )
                    
                }
            }
            
            
            
            
            
            
        }
        
        
        
        //for(int i = 0; i < field.length; i++){
        //    for(int j = 0; j < field[0].length; j++){
        //        
        //        System.out.print(field[i][j]);
        //    }
        //    System.out.println();
        //}
        
        //System.out.println(depth);
        
        
        }catch(FileNotFoundException e){
            
        }
        return -1;
        
    }
    
    
    public static void main(String[] args){
        USACO.bronze("data1.dat");
    }
    
}