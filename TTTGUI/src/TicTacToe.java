import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class TicTacToe {

    public static JFrame game;
    public static JPanel header;
    public static JLabel message;
    public static Grid board;
    public static Player player1;
    public static Player player2;

    public static boolean isPlayer1Turn;

    private static final Font titleFont = new Font("Arial", 1, 20);
    private static final Font subTitleFont = new Font("Arial", 1, 15);
    private static final Font bodyFont = new Font("Arial", 1, 11);
    private static final EmptyBorder padding = new EmptyBorder(10, 10, 10, 10);

    public enum Action {
        ChangeGridSpace, Restart, ChangeGameConfig, ChangeGameMode, Quit
    }

    public static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof GridSpace) {
                GridSpace gridButton = (GridSpace) e.getSource();
                int gridIdentifier = gridButton.getIdentifier();
                Action gridButtonAction = gridButton.getActionType();
                if (gridButtonAction == Action.ChangeGridSpace) {
                    String currMark = "";
                    if (isPlayer1Turn) {
                        if (player1.isX()) currMark = "X";
                        else currMark = "O";
                    } else {
                        if (player2.isX()) currMark = "X";
                        else currMark = "O";
                    }
                    GridSpace.State newState = GridSpace.State.EMPTY;
                    if (currMark.equals("X")) {
                        newState = GridSpace.State.X;
                    } else {
                        newState = GridSpace.State.O;
                    }

                    if (gridButton.getCurrentState() == GridSpace.State.EMPTY) {
                        gridButton.setCurrentState(newState);
                        gridButton.setText(currMark);
                        board.updateGrid(gridIdentifier, gridButton);
                    }
                    isPlayer1Turn = !isPlayer1Turn;

                    if (isPlayer1Turn) {
                        message.setText("It's " + player1.getName() + "'s turn.");
                    } else {
                        message.setText("It's " + player2.getName() + "'s turn.");
                    }

                    header.removeAll();
                    header.add(message);
                    game.add(header, BorderLayout.NORTH);



                }
            } else if (e.getSource() instanceof JAButton) {
                JAButton button = (JAButton) e.getSource();
                Action buttonAction = button.getActionType();
                if (buttonAction == Action.Restart) {
                    // reset player scores
                    board.resetGrid();
                } else if (buttonAction == Action.Quit) {
                    game.dispatchEvent(new WindowEvent(game, WindowEvent.WINDOW_CLOSING));
                }
            }
        }
    };

    public static void main(String[] args) {
        int gameMode = -1;
        while (true) {
            int chooseGameMode = showStartMenu();
            if ((chooseGameMode == 2 && configPVP()) || (chooseGameMode == 1 && configPVComp()) ||
                    (chooseGameMode == 0 && configCompVComp())) {
                gameMode = chooseGameMode;
                break;
            } else if (chooseGameMode == -1) {
                return;
            }
        }
        switch (gameMode) {
            case 2:
                gamePVP();
            case 1:
                gamePVComp();
            case 0:
                gameCompVComp();
        }
    }

    public static boolean configPVP() {
        String player1Name = JOptionPane.showInputDialog(null, "Enter Player 1's Name.", JOptionPane.QUESTION_MESSAGE);
        if (player1Name == null) return false;

        String[] markOptions = { "O", "X" };
        boolean player1IsX;
        int player1Mark = JOptionPane.showOptionDialog(null, "Choose Player 1's Mark.", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, markOptions, null);
        if (player1Mark == 1) {
            player1IsX = true;
        } else if (player1Mark == 0) {
            player1IsX = false;
        } else {
            return false;
        }

        String player2Name = JOptionPane.showInputDialog(null, "Enter Player 2's Name.", JOptionPane.QUESTION_MESSAGE);
        if (player1Name == null) return false;

        String[] startOptions = { "Player 2", "Player 1" };
        boolean player1Starts;
        int startingPlayer = JOptionPane.showOptionDialog(null, "Which Player Goes First?", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, startOptions, null);
        if (startingPlayer == 0) {
            player1Starts = false;
        } else if (startingPlayer == 1) {
            player1Starts = true;
        } else {
            return false;
        }
        isPlayer1Turn = player1Starts;
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
        isPlayer1Turn = player1Starts;
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
        game = new JFrame();
        Container content = game.getContentPane();
        content.setLayout(new BorderLayout());

        header = new JPanel();
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
        board.setPreferredSize(new Dimension(300,300));
        board.setMaximumSize(new Dimension(300,300));
        content.add(board, BorderLayout.CENTER);

        JPanel player1Stats = new JPanel(new GridLayout(0,1));
        JLabel player1Name = new JLabel(player1.getName());
        JLabel player1Wins = new JLabel(player1.getNumWins() + " Wins");
        JLabel player1Losses = new JLabel(player1.getNumLosses() + " Losses");
        JLabel player1Draws = new JLabel(player1.getNumDraws() + " Draws");
        player1Name.setFont(titleFont);
        player1Wins.setFont(titleFont);
        player1Losses.setFont(titleFont);
        player1Draws.setFont(titleFont);
        player1Stats.add(player1Name);
        player1Stats.add(player1Wins);
        player1Stats.add(player1Losses);
        player1Stats.add(player1Draws);
        player1Stats.setAlignmentX(Component.LEFT_ALIGNMENT);
        player1Stats.setBorder(padding);
        player1Stats.setPreferredSize(new Dimension(150, 300));
        player1Stats.setMaximumSize(new Dimension(150, 300));

        JPanel player2Stats = new JPanel(new GridLayout(0,1));
        JLabel player2Name = new JLabel(player2.getName());
        JLabel player2Wins = new JLabel(player2.getNumWins() + " Wins");
        JLabel player2Losses = new JLabel(player2.getNumLosses() + " Losses");
        JLabel player2Draws = new JLabel(player2.getNumDraws() + " Draws");
        player2Name.setFont(titleFont);
        player2Wins.setFont(titleFont);
        player2Losses.setFont(titleFont);
        player2Draws.setFont(titleFont);
        player2Stats.add(player2Name);
        player2Stats.add(player2Wins);
        player2Stats.add(player2Losses);
        player2Stats.add(player2Draws);
        player2Stats.setAlignmentX(Component.LEFT_ALIGNMENT);
        player2Stats.setBorder(padding);
        player2Stats.setPreferredSize(new Dimension(150, 300));
        player2Stats.setMaximumSize(new Dimension(150, 300));

        content.add(player1Stats, BorderLayout.WEST);
        content.add(player2Stats, BorderLayout.EAST);

        game.setTitle("PVP TicTacToe");
        game.setSize(900, 700);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    public static void gamePVComp() {
        game = new JFrame();
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
        board.setPreferredSize(new Dimension(300,300));
        board.setMaximumSize(new Dimension(300,300));
        content.add(board, BorderLayout.CENTER);

        JPanel player1Stats = new JPanel(new GridLayout(0,1));
        JLabel player1Name = new JLabel(player1.getName());
        JLabel player1Wins = new JLabel(player1.getNumWins() + " Wins");
        JLabel player1Losses = new JLabel(player1.getNumLosses() + " Losses");
        JLabel player1Draws = new JLabel(player1.getNumDraws() + " Draws");
        player1Name.setFont(titleFont);
        player1Wins.setFont(titleFont);
        player1Losses.setFont(titleFont);
        player1Draws.setFont(titleFont);
        player1Stats.add(player1Name);
        player1Stats.add(player1Wins);
        player1Stats.add(player1Losses);
        player1Stats.add(player1Draws);
        player1Stats.setAlignmentX(Component.LEFT_ALIGNMENT);
        player1Stats.setBorder(padding);
        player1Stats.setPreferredSize(new Dimension(150, 300));
        player1Stats.setMaximumSize(new Dimension(150, 300));

        JPanel player2Stats = new JPanel(new GridLayout(0,1));
        JLabel player2Name = new JLabel(player2.getName());
        JLabel player2Wins = new JLabel(player2.getNumWins() + " Wins");
        JLabel player2Losses = new JLabel(player2.getNumLosses() + " Losses");
        JLabel player2Draws = new JLabel(player2.getNumDraws() + " Draws");
        player2Name.setFont(titleFont);
        player2Wins.setFont(titleFont);
        player2Losses.setFont(titleFont);
        player2Draws.setFont(titleFont);
        player2Stats.add(player2Name);
        player2Stats.add(player2Wins);
        player2Stats.add(player2Losses);
        player2Stats.add(player2Draws);
        player2Stats.setAlignmentX(Component.LEFT_ALIGNMENT);
        player2Stats.setBorder(padding);
        player2Stats.setPreferredSize(new Dimension(150, 300));
        player2Stats.setMaximumSize(new Dimension(150, 300));

        content.add(player1Stats, BorderLayout.WEST);
        content.add(player2Stats, BorderLayout.EAST);

        game.setTitle("PVP TicTacToe");
        game.setSize(900, 700);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    public static void gameCompVComp() {
    }
    public static int showStartMenu() {
        String[] options = {"Computer vs. Computer Simulation", "Player vs. Computer", "Player vs. Player"};
        int result = JOptionPane.showOptionDialog(null, "Choose what game mode do you want " +
                        "to play in?", "TTT Start Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, null);
        return result;
    }

}
