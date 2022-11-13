import java.io.IOException;

import Photo.controller.controller;
import Photo.model.IAlbum;
import Photo.model.Reader;
import Photo.view.webView;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IllegalArgumentException the illegal argument exception
   * @throws IOException              the io exception
   */
  public static void main(String[] args) throws IllegalArgumentException, IOException {
    int height = 1000;
    int width = 1000;
    String input = "";
    String output = "";
    String view = "";

    for (int i = 0; i < args.length - 1; i++) {

      if (isNumeric(args[i])) {
        width = Integer.parseInt(args[i]);
        height = Integer.parseInt(args[i + 1]);
      }
      if (args[i].equals("-in")) {
        input = args[i + 1];
      }
      if (args[i].equals("-out")) {
        output = args[i + 1];
      }
      if (args[i].equals("-view") || args[i].equals("-v")) {
        view = args[i + 1];
      }
    }

    if (output == "" && view == "web") {
      throw new IllegalArgumentException("There is no output!");
    }

    Reader reader = new Reader(input);
    IAlbum model = reader.readFile();
    controller c = new controller(model, width, height);
    if (view.equalsIgnoreCase("web")) {
      webView w = new webView(model, output);
    }
  }

  private static boolean isNumeric(String str) {
    for (int i = 0; i < str.length(); i++) {
      System.out.println(str.charAt(i));
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }
    return true;
  }

}
