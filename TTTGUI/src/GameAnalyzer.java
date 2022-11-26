import java.util.ArrayList;

public class GameAnalyzer {

    private static char[][] getCharGrid(Grid board) {
        ArrayList<GridSpace> boardList = board.grid;
        GridSpace[][] currGrid = new GridSpace[][]{{boardList.get(0), boardList.get(1), boardList.get(2)},
                {boardList.get(3), boardList.get(4), boardList.get(5)}, {boardList.get(6), boardList.get(7), boardList.get(8)}};
        char[][] currGridChar = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                switch (currGrid[r][c].getCurrentState()) {
                    case EMPTY -> {
                        currGridChar[r][c] = ' ';
                    }
                    case X -> currGridChar[r][c] = 'X';
                    case O -> currGridChar[r][c] = 'O';
                }
            }
        }

        return currGridChar;
    }

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

    private static String getRow(Grid board, int row) {
        char[][] currCharGrid = getCharGrid(board);
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            rowStr.append(currCharGrid[row][i]);
        }
        return rowStr.toString();
    }

    private static String getColumn(Grid board, int col) {
        char[][] currCharGrid = getCharGrid(board);
        StringBuilder colStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            colStr.append(currCharGrid[i][col]);
        }
        return colStr.toString();
    }

    private static String getDiagonal1(Grid board) {
        char[][] currCharGrid = getCharGrid(board);
        StringBuilder diaStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            diaStr.append(currCharGrid[i][i]);
        }
        return diaStr.toString();
    }

    private static String getDiagonal2(Grid board) {
        char[][] currCharGrid = getCharGrid(board);
        StringBuilder diaStr = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            diaStr.append(currCharGrid[i][2 - i]);
        }
        return diaStr.toString();
    }

    private static String getRow(char[][] currCharGrid, int row) {
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            rowStr.append(currCharGrid[row][i]);
        }
        return rowStr.toString();
    }

    private static String getColumn(char[][] currCharGrid, int col) {
        StringBuilder colStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            colStr.append(currCharGrid[i][col]);
        }
        return colStr.toString();
    }

    private static String getDiagonal1(char[][] currCharGrid) {
        StringBuilder diaStr = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            diaStr.append(currCharGrid[i][i]);
        }
        return diaStr.toString();
    }

    private static String getDiagonal2(char[][] currCharGrid) {
        StringBuilder diaStr = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            diaStr.append(currCharGrid[i][2 - i]);
        }
        return diaStr.toString();
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

    public static int[] computerOffense(Grid board)
    {
        //returns smart move for offense AND the number of moves until that happens
        char[][] currCharGrid = getCharGrid(board);
        String[] allSpaces = new String[] {getRow(currCharGrid, 0), getRow(currCharGrid, 1),
                getRow(currCharGrid, 2), getColumn(currCharGrid, 0), getColumn(currCharGrid, 1),
                getColumn(currCharGrid, 2), getDiagonal1(currCharGrid), getDiagonal2(currCharGrid)};
        int[] movesAway = new int[8];
        int[] numEmpty = new int[8];
        int[] trueMovesAway = new int[8];
        int[] wiseMove = new int[2];
        if(TicTacToe.player1.isX()) {
            //checks to see how many O's are in each row, column, and diagonal and takes 3 minus that number
            for(int i = 0; i < 8; i++) {
                int moves = 3;
                for(int j = 0; j < 3; j++) {
                    if(allSpaces[i].charAt(j) == 'O') {
                        moves--;
                    }
                }
                movesAway[i] = moves;
            }
            //checks to see if there is an empty space in each row, column, and diagonal
            for(int i = 0; i < 8; i++) {
                if(movesAway[i] > 0) {
                    boolean hasEmpty = false;
                    for(int j = 0; j < 3; j++) {
                        if((allSpaces[i].charAt(j) != 'X') && (allSpaces[i].charAt(j) != 'O')) {
                            hasEmpty = true;
                            break;
                        }
                    }
                    if(!hasEmpty) {
                        numEmpty[i] = 0;
                    } else {
                        numEmpty[i] = movesAway[i];
                    }
                }
            }
            //checks to see if an X is already placed in each row, column, and diagonal
            for(int i = 0; i < 8; i++) {
                if(numEmpty[i] > 0) {
                    boolean blockMade = false;
                    for(int j = 0; j < 3; j++) {
                        if(allSpaces[i].charAt(j) == 'X') {
                            blockMade = true;
                            break;
                        }
                    }
                    if(blockMade) {
                        trueMovesAway[i] = 0;
                    } else {
                        trueMovesAway[i] = numEmpty[i];
                    }
                }
            }
            //determines the smallest number of moves to make to win and where to make that move (row, col, or diagonal)
            int min = 3;
            int minIndex = 0;
            boolean allZero = true;
            for(int i = 0; i < 8; i++) {
                if(trueMovesAway[i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if(!allZero) {
                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] <= 3)) {
                        minIndex = i;
                        break;
                    }
                }
                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] < min)) {
                        min = trueMovesAway[i];
                        minIndex = i;
                    }
                }
            } else {
                min = 0;
                minIndex = 0;
            }
            wiseMove[1] = min;
            wiseMove[0] = minIndex;
        } else { //same things but for opposite marks
            for(int i = 0; i < 8; i++) {
                int moves = 3;
                for(int j = 0; j < 3; j++) {
                    if(allSpaces[i].charAt(j) == 'X') {
                        moves--;
                    }
                }
                movesAway[i] = moves;
            }

            for(int i = 0; i < 8; i++) {
                if(movesAway[i] > 0) {
                    boolean hasEmpty = false;
                    for(int j = 0; j < 3; j++) {
                        if((allSpaces[i].charAt(j) != 'X') && (allSpaces[i].charAt(j) != 'O')) {
                            hasEmpty = true;
                            break;
                        }
                    }
                    if (!hasEmpty) {
                        numEmpty[i] = 0;
                    } else {
                        numEmpty[i] = movesAway[i];
                    }
                }
            }

            for(int i = 0; i < 8; i++) {
                if(numEmpty[i] > 0) {
                    boolean blockMade = false;
                    for(int j = 0; j < 3; j++) {
                        if(allSpaces[i].charAt(j) == 'O') {
                            blockMade = true;
                            break;
                        }
                    }
                    if(blockMade) {
                        trueMovesAway[i] = 0;
                    } else {
                        trueMovesAway[i] = numEmpty[i];
                    }
                }
            }
            //determines the smallest number of moves for the opponent to make to win and where to make they'd make that move (row, col, or diagonal)
            int min = 3;
            int minIndex = 0;
            boolean allZero = true;
            for(int i = 0; i < 8; i++) {
                if(trueMovesAway[i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if(!allZero) {
                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] <= 3)) {
                        minIndex = i;
                        break;
                    }
                }
                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] < min)) {
                        min = trueMovesAway[i];
                        minIndex = i;
                    }
                }
            } else {
                min = 0;
                minIndex = 0;
            }

            wiseMove[1] = min;
            wiseMove[0] = minIndex;
        }
        return wiseMove;
    }

    public int[] computerDefense(Grid board)
    {
        //returns smart move for defense AND the number of moves until that happens
        char[][] currCharGrid = getCharGrid(board);
        String[] allSpaces = new String[] {getRow(currCharGrid, 0), getRow(currCharGrid, 1),
                getRow(currCharGrid, 2), getColumn(currCharGrid, 0), getColumn(currCharGrid, 1),
                getColumn(currCharGrid, 2), getDiagonal1(currCharGrid), getDiagonal2(currCharGrid)};
        int[] movesAway = new int[8];
        int[] numEmpty = new int[8];
        int[] trueMovesAway = new int[8];
        int[] wiseMove = new int[2];
        if(TicTacToe.player1.isX()) {
            //checks to see how many X's are in each row, column, and diagonal and takes 3 minus that number
            for(int i = 0; i < 8; i++) {
                int moves = 3;
                for(int j = 0; j < 3; j++) {
                    if(allSpaces[i].charAt(j) == 'X') {
                        moves--;
                    }
                }
                movesAway[i] = moves;
            }
            //checks to see if there is an empty space in each row, column, and diagonal
            for(int i = 0; i < 8; i++) {
                if(movesAway[i] > 0) {
                    boolean hasEmpty = false;
                    for(int j = 0; j < 3; j++) {
                        if((allSpaces[i].charAt(j) != 'X') && (allSpaces[i].charAt(j) != 'O'))
                        {
                            hasEmpty = true;
                            break;
                        }
                    }
                    if(!hasEmpty) {
                        numEmpty[i] = 0;
                    } else {
                        numEmpty[i] = movesAway[i];
                    }
                }
            }
            //checks to see if an O is already placed in each row, column, and diagonal
            for(int i = 0; i < 8; i++) {
                if(numEmpty[i] > 0) {
                    boolean blockMade = false;
                    for(int j = 0; j < 3; j++) {
                        if(allSpaces[i].charAt(j) == 'O') {
                            blockMade = true;
                            break;
                        }
                    }
                    if(blockMade) {
                        trueMovesAway[i] = 0;
                    } else {
                        trueMovesAway[i] = numEmpty[i];
                    }
                }
            }
            //determines the smallest number of moves for the opponent to make to win and where to make they'd make that move (row, col, or diagonal)
            int min = 3;
            int minIndex = 0;
            boolean allZero = true;
            for(int i = 0; i < 8; i++) {
                if(trueMovesAway[i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if(!allZero) {
                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] <= 3)) {
                        minIndex = i;
                        break;
                    }
                }

                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] < min)) {
                        min = trueMovesAway[i];
                        minIndex = i;
                    }
                }
            } else {
                min = 0;
                minIndex = 0;
            }
            wiseMove[1] = min;
            wiseMove[0] = minIndex;
        } else { //same thing but checking for opposite marks
            for(int i = 0; i < 8; i++) {
                int moves = 3;
                for(int j = 0; j < 3; j++) {
                    if(allSpaces[i].charAt(j) == 'O') {
                        moves--;
                    }
                }
                movesAway[i] = moves;
            }

            for(int i = 0; i < 8; i++) {
                if(movesAway[i] > 0) {
                    boolean hasEmpty = false;
                    for(int j = 0; j < 3; j++) {
                        if((allSpaces[i].charAt(j) != 'X') && (allSpaces[i].charAt(j) != 'O')) {
                            hasEmpty = true;
                            break;
                        }
                    }
                    if(!hasEmpty) {
                        numEmpty[i] = 0;
                    } else {
                        numEmpty[i] = movesAway[i];
                    }
                }
            }

            for(int i = 0; i < 8; i++) {
                if (numEmpty[i] > 0) {
                    boolean blockMade = false;
                    for(int j = 0; j < 3; j++) {
                        if (allSpaces[i].charAt(j) == 'X') {
                            blockMade = true;
                            break;
                        }
                    }
                    if (blockMade) {
                        trueMovesAway[i] = 0;
                    } else {
                        trueMovesAway[i] = numEmpty[i];
                    }
                }
            }
            int min = 3;
            int minIndex = 0;
            boolean allZero = true;
            for(int i = 0; i < 8; i++) {
                if(trueMovesAway[i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if(!allZero) {
                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] <= 3)) {
                        minIndex = i;
                        break;
                    }
                }

                for(int i = 0; i < 8; i++) {
                    if((trueMovesAway[i] != 0) && (trueMovesAway[i] < min)) {
                        min = trueMovesAway[i];
                        minIndex = i;
                    }
                }
            } else {
                min = 0;
                minIndex = 0;
            }
            wiseMove[1] = min;       //how many moves away the opponent is from a win
            wiseMove[0] = minIndex;  //used to determine where to make the move (row, column, diagonal
        }
        return wiseMove;
    }
}
