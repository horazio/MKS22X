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

    private boolean knightMove(int row, int col, int current){
        int[][] coords = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, 1}, {-2, -1}};
	if(current == board.length * board[0].length){
	    return true;
	}
        for(int i = 0; i < coords.length; i ++){
            try{
		board[row + coords[i][0]][col + coords[i][1]] = current;
		knightMove(row + coords[i][0], col + coords[i][1], current + 1);
	        board[row + coords[i][0]][col + coords[i][1]] = 0;
            }catch(IndexOutOfBoundsException e){
	    }   
        }
	return false;
    }
    
    
    

    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3, 3);
	System.out.println(a.knightMove(2, 2, 0));
	//System.out.println(a);
	
    }

}
