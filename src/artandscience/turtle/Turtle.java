package artandscience.turtle;

import processing.core.*;

public class Turtle implements PConstants
{
  private PApplet parent;
  private PVectorD loc; //current location
  private float orientation; //current orientation
  private int penColor;
  private boolean showSprite;
  private PGraphics graphicsScreen;
  private PGraphics spriteScreen;
  private boolean penDown;

  public Turtle(float x, float y, float startAngle, PApplet parent) 
  {
	this.parent = parent;
    loc = new PVectorD(x, y);
    orientation = startAngle;
    graphicsScreen = parent. createGraphics(parent.width, parent.height); //will need to pass in PApplet to get size
    spriteScreen = parent.createGraphics(parent.width, parent.height);
    this.showSprite = true;
    graphicsScreen.noFill();
    graphicsScreen.noStroke();
    penDown = true;
  }

  public void penUp()
  {
    penDown = false;
    graphicsScreen.noStroke();
  }

  public void penDown()
  {
    penDown = true;
  }

  public void setPenColor(float r, float g, float b)
  {
    penColor = parent.color(r, g, b);
  }

  public void show()
  {
    showSprite = true;
  }

  public void hide()
  {
    showSprite = false;
  }

  private  void drawSprite()
  {
    spriteScreen.clear();
    spriteScreen.beginDraw();
    spriteScreen.imageMode(CENTER);
    spriteScreen.pushMatrix();
    spriteScreen.translate((float)loc.x, (float)loc.y);
    spriteScreen.rotate(-parent.radians(orientation));
    spriteScreen.fill(255);
    spriteScreen.noStroke();
    spriteScreen.ellipse(0, 0, 20, 20);
    spriteScreen.fill(100);
    spriteScreen.triangle(-5, 5, -5, -5, 8, 0);
    spriteScreen.popMatrix();
    spriteScreen.endDraw();
    parent.image(spriteScreen, 0, 0);
  }

  public void forward(float pixels) //calculate positions when moving forward
  { 
    PVectorD start = loc;
    PVectorD end = add(loc, polar(pixels, parent.radians(orientation)));
    vecLine(start, end);
    loc = end;
    if (showSprite) drawSprite();
    parent.image(graphicsScreen, 0, 0);
  }

  public float getX()
  {
    return (float) loc.x;
  }

  public float getY()
  {
    return (float) loc.y;
  }

  public void setDirectionTo(float angle)
  {
    orientation = angle;
  }

  public void left(float theta) //calculate new orientation
  {
    orientation += theta;
    if (showSprite) drawSprite();
  }

  public void right(float theta)  //calculate new orientation
  {
    orientation -= theta;
    if (showSprite) drawSprite();
  }

  public void jumpTo(int x, int y) //jump directly to a specific position
  {
    PVectorD end = new PVectorD(x, y);
    vecLine(loc, end);
    loc = end;
  }

  private void vecLine(PVectorD a, PVectorD b) //new line function with PVectors. used by forward function
  {
    graphicsScreen.beginDraw();
    if (penDown)
    {
      graphicsScreen.stroke(penColor);
    }
    graphicsScreen.line((float)a.x, (float)a.y, (float)b.x, (float)b.y);
    graphicsScreen.endDraw();
  }

  private PVectorD polar(double r, double theta) //converts an angle and radius into a vector
  {
    return new PVectorD(r* java.lang.Math.cos(theta), r* java.lang.Math.sin(-theta)); // negate y for left handed coordinate system
  }
  
  private PVectorD add(PVectorD a, PVectorD b)
  {
    return new PVectorD(a.x + b.x, a.y + b.y, a.z + b.z);
  }
}


