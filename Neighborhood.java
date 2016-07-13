/**
 * Neighborhood.java
 * by mostly Molly
 * A "neighborhood" object represents the 3x3 square so crucial in Sudoku
 * It is a queue that can be used to check the values of a specific 3x3
 */

import javafoundations.*;

public class Neighborhood
{
  //instance variable
  private ArrayQueue<Integer> neighbors;
  
  /*
   * Constructor, creates an empty queue
   */
  public Neighborhood()
  {
    neighbors = new ArrayQueue<Integer>();
  }
  
  /*  Adds a value to the queue
   *  @param i the integer to be added
   */
  public void add(int i)
  {
    neighbors.enqueue(i);
  }
  
  /*
   * Removes the front of the neighbors queue
   * @return Integer the removed integer
   */
  public Integer remove()
  {
    return neighbors.dequeue();
  }
  
  /*
   * Removes a specific interger from the neighborhood
   * @param i the int to take out
   */
  public void takeOut(int i)
  {
    for (int k=neighbors.size();k>0;k--)
    {
      int j = neighbors.dequeue();
      if (j==i) break;
      else neighbors.enqueue(j);
      
    }
  }
  
  /*
   * Returns the size of the neighborhood queue
   * @return int the size of neighbors
   */
  public int size()
  {
    return neighbors.size();
  }
  
  /* 
   * Checks the contents of the queue in order to determine if an integer has already been added
   * @param i the integer to check if already there
   * @return boolean of whether or not integer is already present
   */
  public boolean checkIn(int i)
  {
    ArrayQueue<Integer> temp = new ArrayQueue<Integer>();
    boolean isIn = false;
    
    for (int j=neighbors.size();j>0;j--)
    {
      if (neighbors.first()==i) isIn = true;
      temp.enqueue(neighbors.dequeue());
    }
    
    neighbors = temp;
    return isIn;
  }
  
  /*
   * Returns the string representation of the board to the interactions console
   * @return String the representation of the board
   */
  public String toString()
  {
    String s = "";
    for (int j=neighbors.size();j>0;j--)
    {
      Integer i = neighbors.dequeue();
      s+=i+",";
      neighbors.enqueue(i);
    }
    return s;
  }
  
  //main method for testing
  public static void main(String[] args)
  {
    Neighborhood n = new Neighborhood();
    n.add(5);
    n.add(6);
    n.takeOut(6);
    System.out.println(n);
    
  }
    
}