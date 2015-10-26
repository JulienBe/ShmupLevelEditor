package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julien on 10/26/15.
 */
public class Ui {

  private static final int WIDTH = 1200, HEIGHT = 1200;

  private JFrame frame = new JFrame();
  private GridLayout generalGridLayout = new GridLayout(1, 3), leftGridLayout = new GridLayout(20, 20), rightGridLayout = new GridLayout(5, 10);
  private JPanel leftPanel = new JPanel(new GridLayout(20, 20, 1, 5)), middlePanel = new JPanel(), rightPanel = new JPanel(new GridLayout(5, 10));
  private Component[][] leftCells = initCells(20, 20);

  private Component[][] initCells(int width, int height) {
    Component[][] cells = new JButton[width][height];
    for (int x = 0; x < cells.length; x++) {
      for (int y = 0; y < cells[x].length; y++) {
        cells[x][y] = nestRepresentation();
        leftPanel.add(cells[x][y]);
      }
    }
    return cells;
  }

  private Component nestRepresentation() {
    JButton jButton = new JButton();
    jButton.setBackground(Color.BLACK);
    jButton.addActionListener(e -> jButton.setBackground(Color.cyan));
    return jButton;
  }

  public Ui() {
    createFrame();

    leftPanel.setBackground(Color.DARK_GRAY);
    frame.getContentPane().add(leftPanel);
    frame.getContentPane().add(middlePanel);
    frame.getContentPane().add(rightPanel);
  }

  private void createFrame() {
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(generalGridLayout);
    frame.setVisible(true);
  }
}
