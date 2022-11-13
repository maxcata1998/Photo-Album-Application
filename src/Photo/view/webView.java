package Photo.view;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Photo.model.IAlbum;
import Photo.model.IShape;
import Photo.model.ShapeName;
import Photo.model.Snapshot;

/**
 * The type Web view.
 */
public class webView {
  private IAlbum model;
  private String source;
  private String test = "";

  /**
   * Instantiates a new Web view.
   *
   * @param model  the model
   * @param source the source
   * @throws IOException the io exception
   */
  public webView(IAlbum model, String source) throws IOException {
    this.model = model;
    this.source = source;
    File out = new File(source);

    try {
      BufferedWriter htmlWriter = new BufferedWriter(new FileWriter(out));
      htmlWriter.write("<html><body>");
      for (Snapshot s : this.model.getSnapshots()) {
        htmlWriter.write(
                "<div style=\"border: rgb(165,42,42) 5px solid;background-color: rgb(255,192,203)\">");
        htmlWriter.write("<h1>" + s.getID() + "</h1>");
        htmlWriter.write("<p>" + "Description:" + s.getDescription() + "</p >");
        htmlWriter.write("<svg width=\"1000\" height=\"1000\">");
        for (IShape i : s.getShape()) {
          if (i.getType().equals(ShapeName.oval)) {
            String t = "<ellipse id=\""
                    + i.getName()
                    + "\" cx=\""
                    + i.getX()
                    + "\" cy=\""
                    + i.getY()
                    + "\" rx=\""
                    + i.getWidth()
                    + "\" ry=\""
                    + i.getHeight()
                    + "\" fill=\"rgb("
                    + i.getColorR() + "," + i.getColorG() + "," + i.getColorB() + ")"
                    + "\" visibility=\"visible\"></ellipse>";
            htmlWriter.write(t);
            test += t;
          } else {
            String t = "<rect id=\""
                    + i.getName()
                    + "\" x=\""
                    + i.getX()
                    + "\" y=\""
                    + i.getY()
                    + "\" width=\""
                    + i.getWidth()
                    + "\" height=\""
                    + i.getHeight()
                    + "\" fill=\"rgb("
                    + i.getColorR() + "," + i.getColorG() + "," + i.getColorB() + ")"
                    + "\" visibility=\"visible\"></rect>";
            htmlWriter.write(t);
            test += t;
          }
        }
        htmlWriter.write("</svg>\n" + "</div>");
        htmlWriter.write("<p>" + "</p>");
      }
      htmlWriter.write("</body></html>");
      htmlWriter.close();
      Desktop.getDesktop().browse(out.toURI());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String toString() {
    return test;
  }
}





