import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grid extends JPanel {

    private ArrayList<GridSpace> grid;

    public Grid() {
        grid = new ArrayList<GridSpace>();
        for (int i = 0; i < 9; i++) {
            grid.add(new GridSpace(i));
        }
    }
}
