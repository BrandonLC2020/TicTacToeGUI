import javax.swing.*;
enum State {X, O, EMPTY};

public class GridSpace extends JButton {
    private int indentifer;
    private State currentState;
    public GridSpace(int indentifer) {
        this.indentifer = indentifer;
        this.currentState = State.EMPTY;
    }

    public GridSpace(int indentifer, State state) {
        this.indentifer = indentifer;
        this.currentState = state;
    }
    public int getIndentifer() {
        return this.indentifer;
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }
}
