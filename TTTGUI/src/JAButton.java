import javax.swing.*;

public class JAButton extends JButton {
    private TicTacToe.Action actionType;

    public JAButton(String text, TicTacToe.Action action) {
        super(text);
        this.actionType = action;
        this.addActionListener(actionListener);
    }

    public TicTacToe.Action getActionType() {
        return this.actionType;
    }


}
