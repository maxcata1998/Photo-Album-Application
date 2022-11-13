package Photo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import Photo.model.AlbumSystem;
import Photo.model.IAlbum;
import Photo.model.Reader;
import Photo.model.Snapshot;
import Photo.view.swingWindow;
import Photo.view.webView;

public class controller implements ActionListener {
  int count = 0;
  IAlbum model;
  swingWindow view;

  public controller(IAlbum model, int width, int height) {
    this.model = model;
    this.view = new swingWindow(this.model.getSnapshots().get(0), width, height);
//    this.view.drawSnapShot(this.model.getSnapshots().get(count));
    this.view.setActionListener(this);
    this.view.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Prev":
        count -= 1;
        if (count < 0) {
          JOptionPane.showMessageDialog(this.view,
                  "Head of the photo album. No snapshots to show before this one.",
                  "message", JOptionPane.INFORMATION_MESSAGE);
          count += 1;
        } else {
          this.view.resetPanel(this.model.getSnapshots().get(count));
//          this.view.drawSnapShot(this.model.getSnapshots().get(count));
        }
        break;
      case "Next":
        count += 1;
        if (count > this.model.getSnapshots().size() - 1) {
          JOptionPane.showMessageDialog(this.view,
                  "End of the photo album. No snapshots to show beyond this one.",
                  "message", JOptionPane.INFORMATION_MESSAGE);
          count -= 1;
        } else {
          this.view.resetPanel(this.model.getSnapshots().get(count));
        }
        break;
      case "Select":
        ArrayList<String> SnapshotIDs = this.model.getSnapshotIDs();
        Object selectedID = JOptionPane.showInputDialog(this.view, "Choose", "Menu",
                JOptionPane.INFORMATION_MESSAGE, null,
                SnapshotIDs.toArray(), SnapshotIDs.get(0));
        int indexID = 0;
        for (int i = 0; i < SnapshotIDs.size(); i++) {
          if (SnapshotIDs.get(i) == selectedID) {
            indexID = i;
          }
        }
        this.view.resetPanel(this.model.getSnapshots().get(indexID));
        count = indexID;
        break;

      case "Quit":
        System.exit(0);
        break;
    }
  }
}


