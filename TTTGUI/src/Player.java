public class Player {
    private String name;
    private boolean isComputer;
    private boolean isX;
    private boolean starts;
    private int numWins;
    private int numDraws;
    private int numLosses;

    public Player(String name, boolean isComputer, boolean isX, boolean starts) {
        this.name = name;
        this.isComputer = isComputer;
        this.isX = isX;
        this.starts = starts;
        this.numWins = 0;
        this.numDraws = 0;
        this.numLosses = 0;
    }

    public boolean starts() {
        return starts;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String result = name + "\nWins-Losses-Draws = " + numWins + "-" + numLosses + "-" + numDraws;
        return result;
    }
}
