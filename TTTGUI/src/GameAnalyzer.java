import java.util.ArrayList;

public class GameAnalyzer {

    public static boolean isDraw(Grid board) {
        boolean allSpacesTaken = true;
        ArrayList<GridSpace> boardList = board.grid;
        GridSpace[][] currGrid = new GridSpace[][]{{boardList.get(0), boardList.get(1), boardList.get(2)},
                {boardList.get(3), boardList.get(4), boardList.get(5)}, {boardList.get(6), boardList.get(7), boardList.get(8)}};
        char[][] currGridChar = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                switch (currGrid[r][c].getCurrentState()) {
                    case EMPTY -> {
                        currGridChar[r][c] = ' ';
                        allSpacesTaken = false;
                    }
                    case X -> currGridChar[r][c] = 'X';
                    case O -> currGridChar[r][c] = 'O';
                }
            }
        }

        return allSpacesTaken && !isWinO(board) && !isWinX(board);
    }

    public static boolean gameOver(Grid board) {
        return isWinO(board) || isWinX(board) || isDraw(board);
    }

    public static boolean isWinO(Grid board) {
        ArrayList<GridSpace> boardList = board.grid;
        GridSpace[][] currGrid = new GridSpace[][]{{boardList.get(0), boardList.get(1), boardList.get(2)},
                {boardList.get(3), boardList.get(4), boardList.get(5)}, {boardList.get(6), boardList.get(7), boardList.get(8)}};
        char[][] currGridChar = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                switch (currGrid[r][c].getCurrentState()) {
                    case EMPTY -> currGridChar[r][c] = ' ';
                    case X -> currGridChar[r][c] = 'X';
                    case O -> currGridChar[r][c] = 'O';
                }
            }
        }

        if ((currGridChar[0][0] == 'O') && (currGridChar[0][0] == currGridChar[0][1]) && (currGridChar[0][0] == currGridChar[0][2])) {
            return true;
        } else if ((currGridChar[1][0] == 'O') && (currGridChar[1][0] == currGridChar[1][1]) && (currGridChar[1][0] == currGridChar[1][2])) {
            return true;
        } else if ((currGridChar[2][0] == 'O') && (currGridChar[2][0] == currGridChar[2][1]) && (currGridChar[2][0] == currGridChar[2][2])) {
            return true;
        } else if ((currGridChar[0][0] == 'O') && (currGridChar[0][0] == currGridChar[1][0]) && (currGridChar[0][0] == currGridChar[2][0])) {
            return true;
        } else if ((currGridChar[0][1] == 'O') && (currGridChar[0][1] == currGridChar[1][1]) && (currGridChar[0][1] == currGridChar[2][1])) {
            return true;
        } else if ((currGridChar[0][2] == 'O') && (currGridChar[0][2] == currGridChar[1][2]) && (currGridChar[0][2] == currGridChar[2][2])) {
            return true;
        } else if ((currGridChar[0][0] == 'O') && (currGridChar[0][0] == currGridChar[1][1]) && (currGridChar[0][0] == currGridChar[2][2])) {
            return true;
        } else if ((currGridChar[2][0] == 'O') && (currGridChar[2][0] == currGridChar[1][1]) && (currGridChar[2][0] == currGridChar[0][2])) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWinX(Grid board) {
        ArrayList<GridSpace> boardList = board.grid;
        GridSpace[][] currGrid = new GridSpace[][]{{boardList.get(0), boardList.get(1), boardList.get(2)},
                {boardList.get(3), boardList.get(4), boardList.get(5)}, {boardList.get(6), boardList.get(7), boardList.get(8)}};
        char[][] currGridChar = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                switch (currGrid[r][c].getCurrentState()) {
                    case EMPTY -> currGridChar[r][c] = ' ';
                    case X -> currGridChar[r][c] = 'X';
                    case O -> currGridChar[r][c] = 'O';
                }
            }
        }

        if ((currGridChar[0][0] == 'X') && (currGridChar[0][0] == currGridChar[0][1]) && (currGridChar[0][0] == currGridChar[0][2])) {
            return true;
        } else if ((currGridChar[1][0] == 'X') && (currGridChar[1][0] == currGridChar[1][1]) && (currGridChar[1][0] == currGridChar[1][2])) {
            return true;
        } else if ((currGridChar[2][0] == 'X') && (currGridChar[2][0] == currGridChar[2][1]) && (currGridChar[2][0] == currGridChar[2][2])) {
            return true;
        } else if ((currGridChar[0][0] == 'X') && (currGridChar[0][0] == currGridChar[1][0]) && (currGridChar[0][0] == currGridChar[2][0])) {
            return true;
        } else if ((currGridChar[0][1] == 'X') && (currGridChar[0][1] == currGridChar[1][1]) && (currGridChar[0][1] == currGridChar[2][1])) {
            return true;
        } else if ((currGridChar[0][2] == 'X') && (currGridChar[0][2] == currGridChar[1][2]) && (currGridChar[0][2] == currGridChar[2][2])) {
            return true;
        } else if ((currGridChar[0][0] == 'X') && (currGridChar[0][0] == currGridChar[1][1]) && (currGridChar[0][0] == currGridChar[2][2])) {
            return true;
        } else if ((currGridChar[2][0] == 'X') && (currGridChar[2][0] == currGridChar[1][1]) && (currGridChar[2][0] == currGridChar[0][2])) {
            return true;
        } else {
            return false;
        }
    }
}
