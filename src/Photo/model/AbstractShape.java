package Photo.model;

import java.util.Objects;

public abstract class AbstractShape implements IShape {
  /**public String name;
  public double positionX;
  public double positionY;
  public double width;
  public double height;
  public ShapeName type;
  public double colorR;
  public double colorG;
  public double colorB;
**/
  protected String name;
  protected int positionX;
  protected int positionY;
  protected int width;
  protected int height;
  protected ShapeName type;
  protected int colorR;
  protected int colorG;
  protected int colorB;
  public AbstractShape(String name, ShapeName type, int x, int y,
                       int width, int height, int colorR, int colorG,
                       int colorB)
          throws IllegalArgumentException {
    if (name == null || name == "" || width < 0 || height < 0 || colorR < 0 || colorG < 0 || colorB < 0 || colorR >= 256
            || colorG >= 256 || colorB >= 256) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.type = type;
    this.positionX = x;
    this.positionY = y;
    this.width = width;
    this.height = height;
    this.colorR = colorR;
    this.colorG = colorG;
    this.colorB = colorB;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeName getType() {
    return this.type;
  }

  @Override
  public int getX() {
    return this.positionX;
  }

  @Override
  public int getY() {
    return this.positionY;
  }

  @Override
  public int getColorR() {
    return this.colorR;
  }

  @Override
  public int getColorG() {
    return this.colorG;
  }

  @Override
  public int getColorB() {
    return this.colorB;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public void setWidth(int newWidth) {
    this.width = newWidth;
  }

  @Override
  public void setHeight(int newHeight) {
    this.height = newHeight;
  }

  @Override
  public void setColorR(int newColorR) {
    this.colorR = newColorR;
  }

  @Override
  public void setColorG(int newColorG) {
    this.colorG = newColorG;
  }

  @Override
  public void setColorB(int newColorB) {
    this.colorB = newColorB;
  }

  @Override
  public void setPosition(int x1, int y1) {
    this.positionX = x1;
    this.positionY = y1;
  }

  @Override
  public void setColor(int r, int g, int b) {
    this.colorR = r;
    this.colorG = g;
    this.colorB =b;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return Double.compare(that.positionX, positionX) == 0 && Double.compare(that.positionY, positionY) == 0 && Double.compare(that.width, width) == 0 && Double.compare(that.height, height) == 0 && Double.compare(that.colorR, colorR) == 0 && Double.compare(that.colorG, colorG) == 0 && Double.compare(that.colorB, colorB) == 0 && Objects.equals(name, that.name) && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, positionX, positionY, width, height, type, colorR, colorG, colorB);
  }
}
