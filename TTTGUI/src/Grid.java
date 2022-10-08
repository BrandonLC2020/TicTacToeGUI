import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grid extends JPanel {

    private ArrayList<GridSpace> grid;


    public Grid() {
        super();
        grid = new ArrayList<GridSpace>();
        for (int i = 0; i < 9; i++) {
            grid.add(new GridSpace("", i));
        }
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BorderLayout());
        JPanel topRow = new JPanel();
        topRow.setLayout(new BorderLayout());
        topRow.add(grid.get(0), BorderLayout.WEST);
        topRow.add(grid.get(1), BorderLayout.CENTER);
        topRow.add(grid.get(2), BorderLayout.EAST);
        JPanel middleRow = new JPanel();
        middleRow.setLayout(new BorderLayout());
        middleRow.add(grid.get(3), BorderLayout.WEST);
        middleRow.add(grid.get(4), BorderLayout.CENTER);
        middleRow.add(grid.get(5), BorderLayout.EAST);
        JPanel bottomRow = new JPanel();
        bottomRow.setLayout(new BorderLayout());
        bottomRow.add(grid.get(6), BorderLayout.WEST);
        bottomRow.add(grid.get(7), BorderLayout.CENTER);
        bottomRow.add(grid.get(8), BorderLayout.EAST);

        this.add(topRow, BorderLayout.NORTH);
        this.add(middleRow, BorderLayout.CENTER);
        this.add(bottomRow, BorderLayout.SOUTH);
    }


}
