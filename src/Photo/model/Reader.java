package Photo.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reader {
  private IAlbum model = new AlbumSystem();
  private Scanner s;

  public Reader(String readable) throws FileNotFoundException {
    this.s = new Scanner(new File(readable));
//    this.model = new AlbumSystem();
  }

  public IAlbum readFile() {
//    Scanner s = new Scanner(this.scan);
    s.useDelimiter("(\\n+|#.*)+");
    while (s.hasNext()) {
      String word = s.next();
      Scanner w = new Scanner(word);
//      w.useDelimiter(" ");
      String s = w.next().toLowerCase(Locale.ROOT);
      switch(s){
        case("shape"):
          this.model.createShape(w.next(), ShapeName.valueOf(w.next()), w.nextInt(),
                  w.nextInt(),w.nextInt(),w.nextInt(),w.nextInt(),w.nextInt(),w.nextInt());
          break;
        case("move") :
          this.model.setPosition(w.next(),w.nextInt(),w.nextInt());
          break;
        case("color"):
          this.model.changeColor(w.next(), w.nextInt(), w.nextInt(), w.nextInt());
          break;
        case("resize") :
          this.model.resize(w.next(), w.nextInt(), w.nextInt());
          break;
        case("remove") :
          this.model.remove(w.next());
          break;
        case("snapshot") :
          StringBuilder description = new StringBuilder();
          while(w.hasNext()){
            description.append(w.next()).append(" ");
          }
          this.model.takeSnapshot(description.toString());
          break;
      }
    }
    return this.model;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String dir = System.getProperty("user.dir");
//    Scanner scan = new Scanner(new File(dir + "/src/" + input));
    Reader reader = new Reader(dir + "/resources/" + "buildings.txt");
    IAlbum a = reader.readFile();
    System.out.println(a.getCanvas());
  }

}