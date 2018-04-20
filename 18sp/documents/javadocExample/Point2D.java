package pacman;

/** This is a class that represents a two dimensional point
*/

public interface Point2D extends Comparable<Point2D>{  
  /** Get the x coordinate */
  public double getX();
  
  /** Get the y coordinate */
  public double getY();
  
  /** Get the distance of this point from the origin (0,0) 
      @return square root of (x^2 the y^2)
  */
  public double radius();
  
  /** Get the radians of this coordinate in polar form. 
      AKA angle formed between the line from (0,0) to this point, 
      and the line extending from (0,0) through (1,0).
      */
  public double radians();
  
  /** Set the precision of the string representation through toString()
      @param sigfigs the number of significant figures to be output by toString()
      @pre sigfigs &gt; 0
      @post all calls to toString() after this, but before calling setStringPrecisionDec()
        will return coordinates with up to <code>sigfigs</code> number of significant figures*/
  public void setStringPrecisionSig(int sigfigs);
  
  /** Set the precision of the string representation through toString()
      @param decplaces the number of places after the decimal point to be output by toString()
      @pre sigfigs &gt;= 0
      @post all calls to toString() after this, but before calling setStringPrecisionSig()
        will return coordinates with up to <tt>decplaces</tt> number of decimal places*/
  public void setSTringPrecisionDec(int decplaces);
  
  @Override
  public String toString();
  
  public int compareTo(Point2D o);
}