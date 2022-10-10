import javax.swing.*;
enum State {X, O, EMPTY};

public class GridSpace extends JAButton {
    private int indentifer;
    private State currentState;
    public GridSpace(String text, int indentifer) {
        super(text, TicTacToe.Action.ChangeGridSpace);
        this.indentifer = indentifer;
        this.currentState = State.EMPTY;
    }

    public GridSpace(String text, int indentifer, State state) {
        super(text, TicTacToe.Action.ChangeGridSpace);
        this.indentifer = indentifer;
        this.currentState = state;
    }

    public int getIndentifer() {
        return this.indentifer;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
        switch (state) {
            case O:
                this.setText("O");
            case X:
                this.setText("X");
            case EMPTY:
                this.setText("");
            default:
                this.setText("");
        }
    }

    public TicTacToe.Action getActionType() {
        return this.action;
    }
}
