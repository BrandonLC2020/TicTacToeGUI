import javax.swing.*;

public class JAButton extends JButton {
    private TicTacToe.Action action;

    public JAButton(String text, TicTacToe.Action action) {
        super(text);
        this.action = action;
        this.addActionListener(actionListener);
    }


}
