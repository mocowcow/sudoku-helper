
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
        if (answer != null && ansIdx < answer.length) {
            System.out.println(answer[ansIdx++]);
        } else {
            System.out.println("no hint available!");
        }

    }

    public static void main(String[] args) {
        char[][] test = new char[][]{
            {'7', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        SodukuHelper helper = new SodukuHelper();
        helper.solve(test);
        for (int i = 0; i < 10; i++) {
            helper.getHint();
        }
    }

}
