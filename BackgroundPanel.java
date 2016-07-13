/**
 * BackgroundPanel.java
 * by mostly Dee
 * Sets a new background
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates a panel containing the Sudoku background image.
 * <p>
 * This allows the Sudoky game (numbers) to lay on top of the Sudoku grid. 
 */

public class BackgroundPanel extends JPanel{
  //get the new image background
  Image background = new ImageIcon("template1.jpg").getImage();
  @Override
  /*
   * Overrides the paintComponent method with a new background image
   * @param g the Graphics component
   */
    public void paintComponent(Graphics g){
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
  }
}
