/**
 * Cell.java
 * by mostly Molly
 */


/**
 * Creates a cell object, the contents of a single cell in the Sudoku game. 
 */
public class Cell
{
  
  //instance variables
  private boolean isLocked;
  private int number;
  
    
  /*
   * Constructor for the Sudoku game.
   * Sets initial value to be nothing and has the cell unlocked
   */
  public Cell()
  {
    number = -1;
    isLocked = false;
  }
  
  /*
   * Locks the cell, used for pre-setting game values
   */
  public void lock()
  {
    isLocked = true;
  }
  
  /*
   * Getter method to check whether a cell isLocked()
   * @return boolean true is cell is locked, false otherwise.
   */
  public boolean getIsLocked()
  {
    return isLocked;
  }
  
  /*
   * Sets the value of the number in the cell
   * @param num the number we want to set that cell's value to
   */
  public void setNum(int num)
  {
    number = num;
  }
  
  /*
   * Gets the value of the number
   * @return int value of that cell
   */
  public int getNum()
  {
    return number;
  }
  
  /*
   * Prints out the cell to the console.
   * If the cell has no value, print a dash, indicating the cell is empty
   */
  public String toString()
  {
    String s="";
    if (number!=-1) s = String.valueOf(number);
    else s = "-";
   
    return s;
  }
                   
}