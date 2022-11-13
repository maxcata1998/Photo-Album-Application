package Photo.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Photo.model.IAlbum;
import Photo.model.IShape;
import Photo.model.ShapeName;

public class paint extends JPanel {

  protected ArrayList<IShape> shapes;

  public paint(ArrayList<IShape> shape) {
    this.setBackground(Color.blue);
    this.shapes = shape;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g.create();
    for (IShape s : this.shapes) {
      if (s.getType() == ShapeName.rectangle) {
        Color c = new Color(s.getColorR(), s.getColorG(),  s.getColorB());
        g2D.setColor(c);

        g2D.fillRect(s.getX(), s.getY(),s.getWidth(), s.getHeight());
      }
      else {
        Color c = new Color(s.getColorR(), s.getColorG(), (int) s.getColorB());
        g2D.setColor(c);
        g2D.fillOval((int) s.getX(), (int) s.getY(), (int) s.getWidth(), (int) s.getHeight());
      }
    }
    g2D.dispose();
  }

  public void setRepaint(ArrayList<IShape> shape){
    this.shapes = shape;
    repaint();
  }
}
