// Lab29ast.java
// This is the student version of the Lab29a assignment.
// Completing this file, as is, is the 100 point version.  
// For 80 points you will be given the <getMove> code.


import java.util.*;


public class lab29a
{
	public static void main(String args[])
	{
		System.out.println("\nLab 29a 80/100 Point Version\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter random starting seed  ===>>  ");
		int seed = input.nextInt();

		Maze maze = new Maze(seed);
		maze.displayMaze();
		maze.solveMaze();
		maze.displayMaze();
		maze.mazeSolution();
	}
}


class Maze
{

	private char mat[][];				// 2d character array that stores the maze display
	private Coord currentMove;		// object that stores current maze position
	private Stack<Coord> possMovesHash = new Stack<>();
	class Coord
			// Coord is a class that stores a single maze location.
	{
		private int rPos;
		private int cPos;
		public Coord (int r, int c) 		{ rPos = r; cPos = c; }

	}


	public Maze(int seed)
	// constructor which generates the random maze, random starting location
	// and initializes Maze class values.  If the random value equals 0 the maze
	// store an 'X' otherwise it store an 'O' in the maze.
	{
		Random random = new Random(seed);
		int startRow, startCol;
		mat = new char[12][12];
		for (int r = 0; r < 12; r++)
			for (int c = 0; c < 12; c++)
			{
				if (r == 0 || c == 0 || r == 11 || c == 11)
					mat[r][c] = 'X';
				else
				{
					int rndInt = random.nextInt(2);
					if (rndInt == 0)
						mat[r][c] = 'X';
					else
						mat[r][c] = 'O';
				}
			}
		mat[0][0] = 'O';
		startRow = random.nextInt(12);
		startCol = 11;
		mat[startRow][startCol] = '.';

		currentMove = new Coord(startRow,startCol);

	}


	void displayMaze()
	// displays the current maze configuration
	{
		System.out.println("\nRANDOM MAZE DISPLAY\n");
		for (int r = 0; r < 12; r++)
		{
			for (int c = 0; c < 12; c++)
				if(mat[r][c]=='O'){
					final String ANSI_BLACK = "\u001B[30m";
					final String ANSI_RESET = "\u001B[0m";
					System.out.print(ANSI_BLACK+mat[r][c] + " "+ANSI_RESET);
				}else if(mat[r][c]=='X'){
					final String ANSI_RED = "\u001B[31m";
					final String ANSI_RESET = "\u001B[0m";
					System.out.print(ANSI_RED + mat[r][c] +" "+ ANSI_RESET);
				}else{
					final String ANSI_GREEN = "\u001B[32m";
					final String ANSI_RESET = "\u001B[0m";
					System.out.print(ANSI_GREEN + mat[r][c] +" "+  ANSI_RESET);
				}


			System.out.println();
		}
		System.out.println();
		pause();

	}


	public void solveMaze()
	// This methods solves the maze with private helper method <getMove>.
	// A loop is needed to repeat getting new moves until either a maze solution
	// is found or it is determined that there is no way out off the maze.
	{
		System.out.println("\n>>>>>   WORKING  ....  SOLVING MAZE   <<<<<\n");
			while(mat[0][0]!='.' && getMove()){

			}
				while(!possMovesHash.isEmpty()){
					currentMove= possMovesHash.pop();
					while(getMove()){

					}
				}
	}


	public void mazeSolution()
	// Short method to display the result of the maze solution
	{
		if (mat[0][0]=='.')
			System.out.println("\nTHE MAZE HAS A SOLUTION.\n");
		else
			System.out.println("\nTHE MAZE HAS NO SOLUTION.\n");
	}


	private boolean inBounds(int r, int c)
	// This method determines if a coordinate position is inbounds or not
	{
		if(r<0 || r>= mat.length|| c<0 ||c>=mat[0].length){
			return false;
		}else if(mat[r][c]!='O'){
			return false;
		}else{
			return true;
		}
	}


	private boolean getMove()
	// This method checks eight possible positions in a counter-clock wise manner
	// starting with the (-1,0) position.  If a position is found the method returns
	// true and the currentMove coordinates are altered to the new position
	{
		Stack<Coord> possMoves = new Stack<>();
		mat[currentMove.rPos][currentMove.cPos]='.';
		if(inBounds(currentMove.rPos,currentMove.cPos-1)){

			possMoves.add(new Coord(currentMove.rPos,currentMove.cPos-1));

		}
		if(inBounds(currentMove.rPos+1,currentMove.cPos-1)){
			possMoves.add(new Coord(currentMove.rPos+1,currentMove.cPos-1));

		}
		if(inBounds(currentMove.rPos+1,currentMove.cPos)){
			possMoves.add(new Coord(currentMove.rPos+1,currentMove.cPos));

		}
		if(inBounds(currentMove.rPos+1,currentMove.cPos+1)){
			possMoves.add(new Coord(currentMove.rPos+1,currentMove.cPos+1));

		}
		if(inBounds(currentMove.rPos,currentMove.cPos+1)){
			possMoves.add(new Coord(currentMove.rPos,currentMove.cPos+1));

		}
		if(inBounds(currentMove.rPos-1,currentMove.cPos+1)){
			possMoves.add(new Coord(currentMove.rPos-1,currentMove.cPos+1));

		}
		if(inBounds(currentMove.rPos-1,currentMove.cPos)){
			possMoves.add(new Coord(currentMove.rPos-1,currentMove.cPos));

		}
		if(inBounds(currentMove.rPos-1,currentMove.cPos-1)){
			possMoves.add(new Coord(currentMove.rPos-1,currentMove.cPos-1));

		}
		if(possMoves.isEmpty()){
			return false;
		}
		currentMove= possMoves.pop();
		Stack <Coord >temp  = new Stack<>();
		while(!possMoves.isEmpty()){
			temp.push(possMoves.pop());
		}
		while(!temp.isEmpty()){
			possMovesHash.push(temp.pop());
		}
		return true;
	}

	private void pause()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nPress <Enter> to continue  ===>>  ");
		input.nextLine();
	}



}
