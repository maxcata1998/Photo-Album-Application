package Photo.model;

import java.awt.*;

public class Rectangle extends AbstractShape{
  public Rectangle(String name, ShapeName type, int x, int y, int width, int height, int colorR, int colorG, int colorB) throws IllegalArgumentException {
    super(name, type, x, y, width, height, colorR, colorG, colorB);
  }

  public String toString(){
    return "Name: "+ super.getName() +"\nType: "+super.getType()+ "\nCenter: (" + super.getX() + ","
            + super.getY() + "), Width: " + super.getWidth() + ", Height: " + super.getHeight() +
            ", Color: (" + super.getColorR() + "," + super.getColorG() + "," + super.getColorB() + ")\n";
  }

  @Override
  public IShape Clone(){
    return new Rectangle(this.getName(),
            this.getType(),
            this.getX(),
            this.getY(),
            this.getWidth(),
            this.getHeight(),
            this.getColorR(),
            this.getColorG(),
            this.getColorB());
  }
}
