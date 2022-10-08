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
            GridSpace space = new GridSpace("", i);
            space.addActionListener(TicTacToe.actionListener);
            grid.add(space);
        }
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BorderLayout());
        JPanel topRow = new JPanel();
        topRow.setLayout(new BorderLayout());
        GridSpace topLeft = grid.get(0);
        topLeft.setSize(100, 100);
        topRow.add(topLeft, BorderLayout.WEST);
        GridSpace topCenter = grid.get(1);
        topCenter.setSize(100, 100);
        topRow.add(topCenter, BorderLayout.CENTER);
        GridSpace topRight = grid.get(2);
        topRight.setSize(100, 100);
        topRow.add(topRight, BorderLayout.EAST);
        topRow.setSize(300,100);

        JPanel middleRow = new JPanel();
        middleRow.setLayout(new BorderLayout());
        GridSpace middleLeft = grid.get(3);
        middleLeft.setSize(100, 100);
        middleRow.add(middleLeft, BorderLayout.WEST);
        GridSpace middleCenter = grid.get(4);
        middleCenter.setSize(100, 100);
        middleRow.add(middleCenter, BorderLayout.CENTER);
        GridSpace middleRight = grid.get(5);
        middleRight.setSize(100, 100);
        middleRow.add(middleRight, BorderLayout.EAST);
        middleRow.setSize(300,100);

        JPanel bottomRow = new JPanel();
        bottomRow.setLayout(new BorderLayout());
        GridSpace bottomLeft = grid.get(6);
        bottomLeft.setSize(100, 100);
        bottomRow.add(bottomLeft, BorderLayout.WEST);
        GridSpace bottomCenter = grid.get(7);
        bottomCenter.setSize(100, 100);
        bottomRow.add(bottomCenter, BorderLayout.CENTER);
        GridSpace bottomRight = grid.get(8);
        bottomRight.setSize(100, 100);
        bottomRow.add(bottomRight, BorderLayout.EAST);
        bottomRow.setSize(300,100);

        this.add(topRow, BorderLayout.NORTH);
        this.add(middleRow, BorderLayout.CENTER);
        this.add(bottomRow, BorderLayout.SOUTH);
        this.setSize(300,300);


        this.setVisible(true);

    }


}
