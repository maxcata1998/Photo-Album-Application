package Photo.model;

public interface IShape {

  String getName();
  ShapeName getType();
  int getX();
  int getY();
  int getColorR();
  int getColorG();
  int getColorB();
  int getWidth();
  int getHeight();

  void setWidth(int newWidth);
  void setHeight(int newHeight);
  void setColorR(int newColorR);
  void setColorG(int newColorG);
  void setColorB(int newColorB);
  void setColor(int r, int g, int b);
  void setPosition(int x, int y);
  public IShape Clone();

}

