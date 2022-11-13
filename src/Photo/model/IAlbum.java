package Photo.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface IAlbum {
  void createShape(String name, ShapeName type, int x, int y, int width, int height, int colorR,
                   int colorG, int colorB);

  void remove(String name);
  void changeWidth(String name, int newWidth);
  void changeHeight(String name, int newHeight);
  void setPosition(String name, int x1, int y1);
  void changeColorR(String name, int newColorR);
  void changeColorG(String name, int newColorG);
  void changeColorB(String name, int newColorB);
  void changeColor(String name, int r, int g, int b);
  void resize(String name, int width, int height);
  HashMap<String, IShape> getCanvas();
  void takeSnapshot(String description);
  ArrayList<Snapshot> getSnapshots();
  ArrayList<String> getSnapshotIDs();


}
