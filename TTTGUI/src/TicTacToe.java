import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class TicTacToe {
    public static boolean player1Turn;

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
