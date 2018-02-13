public class KnightBoard{

    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];

    }


    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == 0){
		    ans += " _";
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

    private boolean knightMove(int row, int col){
	int[][] coords = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1} {2, 1}, {-2, 1}, {-2, -1}};  
    }
    
    

    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3, 2);
      
	//System.out.println(a);
	
    }

}
