

public class GridSpace extends JAButton {
    private final int identifier;
    private State currentState;
    public enum State {X, O, EMPTY};

    public GridSpace(String text, int identifier) {
        super(text, TicTacToe.Action.ChangeGridSpace);
        this.identifier = identifier;
        this.currentState = State.EMPTY;
    }

    public GridSpace(String text, int identifier, State state) {
        super(text, TicTacToe.Action.ChangeGridSpace);
        this.identifier = identifier;
        this.currentState = state;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
//        switch (state) {
//            case O:
//                this.setText("O");
//            case X:
//                this.setText("X");
//            case EMPTY:
//                this.setText(" ");
//            default:
//                this.setText(" ");
//        }
    }

    public TicTacToe.Action getActionType() {
        return super.getActionType();
    }
}
