package Photo.model;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Snapshot {
  ArrayList<IShape> shapeSnapshot = new ArrayList<>();
  String description;
  String ID;
  String timestamp;

  public Snapshot(HashMap<String,IShape> shapeMap, ArrayList<String> shapeName, String description){
    this.description = description;
    LocalDateTime now = LocalDateTime.now();
    this.ID = now.toString();
    this.timestamp = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    for(int i=0; i<shapeName.size();i++){
      this.shapeSnapshot.add(shapeMap.get(shapeName.get(i)).Clone());
    }
  }

  public ArrayList<IShape> getShape(){
    return this.shapeSnapshot;
  }
  public String getID(){
    return this.ID;
  }
  public String getDescription(){
    return this.description;
  }



  public String ArrayListshape(){
    return String.valueOf(this.shapeSnapshot);
  }

  public String toString(){
    String shapeDetails = "";
    for( IShape i : shapeSnapshot){
      shapeDetails += i.toString();
    }
    return "\nSnapshot ID: " + this.ID + "\nTimestamp: "+ this.timestamp + "\nDescription: "
            + this.description +"\nShape Information: \n"+ shapeDetails;
  }
}
