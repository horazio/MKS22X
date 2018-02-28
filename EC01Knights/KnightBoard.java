public class KnightBoard{

    private int[][] board;
    private int count;

    public KnightBoard(int startingRows, int startingCols){
        if(startingRows < 0 || startingCols < 0){
            throw new IllegalArgumentException();
        }
        board = new int[startingRows][startingCols];
    }
    
    
    public boolean isClear(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public String toString(){
        String ans = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 0){
                    ans += "_ ";
                }else if(board[r][c] < 10){
                    ans += " " + board[r][c] + " ";
                }else{
                    ans += board[r][c] + " ";
                }
            }   
            ans += "\n";
        }
        return ans;
    }
    
    
    private int[][] nextSpot(int row, int col){
        int rIncrement = 0;
        int cIncrement = 0;
        //int[][] newCoords = new int[8][2];
        if(row < board.length / 2){
            
            if(col < board[0].length / 2){
                int[][] newCoords = {{-2, -1}, {-1, -2}, {-1, 2}, {-2, 1}, {2, -1}, {1, -2}, {2, 1}, {1, 2}};
                return newCoords;
            }
            //int[][] = n
            int[][] newCoords = {{-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}, {2, 1}, {1, 2}, {2, -1}, {1, -2}};
              return newCoords;
        }else{
            if(col < board[0].length / 2){
        
                int[][] newCoords = {{2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {-2, 1}, {-1, 2}};
                return newCoords;
            }

            int[][] newCoords = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-2, -1}, {-1, -2}};
            return newCoords;
        }
        
    }
    
    
    

    public boolean solveFast(int row, int col){
        if(this.isClear()){
            if(!(row >= 0 && col >= 0 && row < board.length && col < board[0].length)){
                throw new IllegalArgumentException();
            }
            if(solver(row, col, 1)){
                return true;
            }else{
                board = new int[board.length][board[0].length];
                return false;
            }
        }else{
            throw new IllegalStateException();
        }
    }
    
    private boolean solver(int row, int col, int current){
        int[][] coords = nextSpot(row, col);
        if(current == board.length * board[0].length){
            count++;
            board[row][col] = current;
            //System.out.println(this);
            //System.out.println(count);
            return true;
        }
        for(int i = 0; i < coords.length; i ++){
            try{
                int rowAt = row + coords[i][0];
                int colAt = col + coords[i][1];
                if(board[rowAt][colAt] == 0){
                    board[row][col] = current;
                    //System.out.println(this);
                    if(solver(rowAt, colAt, current + 1)){
                        return true;
                    }               
                    board[rowAt][colAt] = 0;
                }
            }catch(IndexOutOfBoundsException e){
	    }   
        }
      
        return false;
    }
    
    
    
    
    
    
    
    
    public int countSolutions(int row, int col){
        if(this.isClear()){
            if(!(row >= 0 && col >= 0 && row < board.length && col < board[0].length)){
                throw new IllegalArgumentException();
            }
            this.knightMove(row, col, 1);
            int holder = count;
            count = 0;
            board = new int[board.length][board[0].length];
            return holder;
        }else{
            throw new IllegalStateException();
        }  
    }
    
    
    private boolean knightMove(int row, int col, int current){
        int[][] coords = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, 1}, {-2, -1}};
        if(current == board.length * board[0].length){
            count++;
            board[row][col] = current;
            //System.out.println(this);
            //System.out.println(count);
            return true;
        }
        for(int i = 0; i < coords.length; i ++){
            try{
                int rowAt = row + coords[i][0];
                int colAt = col + coords[i][1];
                if(board[rowAt][colAt] == 0){
                    board[row][col] = current;
                    //System.out.println(this);
                    knightMove(rowAt, colAt, current + 1);               
                    board[rowAt][colAt] = 0;
                }
            }catch(IndexOutOfBoundsException e){
	    }   
        }
        return false;
    }
    
    
    
    
    
    
    // 5 by 5 at 0 0 is 304, 5 by 5 all countSol 1728

    public static void main(String[] args){
        KnightBoard a = new KnightBoard(7,7);
        a.solveFast(0,0);
        System.out.println(a);
        
    }

}


