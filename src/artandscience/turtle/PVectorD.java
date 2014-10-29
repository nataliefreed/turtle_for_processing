package artandscience.turtle;

import processing.core.PVector;

public class PVectorD {

	/** 
	 * Mini PVectorD Class Storage for Doubles (v1.01)
	 * by GoToLoop (2013/Aug)
	 * 
	 * http://forum.processing.org/topic/can-pvector-work-with-doubles
	 */

	  public double x, y, z;

	  public PVectorD(double xx, double yy) {
	    set(xx, yy);
	  }

	  public PVectorD(double xx, double yy, double zz) {
	    set(xx, yy, zz);
	  }

	  public PVectorD(PVectorD p) {
	    set(p);
	  }

	  private void clear() {
	    x = y = z = 0;
	  }

	  private void set(double xx, double yy) {
	    x = xx;
	    y = yy;
	  }

	  private void set(double xx, double yy, double zz) {
	    x = xx;
	    y = yy;
	    z = zz;
	  }

	  private void set(PVectorD p) {
	    x = p.x;
	    y = p.y;
	    z = p.z;
	  }
	  
	  private PVectorD get() {
	    return new PVectorD(x, y, z);
	  }

	  private PVector toPVector() {
	    return new PVector((float) x, (float) y, (float) z);
	  }

	  private double[] toArray() {
	    return new double[] {
	      x, y, z
	    };
	  }

	  public String toString() {
	    return "[ " + x + ", " + y + ", " + z + " ]";
	  }

}
