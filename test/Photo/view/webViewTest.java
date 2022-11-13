package Photo.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import Photo.model.AlbumSystem;
import Photo.model.IAlbum;
import Photo.model.ShapeName;

import static org.junit.Assert.*;

public class webViewTest {
  IAlbum a;
  webView w;

  @Before
  public void setUp() throws Exception {
    a = new AlbumSystem();
    a.createShape("r", ShapeName.rectangle, 100,100,200,200,0,0,0);
    a.takeSnapshot("test");
  }

  @Test
  public void testToString() throws IOException {
    w = new webView(a,"test.html");
    assertEquals("<rect id=\"r\" x=\"100\" y=\"100\" width=\"200\" height=\"200\" fill=\"rgb(0,0,0)\" visibility=\"visible\"></rect>",w.toString());
  }
}