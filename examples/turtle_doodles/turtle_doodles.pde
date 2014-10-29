import artandscience.turtle.*;

Turtle turtle;

void setup() {
  size(400,400);
  smooth();
  
  turtle = new Turtle(width/2, height/2, 90, this);
  
  background(255);
  
  turtle.hide();
  
}

void draw() {
  
  turtle.setPenColor(random(0, 255), 0, 255);
  line(0, 0, 100, 100);
  turtle.forward(100);
  turtle.left(random(0, 90));
}
