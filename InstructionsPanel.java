// Instructions Panel.java
// by mostly Dee
// Instructions from http://www.sudoku.name/rules/en

import java.awt.*;
import javax.swing.*;
import javax.swing.JApplet;
import javax.swing.JLabel;

/*
 * Opening Panel. Gives instruction about how to play the Sudoku game
 */
public class InstructionsPanel extends JPanel{
  
  /*
   * Constructor for the InstructionsPanel
   */
  public InstructionsPanel(){
    
    //use BoxLayOut to keep things easy to organize
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    //add JLabels for different parts of instructions
    JLabel space = new JLabel(" ");
    JLabel space0 = new JLabel(" ");
    JLabel space1 = new JLabel(" ");
    JLabel space2 = new JLabel(" ");
    JLabel space3 = new JLabel(" ");
    JLabel space4 = new JLabel(" ");
    JLabel text0 = new JLabel("                                                      Welcome!");
    JLabel text1 = new JLabel("  Sudoku is played over a 9x9 grid, divided to 3x3 sub grids called regions.");
    JLabel text2a = new JLabel("  Sudoku begins with some of the grid cells already filled with numbers.");
    JLabel text2b = new JLabel("  The object of Sudoku is to fill the other empty cells with numbers between 1 and 9 according the following guidelines:");
    JLabel text3 = new JLabel("         1. Each number can appear only once on each row ");
    JLabel text4 = new JLabel("         2. Each number can appear only once on each column");
    JLabel text5 = new JLabel("         3. Each number can appear only once on each region");
    JLabel text6 = new JLabel("                                                                 -----------------------------------");
    JLabel text7 = new JLabel("                                                      Good Luck!");
    
    //change some of the fonts
    text0.setFont(new Font("Serif", Font.BOLD, 24));
    text7.setFont(new Font("Serif", Font.BOLD, 22));
    
    //add labels in order they should appear
    add(space);
    add(text0);
    add(space0);
    add(text1);
    add(space1);
    add(text2a);
    add(space2);
    add(text2b);
    add(text3);
    add(text4);
    add(text5);
    add(space3);
    add(text6);
    add(space4);
    add(text7);
    
  }
 
}