import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class TicTacToe {

    public static Grid board;

    public static Player player1;

    public static Player player2;

    private static final Font titleFont = new Font("Arial", 1, 20);
    private static final Font subTitleFont = new Font("Arial", 1, 15);
    private static final EmptyBorder padding = new EmptyBorder(10, 10, 10, 10);

    public enum Action {
        ChangeGridSpace, Restart, ChangeGameConfig, ChangeGameMode, Quit
    }

    public static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

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

        String[] startOptions = { "Player 1", "Player 2" };
        boolean player1Starts;
        int startingPlayer = JOptionPane.showOptionDialog(null, "Which Player Goes First?", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, startOptions, startOptions[0]);
        if (startingPlayer == 0) {
            player1Starts = true;
        } else if (startingPlayer == 1) {
            player1Starts = false;
        } else {
            return false;
        }

        player1 = new Player(player1Name, false, player1IsX, player1Starts);
        player2 = new Player(player2Name, false, !player1IsX, !player1Starts);

        return true;
    }

    public static boolean configPVComp() {
        String player1Name = JOptionPane.showInputDialog(null, "Enter Player's Name.", JOptionPane.QUESTION_MESSAGE);
        if (player1Name == null) return false;

        String[] markOptions = { "X", "O" };
        boolean player1IsX;
        int player1Mark = JOptionPane.showOptionDialog(null, "Choose Player's Mark.", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, markOptions, markOptions[0]);
        if (player1Mark == 0) {
            player1IsX = true;
        } else if (player1Mark == 1) {
            player1IsX = false;
        } else {
            return false;
        }

        String[] startOptions = { "Player", "Computer" };
        boolean player1Starts;
        int startingPlayer = JOptionPane.showOptionDialog(null, "Which Player Goes First?", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, startOptions, startOptions[0]);
        if (startingPlayer == 0) {
            player1Starts = true;
        } else if (startingPlayer == 1) {
            player1Starts = false;
        } else {
            return false;
        }

        player1 = new Player(player1Name, false, player1IsX, player1Starts);
        player2 = new Player("Computer", true, !player1IsX, !player1Starts);

        return true;
    }

    public static boolean configCompVComp() {

        int coinFlip1 = (int)(Math.random() + 0.5);
        int coinFlip2 = (int)(Math.random() + 0.5);
        boolean computer1IsX;
        boolean computer1Starts;

        if (coinFlip1 == 0) {
            computer1IsX = true;
        } else {
            computer1IsX = false;
        }

        if (coinFlip2 == 0) {
            computer1Starts = true;
        } else {
            computer1Starts = false;
        }


        if (coinFlip1 == 0) {

        }


        player1 = new Player("Computer 1", true, computer1IsX, computer1Starts);
        player2 = new Player("Computer 2", true, !computer1IsX, !computer1Starts);

        return true;
    }

    public static void gamePVP() {
        JFrame game = new JFrame();
        Container content = game.getContentPane();
        content.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        JLabel message;

        if (player1.starts()) {
            message = new JLabel("It's " + player1.getName() + "'s turn.");
        } else {
            message = new JLabel("It's " + player2.getName() + "'s turn.");
        }
        message.setFont(titleFont);
        header.add(message);
        content.add(header, BorderLayout.NORTH);

        JAButton restart = new JAButton("Restart", Action.Restart);
        JAButton gameConfigChange = new JAButton("Change Game Configuration", Action.ChangeGameConfig);
        JAButton gameModeChange = new JAButton("Change Game Mode", Action.ChangeGameMode);
        JAButton quitGame = new JAButton("Quit", Action.Quit);
        restart.addActionListener(actionListener);
        gameConfigChange.addActionListener(actionListener);
        gameModeChange.addActionListener(actionListener);
        quitGame.addActionListener(actionListener);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(restart);
        buttonPanel.add(gameConfigChange);
        buttonPanel.add(gameModeChange);
        buttonPanel.add(quitGame);
        content.add(buttonPanel, BorderLayout.SOUTH);

        board = new Grid();
        content.add(board, BorderLayout.CENTER);

        JLabel player1Stats = new JLabel(player1.toString());
        player1Stats.setFont(subTitleFont);
        JLabel player2Stats = new JLabel(player2.toString());
        player2Stats.setFont(subTitleFont);

        content.add(player1Stats, BorderLayout.WEST);
        content.add(player2Stats, BorderLayout.EAST);

        game.setTitle("PVP Game");
        game.setSize(500, 500);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
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
