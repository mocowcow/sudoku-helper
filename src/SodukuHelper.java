
public class SodukuHelper {

    String[] answer;
    int ansIdx;

    public SodukuHelper() {

    }

    public void solve(char[][] board) {
        SudokuSolver solver = new SudokuSolver();
        boolean solvable = solver.solveSudoku(board);
        if (solvable) {
            System.out.println("solved!");
        } else {
            System.out.println("the matrix cant be solved!");
        }
        answer = solver.getAnwer();
        ansIdx = 0;
    }

    //get a hint for next step 
    public void getHint() {
        if (ansIdx < answer.length) {
            System.out.println(answer[ansIdx++]);
        } else {
            System.out.println("no hint available!");
        }

    }

    public static void main(String[] args) {

    }

}
