package ui;

import data.Nest;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julien on 10/27/15.
 */
public class NestButton extends JButton {
  public final Nest nest;

  public NestButton(int x, int y) {
    addActionListener(e -> click());
    setBackground(Color.BLACK);
    nest = new Nest(x, y);
  }

  public void click() {
    nest.click();
    if (nest.isActivated()) setBackground(Color.CYAN);
    else                    setBackground(Color.BLACK);
  }

  @Override
  public String toString() {
    return "NestButton{" +
            "nest=" + nest +
            '}';
  }
}
