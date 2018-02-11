public class QueenBoard{
    
    private int[][]board;
    
    private int count;
    
    public QueenBoard(int size){
        board = new int[size][size];
    }
    public boolean isEmpty(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean addQueen(int r, int c){
        if(board[r][c] == 0){
            addRem(r, c, 1);
            board[r][c] = -1;  
            return true;
        }
        return false;
    }

    
    private boolean removeQueen(int r, int c){
        if(board[r][c] == -1){
            addRem(r, c, -1);
            board[r][c] = 0;
            return true;
        }
        return false; 
    }

    public void addRem(int r, int c, int inc){
        int len = board.length;
        for(int i = 0; i < board[0].length; i++){
            board[r][i] += inc;
            board[i][c] += inc;
            if(r + i < len && c + i <len){
                board[r + i][c + i] += inc;
            }
            if(r + i < len && c - i >= 0){
                board[r + i][c - i] += inc;
            }
            if(c + i < len && r - i >= 0 ){
                board[r - i][c + i] += inc;
            }
            if(r - i >= 0 && c - i >= 0){
                board[r - i][c - i] += inc;
            }
        }       
    }

    
    public String toString(){
        String ans = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == -1){
                    ans += "Q ";
                }else{
                    ans += "_ ";
                }
            }
            ans += "\n";
        }
        return ans;
    }

    
    public boolean solve(){
        if(!this.isEmpty()){
            throw new IllegalStateException();
        }
        return solveHelp(0);
    }
    
    public boolean solveHelp(int rowAt){
        if(rowAt == board.length){
            return true;
        }
        for(int i = 0; i < board.length; i++ ){
            if (this.addQueen(rowAt, i)){                
                if(solveHelp(rowAt + 1)){
                    return true;
                }
                this.removeQueen(rowAt, i);
            }
        }
           return false;
    }
    
    
    public int countSolutions(){
        if(!this.isEmpty()){
            throw new IllegalStateException();
        }       
        solutionCounter(0);
        int holder = count;
        count = 0;
        return holder;
    }
    
    public boolean solutionCounter(int rowAt){
        if(rowAt == board.length){
            count++;
            //System.out.println(this);
            return true;
        }
        for(int i = 0; i < board.length; i++ ){
            if (this.addQueen(rowAt, i)){  
                solutionCounter(rowAt + 1);
                this.removeQueen(rowAt, i);
            }
        }
           return false;
    }
    
    public static void main(String[] args){
        QueenBoard A = new QueenBoard(10);
        
        System.out.println(A.countSolutions());
        System.out.println(A.solve());
        System.out.println(A);
    }
}
