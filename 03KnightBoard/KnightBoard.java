public class KnightBoard{

    private int[][] board;
    private int count;

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
		    ans += " _ ";
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
            count++;
            System.out.println(this);
            System.out.println(count);
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
	KnightBoard a = new KnightBoard(5, 5);
	System.out.println(a.knightMove(1, 3, 1));
    System.out.println(a.count);
	//System.out.println(a);
	
    }

}
