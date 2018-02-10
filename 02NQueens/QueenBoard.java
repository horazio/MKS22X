public class QueenBoard{
    
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];

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
        int len = board[0].length;
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
		    ans += board[r][c] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    
    public boolean solve(){
        return solveHelp(0);
    }
    
    public boolean solveHelp( int rowAt){
        if(rowAt == board[0].length){
            return true;
        }
        for(int i = 0; i < board[0].length; i++ ){
            addQueen(rowAt, i);
            solveHelp(rowAt + 1);
            removeQueen(rowAt, i);
        }
           return false;
    }
    
    
    // public int countSolutions(){}


    public static void main(String[] args){
	QueenBoard A = new QueenBoard(4);
	A.addQueen(1, 3);
    System.out.println(A);
    A.addQueen(2, 1);
    System.out.println(A);
    A.removeQueen(1, 3);
	System.out.println(A);
    A.removeQueen(2, 1);
    System.out.println(A);

    }
}
