package Photo.model;

import java.util.ArrayList;
import java.util.HashMap;

public class AlbumSystem implements IAlbum {
  private static AlbumSystem instance = new AlbumSystem();

  public AlbumSystem() {
  }
  //Store the ID as a list
  public ArrayList<String> snapshotIDs = new ArrayList<>();
  public ArrayList<String> shapeName = new ArrayList<>();
  //Store all the shape as map
  public HashMap<String, IShape> canvas = new HashMap<>();
  //Store all snapshots as a list
  public ArrayList<Snapshot> snapshotClasses = new ArrayList<>();

  public static AlbumSystem getInstance() {
    return instance;
  }

  public void createShape(String name, ShapeName type, int x, int y, int width, int height,
                          int colorR, int colorG, int colorB) throws IllegalArgumentException {
    if (name == null || name == "" || width < 0 || height < 0 || colorR < 0 || colorG < 0
            || colorB < 0 || colorR >= 256 || colorG >= 256 || colorB >= 256) {
      throw new IllegalArgumentException();
    }
    if (type.equals(ShapeName.oval)) {
      canvas.put(name, new Oval(name, type, x, y, width, height, colorR, colorG, colorB));
      shapeName.add(name);
    }
    if (type.equals(ShapeName.rectangle)) {
      canvas.put(name, new Rectangle(name, type, x, y, width, height, colorR, colorG, colorB));
      shapeName.add(name);
    }
  }

  public void remove(String name) throws IllegalArgumentException {
    if (!canvas.containsKey(name)) {
      throw new IllegalArgumentException();
    }
    canvas.remove(name);
    shapeName.remove(name);
  }

  public void changeWidth(String name, int newWidth) throws IllegalArgumentException {
    if (!canvas.containsKey(name)) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setWidth(newWidth);
  }

  public void changeHeight(String name, int newHeight) throws IllegalArgumentException {
    if (!canvas.containsKey(name)) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setHeight(newHeight);
  }

  public void changeColorR(String name, int newColorR) throws IllegalArgumentException {
    if (!canvas.containsKey(name) || newColorR < 0 || newColorR >= 256) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setColorR(newColorR);
  }

  public void changeColorG(String name, int newColorG) throws IllegalArgumentException {
    if (!canvas.containsKey(name) || newColorG < 0 || newColorG >= 256) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setColorG(newColorG);
  }

  public void changeColorB(String name, int newColorB) throws IllegalArgumentException {
    if (!canvas.containsKey(name) || newColorB < 0 || newColorB >= 256) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setColorB(newColorB);
  }

  public void changeColor(String name, int r, int g, int b){
    if (!canvas.containsKey(name) || g < 0 || g >= 256 || b < 0 || b >= 256 ||r < 0 || r >= 256
    ) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setColor(r, g, b);
  }

  public void resize(String name, int width, int height){
    if (!canvas.containsKey(name)) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setWidth(width);
    canvas.get(name).setHeight(height);
  }


  public void setPosition(String name, int x1, int y1) throws IllegalArgumentException {
    if (!canvas.containsKey(name)) {
      throw new IllegalArgumentException();
    }
    canvas.get(name).setPosition(x1, y1);
  }

  public HashMap<String, IShape> getCanvas() {
    return canvas;
  }

  public void reset() {
    canvas.clear();
  }

  public void takeSnapshot(String description){
    Snapshot newSnapshot = new Snapshot(canvas, shapeName,description);
    snapshotClasses.add(newSnapshot);
    snapshotIDs.add(newSnapshot.ID);

  }

  public ArrayList<String> getSnapshotIDs(){
    return snapshotIDs;
  }

  public String toString() {
    String printListID = "List of snapshots taken before reset: " + snapshotIDs;
    String snapshotsDetails = "";
    for (int i = 0; i < snapshotClasses.size(); i++) {
      snapshotsDetails += snapshotClasses.get(i).toString();
    }
    return printListID + snapshotsDetails;
  }

  public ArrayList<Snapshot> getSnapshots(){
    return snapshotClasses;
  }
}

