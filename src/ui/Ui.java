package ui;

import data.Exporters;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julien on 10/26/15.
 */
public class Ui {

  private static final int WIDTH = 1200, HEIGHT = 1200;

  private JFrame frame = new JFrame();
  private GridLayout generalGridLayout = new GridLayout(1, 3), leftGridLayout = new GridLayout(20, 20), rightGridLayout = new GridLayout(5, 10);
  private JPanel leftPanel = new JPanel(new GridLayout(20, 20, 1, 5)), middlePanel = new JPanel(), rightPanel = new JPanel(new GridLayout(5, 10));
  private NestButton[][] leftCells = initCells(20, 20);
  private List<Exporters> exporters = new ArrayList<>();

  private NestButton[][] initCells(int width, int height) {
    NestButton[][] cells = new NestButton[width][height];
    for (int x = 0; x < cells.length; x++)
      for (int y = 0; y < cells[x].length; y++)
        cells[x][y] = new NestButton(y, cells.length - x);
    return cells;
  }

  public Ui() {
    createFrame();
    createLeftPanel();
    createMiddlePanel();
    frame.getContentPane().add(leftPanel);
    frame.getContentPane().add(middlePanel);
    frame.getContentPane().add(rightPanel);

    exporters.add(new Exporters() {});
  }

  private void createMiddlePanel() {
    JButton export = new JButton("Export");
    export.addActionListener(e -> exporters.forEach(exporter -> export(exporter)));
    middlePanel.add(export);
  }

  private void export(Exporters exporter) {
    exporter.export(leftCells);
  }

  private void createLeftPanel() {
    for (int x = 0; x < leftCells.length; x++)
      for (int y = 0; y < leftCells[x].length; y++)
        leftPanel.add(leftCells[x][y]);
    leftPanel.setBackground(Color.DARK_GRAY);
  }

  private void createFrame() {
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(generalGridLayout);
    frame.setVisible(true);
  }
}
