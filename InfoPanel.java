// InfoPanel
// by mostly Dee

import java.awt.*;
import javax.swing.*;
import javax.swing.JApplet;
import javax.swing.JLabel;

/*
 * Provides basic information about the game
 * Who made the game, when, cites where we got rules from
 */
public class InfoPanel extends JPanel{
  
  /*
   * Constructor for the InfoPanel.
   */
  public InfoPanel(){
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    //create labels
    JLabel space0 = new JLabel(" ");
    JLabel space1 = new JLabel(" ");
    JLabel authors = new JLabel("  Created by Molly Hoch and Dee van der Knaap");
    JLabel updated = new JLabel("  Last updated on May 9th, 2016");
    JLabel space2 = new JLabel(" ");
    JLabel rules = new JLabel("  Rules from: http://www.sudoku.name/rules/en");
    
    //add labels
    add(space0);
    add(authors);
    add(space1);
    add(updated);
    add(space2);
    add(rules);
    
  }
  
}