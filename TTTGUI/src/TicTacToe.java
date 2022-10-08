import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class TicTacToe {
    public static boolean player1Turn;

    public static Player player1;

    public static Player player2;

    public enum Action {
        ChangeGridSpace, Restart, GameConfig, ChangeGameMode
    }

    public static void main(String[] args) {
        int gameMode = -1;
        while (true) {
            int chooseGameMode = showStartMenu();
            if ((chooseGameMode == 0 && configPVP()) || (chooseGameMode == 1 && configPVComp()) ||
                    (chooseGameMode == 2 && configCompVComp())) {
                gameMode = chooseGameMode;
                break;
            } else if (chooseGameMode == -1) {
                return;
            }
        }
        switch (gameMode) {
            case 0:
                gamePVP();
            case 1:
                gamePVComp();
            case 2:
                gameCompVComp();
        }
    }

    public static boolean configPVP() {
        String player1Name = JOptionPane.showInputDialog(null, "Enter Player 1's Name.", JOptionPane.QUESTION_MESSAGE);
        if (player1Name == null) return false;

        String[] markOptions = { "X", "O" };
        boolean player1IsX;
        int player1Mark = JOptionPane.showOptionDialog(null, "Choose Player 1's Mark.", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, markOptions, markOptions[0]);
        if (player1Mark == 0) {
            player1IsX = true;
        } else if (player1Mark == 1) {
            player1IsX = false;
        } else {
            return false;
        }

        String player2Name = JOptionPane.showInputDialog(null, "Enter Player 2's Name.", JOptionPane.QUESTION_MESSAGE);
        if (player1Name == null) return false;

        boolean player2IsX = !player1IsX;

        String[] startOptions = { "Player 1", "Player 2" };
        boolean player1Starts;
        int startingPlayer = JOptionPane.showOptionDialog(null, "Choose Player 1's Mark.", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, startOptions, startOptions[0]);
        if (startingPlayer == 0) {
            player1Starts = true;
        } else if (startingPlayer == 1) {
            player1Starts = false;
        } else {
            return false;
        }

        boolean player2Starts = !player1Starts;

        player1 = new Player(player1Name, false, player1IsX, player1Starts);
        player2 = new Player(player2Name, false, player2IsX, player2Starts);
        
        return true;
    }

    public static boolean configPVComp() {

    }

    public static boolean configCompVComp() {

    }

    public static void gamePVP() {
    }

    public static void gamePVComp() {
    }

    public static void gameCompVComp() {
    }
    public static int showStartMenu() {
        String[] options = {"Player vs. Player", "Player vs. Computer", "Computer vs. Computer Simulation"};
        int result = JOptionPane.showOptionDialog(null, "Choose what game mode do you want " +
                        "to play in?", "TTT Start Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return result;
    }

}
