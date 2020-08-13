import java.util.Scanner;
import java.util.Stack;

public class Lab26b {
        public static void main (String args[])
        {
            System.out.println("\nLab26b 100 Point Version\n");
            Knight knight = new Knight();
            knight.getStart();
            knight.solveTour();
            knight.displayBoard();
        }
}


class Knight {
		private boolean[][] visited = new boolean[12][12];
        private int board[][];			// stores the sequence of knight moves
        private int startRow, startCol, row, col, moves;
        private int ACCESS[][] = {
	                                {0,0,0,0,0,0,0,0,0,0,0,0},
 						 			{0,0,0,0,0,0,0,0,0,0,0,0},
     					 			{0,0,2,3,4,4,4,4,3,2,0,0},
     					 			{0,0,3,4,6,6,6,6,4,3,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,3,4,6,6,6,6,4,3,0,0},
     					 			{0,0,2,3,4,4,4,4,3,2,0,0},
     					 			{0,0,0,0,0,0,0,0,0,0,0,0},
     					 			{0,0,0,0,0,0,0,0,0,0,0,0}
	    };

        // constructor used to initializes the data attributes
        public Knight() {
			this.moves = 1;
			board = new int[12][12];
        }

        public Knight(int startRow, int startCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.row = startRow;
            this.col = startCol;
        }

		// input method to get starting row and col from keyboard entry
        public void getStart() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter starting row ==> ");
            this.startRow = sc.nextInt()+1;
            System.out.print("Enter starting col ==> ");
            this.startCol = sc.nextInt()+1;
			this.row = startRow;
			this.col = startCol;
			System.out.printf("%d %d\n", startRow-1, startCol-1);
		}


        // displays the chessboard after the tour is concluded
        public void displayBoard() {
			for (int r = 2; r < board.length-2; r++) {
				for(int c = 2; c < board[r].length-2; c++) {
					System.out.printf("%02d ",board[r][c]);
				}
				System.out.println();
			}
			System.out.printf("The Knight made %d moves\n", moves-1);
		}

        // computes the next available knight's move.  Alters RowPos and ColPos and
        // returns true if move is possible, otherwise returns false
        private void move(int newCol, int newRow) {
			row = newRow;
			col = newCol;
			moves++;
			//System.out.printf("%d %d %d | ", newRow-1, newCol-1, moves);
        }


        public void solveTour() {// primary method that drives the knight's tour solution
			visited[startRow][startCol] = true;
			boolean canMove = true;
			while (canMove) {
				canMove = false;
				visited[row][col] = true;
				board[row][col] = moves;
				//System.out.println(moves);
				int moveX = 0, moveY = 0;
				int largest = 9;

				int dx = 2, dy = 1;
				if (ACCESS[row + dy][col + dx] != 0) {
                    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						//System.out.println(smallest);
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = 2;
				dy = -1;
				if (ACCESS[row + dy][col + dx] != 0) {
                    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = 1;
				dy = 2;
				if (ACCESS[row + dy][col + dx] != 0 ) {
                    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						//System.out.println(smallest);
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = 1;
				dy = -2;
				if (ACCESS[row + dy][col + dx] != 0) {
                    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						//System.out.println(largest);
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = -1;
				dy = 2;
				if (ACCESS[row + dy][col + dx] != 0) {
                    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						//System.out.println(smallest);
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = -1;
				dy = -2;
				if (ACCESS[row + dy][col + dx] != 0) {
					if (ACCESS[row + dy][col + dx] < largest&& !visited[row + dy][col + dx]) {
                        ACCESS[row + dy][col + dx]--;
						largest = ACCESS[row + dy][col + dx];
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = -2;
				dy = 1;
				if (ACCESS[row + dy][col + dx] != 0) {
                    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest  && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						//System.out.println(smallest);
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				dx = -2;
				dy = -1;
				if (ACCESS[row + dy][col + dx] != 0) {
				    ACCESS[row + dy][col + dx]--;
					if (ACCESS[row + dy][col + dx] < largest  && !visited[row + dy][col + dx]) {
						largest = ACCESS[row + dy][col + dx];
						moveX = col + dx;
						moveY = row + dy;
						canMove = true;
					}
				}
				if (canMove)
					move(moveX, moveY);

			}
		}


}