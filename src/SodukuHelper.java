
public class SodukuHelper {

    String[] answer;

    public SodukuHelper() {

    }

    public void solve(char[][] board) {
        SudokuSolver solver = new SudokuSolver();
        boolean solvable = solver.solveSudoku(board);
        
    }

    public static void main(String[] args) {

    }

}
