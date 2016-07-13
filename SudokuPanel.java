/** 
 * SudokuPanel.java
 * by mostly Dee
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javafoundations.*;

public class SudokuPanel extends JPanel {
  //instance vars
  private JLabel[][] squareLabels;
  private JButton quitButton, makeButton;
  private JLabel colLabel,rowLabel,ansLabel;
  private JComboBox colBox,rowBox,ansBox;
  
  private JPanel top, grid;
  
  private Sudoku game; 
  
  private ArrayQueue<String> games;
  
  
  /*
   * Constructor for the Sudoku Panel
   * Note how it takes an instance of the game as input!
   * @param g the specified pre-created Sudoku game
   */
  public SudokuPanel(Sudoku g) {
    
    //create queue of games
    games = new ArrayQueue<String>();
    games.enqueue("game1.txt");
    games.enqueue("game2.txt");
    games.enqueue("game3.txt");
    games.enqueue("game4.txt");
    games.enqueue("game5.txt");
    games.enqueue("game6.txt");
    games.enqueue("game7.txt");
    games.enqueue("game8.txt");
    games.enqueue("game9.txt");
    games.enqueue("game10.txt");

    this.game = g;
    
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(375,300));
    
    //integers 1-9 associated with the game of Sudoku
    Integer[] numbers = {1,2,3,4,5,6,7,8,9};
    
    //create elements that allow user to change the value of an empty cell
    top = new JPanel();
    top.setLayout (new BoxLayout (top, BoxLayout.X_AXIS));
    colLabel = new JLabel("Column:");
    colBox = new JComboBox(numbers);
    rowLabel = new JLabel("Row:");
    rowBox = new JComboBox(numbers);
    ansLabel = new JLabel("Answer:");
    ansBox = new JComboBox(numbers);
    
    //add these elements
    top.add(rowLabel);
    top.add(rowBox);
    top.add(colLabel);
    top.add(colBox);
    top.add(ansLabel);
    top.add(ansBox);
     
    //button that realizes what the user has indicated suing the drop down menus to change value of cell
    makeButton = new JButton("Make a Move");
    makeButton.addActionListener(new ButtonListener());
    top.add(makeButton);
    
    add(top, BorderLayout.NORTH);
    
    grid = new BackgroundPanel();
    grid.setLayout(new GridLayout(9,9));
    
    
    squareLabels = new JLabel[9][9];
    //set the cells
    //either fill with pre-determined value or set to empty
    for (int i=0; i<9; i++) {
      for (int j=0; j<9; j++) {
        Cell c = g.grabCell(i,j);
        int num = c.getNum();
        if (num==-1) squareLabels[i][j] = new JLabel("            "); //funky spaces to make it look pretty on the background
        else squareLabels[i][j] = new JLabel("         "+Integer.toString(num));
            
        
        // add each label to the Panel
        grid.add(squareLabels[i][j]);

      }//end of "j" for loop
    } //end of "i" for looop

    grid.setPreferredSize(new Dimension(250,200));
    add(grid, BorderLayout.CENTER);
    
    //create a button to allow the user to quit seamlessly
    quitButton = new JButton("Quit...");
    quitButton.addActionListener(new ButtonListener());
    add(quitButton, BorderLayout.SOUTH);

  }
  
  /**
   * ButtonListener is a private class for responding to button push events 
   */ 
  private class ButtonListener implements ActionListener {
    
    /** Quits the game if quit button is pushed, changes the text of the buttons of the game to X or O
      * Updates the status label and icon images of the panel when the game is over
      * @param event is the event which causes an action to be performed
      **/
    public void actionPerformed (ActionEvent event) {
      //quit button was pressed
      if (event.getSource() == quitButton) System.exit(0); 
      
      //make button was pressed
      if (event.getSource() == makeButton) 
      {
        int row = rowBox.getSelectedIndex();
        
        int column = colBox.getSelectedIndex();
       
        int value = ansBox.getSelectedIndex();
      
        
        game.setCell(value+1,row+1,column+1);
        
        if(game.grabCell(row, column).getIsLocked() == false) squareLabels[row][column].setText("         "+ Integer.toString(value+1));
        //if cell is already pre-set, show pop-up error message
        else JOptionPane.showMessageDialog(grid, "You cannot change a pre-set value!", "Initial Value Error", JOptionPane.ERROR_MESSAGE);
      
      
      if(game.isGameOver() == true)
      {
        int reply = JOptionPane.showConfirmDialog(grid, "Great Job! Would you like to play another game?", "Again?", JOptionPane.YES_NO_CANCEL_OPTION);
        if(reply == JOptionPane.YES_OPTION)
        {

         String s = games.dequeue();

         games.enqueue(s);
          
          //fill new game with new file
          Sudoku sud = new Sudoku();
          sud.fillFromFile(s);
          sud.printArray();
          game = sud;
          game.printArray();
          for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
              Cell c = game.grabCell(i,j);
              int num = c.getNum();
              if (num==-1) squareLabels[i][j].setText("            "); //funky spaces to make it look pretty on the background
              else squareLabels[i][j].setText("         "+Integer.toString(num));
            }
          }

            }
            else if (reply == JOptionPane.CANCEL_OPTION) System.exit(0);
            
          }
          
      }
    
    } //end actionPerformed
    
    
  } // end of buttonListener inner class
  
}