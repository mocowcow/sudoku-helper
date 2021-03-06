
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedList;

class SudokuSolver {

    ArrayList<HashSet<Character>> row;
    ArrayList<HashSet<Character>> col;
    ArrayList<HashSet<Character>> block;
    LinkedList<int[]> toFill;
    char[][] board;
    Stack<String> answer;

    public SudokuSolver() {
        row = new ArrayList<>();
        col = new ArrayList<>();
        block = new ArrayList<>();
        toFill = new LinkedList<>();
        answer = new Stack<>();
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            block.add(new HashSet<>());
        }
    }

    // return true if matrix can be solve
    public boolean solveSudoku(char[][] board) {
        this.board = board;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') {
                    toFill.add(new int[]{r, c});
                } else {
                    add(r, c, val);
                }
            }
        }
        boolean solvable = solve(0);
        if (!solvable) {
            answer.clear();
        }
        return solvable;
    }

    private void add(int r, int c, char val) {
        row.get(r).add(val);
        col.get(c).add(val);
        block.get((r / 3) * 3 + (c / 3)).add(val);
    }

    private void pop(int r, int c, char val) {
        row.get(r).remove(val);
        col.get(c).remove(val);
        block.get((r / 3) * 3 + (c / 3)).remove(val);
    }

    private boolean isValid(int r, int c, char val) {
        return !(row.get(r).contains(val) || col.get(c).contains(val) || block.get((r / 3) * 3 + (c / 3)).contains(val));
    }

    private boolean solve(int idx) {
        if (idx == toFill.size()) {
            return true;
        } else {
            int[] co = toFill.get(idx);
            int r = co[0], c = co[1];
            for (char val = '1'; val <= '9'; val++) {
                if (isValid(r, c, val)) {
                    add(r, c, val);
                    board[r][c] = val;
                    answer.add(String.format("(%d,%d) = %c", r, c, val));
                    if (solve(idx + 1)) {
                        return true;
                    }
                    board[r][c] = '.';
                    answer.pop();
                    pop(r, c, val);
                }
            }
            return false;
        }
    }

    public String[] getAnwer() {
        if (answer.isEmpty()) {
            return null;
        }
        return answer.toArray(new String[answer.size()]);
    }
}
